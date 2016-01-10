package com.jlb.plongee.datamodel;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.jlb.plongee.application.MN90;
import com.jlb.plongee.datamodel.exercices.E_TYPE_EXERCICE;
import com.jlb.plongee.datamodel.exercices.E_TYPE_PLONGEE_EXERCICE;
import com.jlb.plongee.datamodel.exercices.Exercice;
import com.jlb.plongee.datamodel.logbook.E_NIVEAU;
import com.jlb.plongee.datamodel.logbook.E_TYPE_ENVIRONNEMENT;
import com.jlb.plongee.datamodel.logbook.E_TYPE_LIEU;
import com.jlb.plongee.datamodel.logbook.E_TYPE_THEME;
import com.jlb.plongee.datamodel.logbook.LogBook;
import com.jlb.plongee.datamodel.logbook.Participant;
import com.jlb.plongee.datamodel.logbook.Site;
import com.jlb.plongee.datamodel.plongees.PlongeeExercice;
import com.jlb.plongee.datamodel.plongees.PlongeeLogBook;
import com.jlb.plongee.datamodel.tools.Localisation;
import com.jlb.tools.database.impl.DatabaseServiceSQLite;
import com.jlb.tools.metamodel.DataProcessorServices;
import com.jlb.tools.metamodel.Entity;

/**
 * Classe decrivant le modele de donnees du logiciel MN90 sur une base de
 * donnees SQLite
 * 
 * @author JLuc
 *
 */
public class MN90DataProcessorServices extends DataProcessorServices {

	static {
		mClazzs.add(Plongeur.class);
		mClazzs.add(Participant.class);
		mClazzs.add(Site.class);
	}

	public MN90DataProcessorServices(String databasePath) {
		super();
		try {
			mDatabaseServices = new DatabaseServiceSQLite(databasePath);
		} catch (SQLException | ClassNotFoundException e) {
			MN90.getLogger().error(this, "Erreur lors de la connexion a la base de donnees " + databasePath, e);
		}
	}

	@Override
	protected Entity createEntity(String className, ResultSet rs) throws SQLException {
		Entity entity = null;
		if (className.equals(Plongeur.class.getName())) {
			entity = new Plongeur(rs.getInt("Id"), rs.getString(Plongeur.ATTRIBUTE_NAME));
		} else if (className.equals(Exercice.class.getName())) {
			entity = new Exercice(rs.getInt("Id"), rs.getString(Exercice.ATTRIBUTE_NAME),
					E_TYPE_EXERCICE.values()[rs.getInt(Exercice.ATTRIBUTE_TYPE)]);
		} else if (className.equals(LogBook.class.getName())) {
			entity = new LogBook(rs.getInt("Id"));
		} else if (className.equals(PlongeeLogBook.class.getName())) {
			entity = new PlongeeLogBook(rs.getInt("Id"), rs.getString(PlongeeLogBook.ATTRIBUTE_NAME),
					rs.getInt(PlongeeLogBook.ATTRIBUTE_PROFONDEUR), rs.getInt(PlongeeLogBook.ATTRIBUTE_TEMPS_PLONGEES),
					E_TYPE_THEME.values()[rs.getInt(PlongeeLogBook.ATTRIBUT_THEME)],
					E_TYPE_ENVIRONNEMENT.values()[rs.getInt(PlongeeLogBook.ATTRIBUT_ENVIRONNEMENT)],
					E_TYPE_LIEU.values()[rs.getInt(PlongeeLogBook.ATTRIBUT_LIEU)]);
		} else if (className.equals(PlongeeExercice.class.getName())) {
			entity = new PlongeeExercice(rs.getInt("Id"), rs.getString(PlongeeExercice.ATTRIBUTE_NAME),
					rs.getInt(PlongeeExercice.ATTRIBUTE_PROFONDEUR),
					rs.getInt(PlongeeExercice.ATTRIBUTE_TEMPS_PLONGEES),
					E_TYPE_PLONGEE_EXERCICE.values()[rs.getInt(PlongeeExercice.ATTRIBUT_TYPE)]);
		} else if (className.equals(Site.class.getName())) {
			entity = new Site(rs.getInt("Id"), rs.getString(Site.ATTRIBUT_NAME),
					new Localisation(rs.getDouble(Site.ATTRIBUT_LOCALISATION_LATITUDE),
							rs.getDouble(Site.ATTRIBUT_LOCALISATION_LONGITUDE)));
		} else if (className.equals(Participant.class.getName())) {
			entity = new Participant(rs.getInt("Id"), rs.getString(Participant.ATTRIBUT_NAME),
					E_NIVEAU.values()[rs.getInt(Participant.ATTRIBUT_NIVEAU)]);
		} else {
			MN90.getLogger().info(this, "Le type d'entite " + className + " n'est pas pris en charge !!! ");
		}
		return entity;
	}

}
