package com.jlb.tools.database;

import java.util.List;

import com.jlb.tools.metamodel.Entity;
import com.jlb.tools.metamodel.criterion.ICriterion;

public interface IDatabaseServices {

	public void createDatabase();

	public void storeObjects(List<? extends Entity> objects);

	public List<? extends Entity> requestObjects(ICriterion criterion);

	public void deleteObjects(List<? extends Entity> objects);

	public void endService();
}
