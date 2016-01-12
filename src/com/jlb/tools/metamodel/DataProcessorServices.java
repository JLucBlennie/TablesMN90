package com.jlb.tools.metamodel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jlb.plongee.application.MN90;
import com.jlb.tools.database.IDatabaseServices;
import com.jlb.tools.metamodel.attributes.IAttribute;
import com.jlb.tools.metamodel.criterion.E_OPERATOR;
import com.jlb.tools.metamodel.criterion.ICriterion;
import com.jlb.tools.metamodel.criterion.impl.IntegerCriterion;

/**
 * Classe decrivant le modele de donnees Elle permet aussi d'acceder aux donnees
 * 
 * @author JLuc
 *
 */
public abstract class DataProcessorServices implements IDataProcessorServices {

	protected static List<Class<? extends Entity>> mClazzs = new ArrayList<Class<? extends Entity>>();

	protected Description mDescription;

	protected IDatabaseServices mDatabaseServices;

	// Il faut garder en memoire les objets charges lors des
	// requetes pour ne pas creer les objets plusieurs fois...
	// Gestion des Entities chargees, la clef est le nom de la table (nom simple
	// de la classe) et l'Id
	protected Map<String, Entity> mCacheEntities = new HashMap<String, Entity>();
	// Gestion du chache des liens, la clef est le nom de la table + id de la
	// source et le nom de la table et l'Id de la destination.
	protected Map<String, Link> mCacheLinks = new HashMap<String, Link>();

	public DataProcessorServices() {
		mDescription = new Description(mClazzs);
	}

	public Description getDescription() {
		return mDescription;
	}

	protected abstract Entity createEntity(String className, ResultSet rs) throws SQLException;

	protected Link createLink(Entity src, Entity dest) {
		return new Link(src, dest);
	}

	@Override
	public void createDatabase() {
		for (String className : mDescription.getClasseNames()) {
			Entity entityDesc = null;
			try {
				Class<Entity> clazz = (Class<Entity>) ClassLoader.getSystemClassLoader().loadClass(className);
				entityDesc = clazz.newInstance();
				MN90.getLogger().info(this, "Creation du schema de la base de donnees " + entityDesc.getTableName());
				createTable(entityDesc);
			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
				MN90.getLogger().error(this, "Erreur lors de la creation de la table " + entityDesc.getTableName(), e);
			}
		}
		// On s'occupe des Liens
		MN90.getLogger().info(this, "Suppression de la table des lien");
		try {
			mDatabaseServices.dropTable("Link");

			MN90.getLogger().info(this, "Creation de la table des liens");
			String attrs = " (idSrc integer,typeSrc string,idDest integer,typeDest string)";
			mDatabaseServices.createTable("Link", attrs);
		} catch (SQLException e) {
			MN90.getLogger().error(this, "Erreur lors de la creation de la table des liens", e);
		}
	}

	@Override
	public void storeEntities(List<Entity> entities) {
		for (Entity obj : entities) {
			try {
				String tableName = mDescription.getTableName(obj.getClass().getName());
				String parentTableName = obj.getParent() != null
						? mDescription.getTableName(obj.getParent().getClass().getName()) : "";
				String attributes = "";
				for (int i = 0; i < obj.getAttributes().size(); i++) {
					IAttribute attr = obj.getAttributes().get(i);
					attributes += "'" + attr.getValue() + "'" + ((i < obj.getAttributes().size() - 1) ? "," : "");
				}
				MN90.getLogger().info(this, "Recuperation des attributs de l'objet " + obj + " -> " + attributes);

				MN90.getLogger().info(this, "Persistence des attributs de l'objet " + obj);
				String values = obj.getId() + "','" + (obj.getParent() != null ? obj.getParent().getId() : -1) + "','"
						+ parentTableName + "','" + obj.getChildren().size()
						+ (attributes.isEmpty() ? "'" : "'," + attributes);
				mDatabaseServices.insertData(tableName, values);
				// On s'occupe des fils
				MN90.getLogger().info(this, "Persistence des fils de l'objet " + obj);
				storeEntities(obj.getChildren());

				// On ajoute l'entity dans le cache
				mCacheEntities.put(obj.getTableName() + "_" + obj.getId(), obj);

				// On s'occupe des liens
				for (Link lnk : obj.getLinks()) {
					String valuesLink = lnk.getSource().getId() + "','" + lnk.getSource().getTableName() + "','"
							+ lnk.getDestination().getId() + "','" + lnk.getDestination().getTableName();
					mDatabaseServices.insertData("Link", valuesLink);
					// On ajoute le lien dans le cache
					mCacheLinks.put(lnk.getSource().getTableName() + "_" + lnk.getSource().getId() + "_"
							+ lnk.getDestination().getTableName() + "_" + lnk.getDestination().getId(), lnk);
				}

				MN90.getLogger().info(this, "Persistence des liens de l'objet " + obj);
			} catch (SQLException e) {
				MN90.getLogger().error(this, "Erreur lors de la persistence de l'objet " + obj, e);
			}
		}
	}

	@Override
	public List<Entity> requestEntities(ICriterion criterion) {
		List<Entity> result = new ArrayList<Entity>();
		String tableName = criterion.getTableName();
		String attrName = criterion.getAttributeName();

		// On cherche dans le cache
		for (String key : mCacheEntities.keySet()) {
			if (key.contains(tableName)) {
				Entity ent = mCacheEntities.get(key);
				if (criterion.getOperator() == E_OPERATOR.EQUALS) {
					if (ent.getAttribute(attrName).getValue() == criterion.getValue()) {
						result.add(ent);
					}
				} else if (criterion.getOperator() == E_OPERATOR.GREATER) {
					if (ent.getAttribute(attrName).getType().equalsIgnoreCase("integer")) {
						if ((int) ent.getAttribute(attrName).getValue() > (int) criterion.getValue()) {
							result.add(ent);
						}
					} else if (ent.getAttribute(attrName).getType().equalsIgnoreCase("double")) {
						if ((double) ent.getAttribute(attrName).getValue() > (double) criterion.getValue()) {
							result.add(ent);
						}
					} else {
						MN90.getLogger().error(this, "Le critere de recherche n'est pas pris en compte " + criterion,
								null);
					}
				} else if (criterion.getOperator() == E_OPERATOR.LOWER) {
					if (ent.getAttribute(attrName).getType().equalsIgnoreCase("integer")) {
						if ((int) ent.getAttribute(attrName).getValue() < (int) criterion.getValue()) {
							result.add(ent);
						}
					} else if (ent.getAttribute(attrName).getType().equalsIgnoreCase("double")) {
						if ((double) ent.getAttribute(attrName).getValue() < (double) criterion.getValue()) {
							result.add(ent);
						}
					} else {
						MN90.getLogger().error(this, "Le critere de recherche n'est pas pris en compte " + criterion,
								null);
					}
				}
			}
		}

		// on recherche en base
		ResultSet rs;
		try {
			if (attrName == null) {
				rs = mDatabaseServices.executeSelectFrom(tableName);
			} else {
				rs = mDatabaseServices.executeSelectFromWhere(tableName,
						attrName + " " + criterion.getOperator() + " '" + criterion.getValue() + "'");
			}

			Class<Entity> tableClass = (Class<Entity>) Class.forName(mDescription.getClassName(tableName));
			Entity entity = null;
			while (rs.next()) {
				String tableClassName = tableClass.getName();
				entity = createEntity(tableClassName, rs);
				if (!mCacheEntities.containsKey(entity.getTableName() + "_" + entity.getId())) {
					mCacheEntities.put(entity.getTableName() + "_" + entity.getId(), entity);
					result.add(entity);
					// On doit s'occuper des fils
					if (rs.getInt("nbFils") > 0) {
						for (Class childClass : entity.getAuthorizedChildrenClass()) {
							ICriterion<Integer> childrenIdCriterion = new IntegerCriterion(
									mDescription.getTableName(childClass.getName()), "idParent", E_OPERATOR.EQUALS,
									entity.getId());
							for (Entity ent : requestEntities(childrenIdCriterion)) {
								ent.setParent(entity);
								entity.getChildren().add(ent);
							}
						}
					}
				} else {
					result.add(mCacheEntities.get(entity.getTableName() + "_" + entity.getId()));
				}
			}
		} catch (SQLException | ClassNotFoundException | SecurityException e) {
			MN90.getLogger().error(this, "Erreur lors de la requete " + criterion, e);
		}
		return result;
	}

	@Override
	public List<Link> requestLinks(Entity entity) {
		List<Link> links = new ArrayList<Link>();
		// On cherche dans le cache des liens.
		int idEntity = entity.getId();
		String entityTableName = entity.getTableName();
		for (String linkId : mCacheLinks.keySet()) {
			if (linkId.contains(entityTableName + "_" + idEntity)) {
				links.add(mCacheLinks.get(linkId));
			}
		}

		// Recuperer les liens qui ont pour source ou destination l'entite src
		try {
			ResultSet rs = mDatabaseServices.executeSelectFromWhere("Link",
					"idSrc='" + entity.getId() + "' or  idDest='" + entity.getId() + "'");
			while (rs.next()) {
				// On recherche l'entite destination
				int idSrc = rs.getInt("idSrc");
				String typeSrc = rs.getString("typeSrc");
				int idDest = rs.getInt("idDest");
				String typeDest = rs.getString("typeDest");
				if (idSrc == entity.getId()) {
					Class<Entity> tableClass = (Class<Entity>) Class.forName(mDescription.getClassName(typeDest));
					ICriterion criterionDest = new IntegerCriterion(typeDest, "Id", E_OPERATOR.EQUALS, idDest);
					List<Entity> listDest = requestEntities(criterionDest);
					for (Entity dest : listDest) {
						links.add(new Link(entity, dest));
					}
				} else if (idDest == entity.getId()) {
					Class<Entity> tableClass = (Class<Entity>) Class.forName(mDescription.getClassName(typeSrc));
					ICriterion criterion = new IntegerCriterion(typeSrc, "Id", E_OPERATOR.EQUALS, idSrc);
					List<Entity> listEntity = requestEntities(criterion);
					for (Entity src : listEntity) {
						links.add(new Link(src, entity));
					}
				}
			}
		} catch (SQLException | ClassNotFoundException e) {
			MN90.getLogger().error(this, "Erreur lors de la requete sur les liens depuis " + entity, e);
		}
		return links;
	}

	@Override
	public void deleteObjects(List<Entity> objects) {
		for (Entity obj : objects) {
			try {
				mDatabaseServices.deleteDataWhere(mDescription.getTableName(obj.getClass().getName()),
						"Id='" + obj.getId() + "'");
				// On doit s'occuper des fils
				if (obj.getChildren().size() > 0) {
					for (Class childClass : obj.getAuthorizedChildrenClass()) {
						ICriterion<Integer> childrenIdCriterion = new IntegerCriterion(
								mDescription.getTableName(childClass.getName()), "idParent", E_OPERATOR.EQUALS,
								obj.getId());
						deleteObjects(requestEntities(childrenIdCriterion));
					}
				}

				// On doit s'occuper des liens
				// Recuperation des liens qui pointent obj
				List<Link> links = requestLinks(obj);
				deleteLinks(links);
			} catch (SQLException e) {
				MN90.getLogger().error(this, "Erreur lors de la suppression de l'objet " + obj, e);
			}
		}
	}

	@Override
	public void deleteLinks(List<Link> links) {
		for (Link link : links) {
			try {
				mDatabaseServices.deleteDataWhere("Link",
						"idSrc='" + link.getSource().getId() + "' and idDest='" + link.getDestination().getId() + "'");
			} catch (SQLException e) {
				MN90.getLogger().error(this, "Erreur lors de la suppression du lien " + link, e);
			}
		}
	}

	private void createTable(Entity tableDesc) {
		String tableName = mDescription.getTableName(tableDesc.getClass().getName());
		try {
			// Recuperation des attributs
			String attributes = "";
			for (int i = 0; i < tableDesc.getAttributes().size(); i++) {
				IAttribute attr = tableDesc.getAttributes().get(i);
				attributes += attr.getName() + " " + attr.getType().toLowerCase()
						+ ((i < tableDesc.getAttributes().size() - 1) ? "," : "");
			}
			MN90.getLogger().info(this, "Recuperation des attributs de " + tableName + " -> " + attributes);

			MN90.getLogger().info(this, "Suppression de la table " + tableName);
			mDatabaseServices.dropTable(tableName);

			MN90.getLogger().info(this, "Creation de la table " + tableName);
			String attrs = " (Id integer,idParent integer,typeParent string,nbFils integer"
					+ (attributes.isEmpty() ? "" : "," + attributes) + ")";
			mDatabaseServices.createTable(tableName, attrs);

		} catch (SQLException e) {
			MN90.getLogger().error(this, "Erreur lors de la creation de la table " + tableName, e);
		}
	}

	@Override
	public void endDatabaseService() {
		try {
			mDatabaseServices.endService();
		} catch (SQLException e) {
			MN90.getLogger().error(this, "Erreur lors de la fermerture de la base de donnee", e);
		}
	}
}
