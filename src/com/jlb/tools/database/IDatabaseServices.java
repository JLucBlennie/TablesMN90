package com.jlb.tools.database;

import java.util.List;

import com.jlb.tools.metamodel.Entity;
import com.jlb.tools.metamodel.Link;
import com.jlb.tools.metamodel.criterion.ICriterion;

public interface IDatabaseServices {

	public void createDatabase();

	public void storeObjects(List<Entity> objects);

	public List<Entity> requestObjects(ICriterion criterion);

	public List<Link> requestLinks(Entity src);

	public void deleteObjects(List<Entity> objects);

	public void endService();
}
