package com.jlb.tools.metamodel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe decrivant le modele de donnees
 * 
 * @author JLuc
 *
 */
public abstract class Version {

	protected static List<Class<? extends Entity>> mClazzs = new ArrayList<Class<? extends Entity>>();

	protected Description mDescription;

	public Version() {
		mDescription = new Description(mClazzs);
	}

	public Description getDescription() {
		return mDescription;
	}

	public abstract Entity createEntity(String className, ResultSet rs) throws SQLException;

	public abstract Link createLink(Entity src, Entity dest);
}
