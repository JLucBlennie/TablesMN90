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
import com.jlb.tools.database.IDatabaseServices;
import com.jlb.tools.metamodel.Entity;
import com.jlb.tools.metamodel.attributes.IAttribute;
import com.jlb.tools.metamodel.criterion.ICriterion;

public class DatabaseServiceSQLite implements IDatabaseServices {

	private Statement mStatement;
	private Connection mConnection;

	public DatabaseServiceSQLite(String databasePath) {
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e) {
			MN90.getLogger().error(this, e.getMessage(), e);
		}

		try {
			// create a database connection
			mConnection = DriverManager.getConnection("jdbc:sqlite:" + databasePath + ".db");
			mStatement = mConnection.createStatement();
			mStatement.setQueryTimeout(30); // set timeout to 30 sec.

		} catch (SQLException e) {
			MN90.getLogger().error(this, e.getMessage(), e);
		}
	}

	@Override
	public void createDatabase(Entity description) {
		try {
			String attributes = "";
			for (int i = 0; i < description.getAttributes().size(); i++) {
				IAttribute attr = description.getAttributes().get(i);
				attributes += attr.getName() + " " + attr.getType().toLowerCase()
						+ ((i < description.getAttributes().size() - 1) ? "," : "");
			}
			mStatement.execute("drop table if exists " + description.getClass().getSimpleName());
			mStatement.executeUpdate("create table " + description.getClass().getSimpleName()
					+ " (Id integer,idParent integer,typeParent string,nbFils integer," + attributes + ")");
			// On s'occupe des fils
			for (Entity child : description.getChildren()) {
				createDatabase(child);
			}
		} catch (SQLException e) {
			MN90.getLogger().error(this, e.getMessage(), e);
		}

	}

	@Override
	public void storeObjects(List<Entity> objects) {
		try {
			for (Entity obj : objects) {
				String attributes = "";
				for (int i = 0; i < obj.getAttributes().size(); i++) {
					IAttribute attr = obj.getAttributes().get(i);
					attributes += "'" + attr.getValue() + "'" + ((i < obj.getAttributes().size() - 1) ? "," : "");
				}
				mStatement.executeUpdate("insert into " + obj.getClass().getSimpleName() + " values('" + obj.getId()
						+ "','" + (obj.getParent() != null ? obj.getParent().getId() : -1) + "','"
						+ (obj.getParent() != null ? obj.getParent().getClass().getSimpleName() : "") + "','"
						+ obj.getChildren().size() + "'," + attributes + ")");
				// On s'occupe des fils
				storeObjects(obj.getChildren());
			}
		} catch (SQLException e) {
			MN90.getLogger().error(this, e.getMessage(), e);
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
			while (rs.next()) {
				// read the result set
				// TODO : Voir comment retrouver la classe a partir du TableName
				// et la recuperation des fils
				Plongeur plongeur = new Plongeur(rs.getInt("Id"), rs.getString("Nom"));

				result.add(plongeur);
				MN90.getLogger().debug(this, plongeur.toString());
			}
		} catch (SQLException e) {
			MN90.getLogger().error(this, e.getMessage(), e);
		}
		return result;
	}

	@Override
	public void deleteObjects(List<Entity> objects) {
		try {
			for (Entity obj : objects) {
				String attributes = "";
				for (int i = 0; i < obj.getAttributes().size(); i++) {
					IAttribute attr = obj.getAttributes().get(i);
					attributes += attr.getName() + "='" + attr.getValue() + "'"
							+ ((i < obj.getAttributes().size() - 1) ? " and " : "");
				}
				mStatement.executeUpdate("delete from " + obj.getClass().getSimpleName() + " where " + attributes);
				// TODO : Gerer la suppression des fils
			}
		} catch (SQLException e) {
			MN90.getLogger().error(this, e.getMessage(), e);
		}
	}

	@Override
	public void endService() {
		if (mConnection != null) {
			try {
				mConnection.close();
			} catch (SQLException e) {
				MN90.getLogger().error(this, e.getMessage(), e);
			}
		}
	}

}
