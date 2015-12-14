package com.jlb.tools.database.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jlb.plongee.application.MN90;
import com.jlb.plongee.datamodel.Plongeur;
import com.jlb.plongee.datamodel.exercices.E_TYPE_EXERCICE;
import com.jlb.plongee.datamodel.exercices.Exercice;
import com.jlb.tools.database.IDatabaseServices;
import com.jlb.tools.metamodel.Description;
import com.jlb.tools.metamodel.Entity;
import com.jlb.tools.metamodel.Link;
import com.jlb.tools.metamodel.attributes.IAttribute;
import com.jlb.tools.metamodel.criterion.E_OPERATOR;
import com.jlb.tools.metamodel.criterion.ICriterion;
import com.jlb.tools.metamodel.criterion.impl.IntegerCriterion;

public class DatabaseServiceSQLite implements IDatabaseServices {

	private Statement mStatement;
	private Connection mConnection;
	private Description mDescription;

	public DatabaseServiceSQLite(String databasePath, Description description) {
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e) {
			MN90.getLogger().error(this, "Erreur lors de la connexion a la base de donnees " + databasePath, e);
		}

		try {
			// create a database connection
			MN90.getLogger().info(this, "Creation de la connexion a la base de donnees " + databasePath);
			mConnection = DriverManager.getConnection("jdbc:sqlite:" + databasePath);
			mStatement = mConnection.createStatement();
			mStatement.setQueryTimeout(30); // set timeout to 30 sec.

		} catch (SQLException e) {
			MN90.getLogger().error(this, "Erreur lors de la connexion a la base de donnees " + databasePath, e);
		}

		mDescription = description;
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
			mStatement.execute("drop table if exists Link");

			MN90.getLogger().info(this, "Creation de la table des liens");
			String attrs = " (idSrc integer,typeSrc string,idDest integer,typeDest string)";
			mStatement.executeUpdate("create table Link" + attrs);
		} catch (SQLException e) {
			MN90.getLogger().error(this, "Erreur lors de la creation de la table des liens", e);
		}
	}

	public void createTable(Entity tableDesc) {
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
			mStatement.execute("drop table if exists " + tableName);

			MN90.getLogger().info(this, "Creation de la table " + tableName);
			String attrs = " (Id integer,idParent integer,typeParent string,nbFils integer"
					+ (attributes.isEmpty() ? "" : "," + attributes) + ")";
			mStatement.executeUpdate("create table " + tableName + attrs);

		} catch (SQLException e) {
			MN90.getLogger().error(this, "Erreur lors de la creation de la table " + tableName, e);
		}
	}

	@Override
	public void storeObjects(List<Entity> objects) {
		for (Entity obj : objects) {
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
				mStatement.executeUpdate("insert into " + tableName + " values('" + obj.getId() + "','"
						+ (obj.getParent() != null ? obj.getParent().getId() : -1) + "','" + parentTableName + "','"
						+ obj.getChildren().size() + (attributes.isEmpty() ? "'" : "'," + attributes) + ")");
				// On s'occupe des fils
				MN90.getLogger().info(this, "Persistence des fils de l'objet " + obj);
				storeObjects(obj.getChildren());

				// On s'occupe des liens
				for (Link lnk : obj.getLinks()) {
					mStatement.executeUpdate("insert into Link values('" + lnk.getSource().getId() + "','"
							+ lnk.getSource().getId() + "','" + lnk.getDestination().getId() + "','"
							+ lnk.getDestination().getTableName() + ")");
				}

				MN90.getLogger().info(this, "Persistence des liens de l'objet " + obj);
			} catch (SQLException e) {
				MN90.getLogger().error(this, "Erreur lors de la persistence de l'objet " + obj, e);
			}
		}
	}

	@Override
	public List<Entity> requestObjects(ICriterion criterion) {
		List<Entity> result = new ArrayList<Entity>();
		ResultSet rs;
		try {
			if (criterion.getAttributeName() == null) {
				rs = mStatement.executeQuery("select * from " + criterion.getTableName());
			} else {
				rs = mStatement.executeQuery(
						"select * from " + criterion.getTableName() + " where " + criterion.getAttributeName() + " "
								+ criterion.getOperator() + " '" + criterion.getValue() + "'");
			}

			Class<Entity> tableClass = (Class<Entity>) Class
					.forName(mDescription.getClassName(criterion.getTableName()));
			Entity entity = null;
			while (rs.next()) {
				// TODO : Remettre en place la creation des objets a partir des
				// requetes.
				String tableClassName = tableClass.getName();
				if (tableClassName.equals(Plongeur.class.getName())) {
					entity = new Plongeur(rs.getInt("Id"), rs.getString(Plongeur.ATTRIBUTE_NAME));
				} else if (tableClassName.equals(Exercice.class.getName())) {
					entity = new Exercice(rs.getInt("Id"), rs.getString(Exercice.ATTRIBUTE_NAME),
							E_TYPE_EXERCICE.valueOf(rs.getString(Exercice.ATTRIBUTE_TYPE)));
				}

				result.add(entity);
				MN90.getLogger().debug(this, entity.toString());
				// On doit s'occuper des fils
				if (rs.getInt("nbFils") > 0) {
					for (Class childClass : entity.getAuthorizedChildrenClass()) {
						ICriterion<Integer> childrenIdCriterion = new IntegerCriterion(
								mDescription.getTableName(childClass.getName()), "idParent", E_OPERATOR.EQUALS,
								entity.getId());
						for (Entity ent : requestObjects(childrenIdCriterion)) {
							ent.setParent(entity);
							entity.getChildren().add(ent);
						}
					}
				}

				// TODO : On doit s'occuper des liens dont la source est entity
			}
		} catch (SQLException | ClassNotFoundException | SecurityException e) {
			MN90.getLogger().error(this, e.getMessage(), e);
		}
		return result;
	}

	@Override
	public List<Link> requestLinks(Entity src) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteObjects(List<Entity> objects) {
		for (Entity obj : objects) {
			try {
				mStatement.executeUpdate("delete from " + mDescription.getTableName(obj.getClass().getName())
						+ " where Id='" + obj.getId() + "'");
				// On doit s'occuper des fils
				if (obj.getChildren().size() > 0) {
					for (Class childClass : obj.getAuthorizedChildrenClass()) {
						ICriterion<Integer> childrenIdCriterion = new IntegerCriterion(
								mDescription.getTableName(childClass.getName()), "idParent", E_OPERATOR.EQUALS,
								obj.getId());
						deleteObjects(requestObjects(childrenIdCriterion));
					}
				}

				// TODO : On doit s'occuper des liens
			} catch (SQLException e) {
				MN90.getLogger().error(this, "Erreur lors de la suppression de l'objet " + obj, e);
			}
		}
	}

	@Override
	public void endService() {
		if (mConnection != null) {
			try {
				mConnection.close();
			} catch (SQLException e) {
				MN90.getLogger().error(this, "Erreur lors de la fermerture de la base de donnee", e);
			}
		}
	}
}
