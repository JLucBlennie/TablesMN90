package com.jlb.plongee.table.mn90.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.jlb.plongee.datamodel.Plongeur;
import com.jlb.tools.database.impl.DatabaseServiceSQLite;
import com.jlb.tools.metamodel.Entity;
import com.jlb.tools.metamodel.criterion.E_OPERATOR;
import com.jlb.tools.metamodel.criterion.impl.AllCriterion;
import com.jlb.tools.metamodel.criterion.impl.IntegerCriterion;

public class DatabaseTests {

	@Test
	public void testDatabase() {
		DatabaseServiceSQLite mService = new DatabaseServiceSQLite("database/mn90");
		mService.createDatabase();
		List<Entity> objects = new ArrayList<Entity>();
		objects.add(new Plongeur(1, "Moi"));
		objects.add(new Plongeur(2, "Toi"));
		mService.storeObjects(objects);
		List<Plongeur> list = (List<Plongeur>) mService
				.requestObjects(new IntegerCriterion(Plongeur.class.getSimpleName(), "Id", E_OPERATOR.EQUALS, 2));
		for (Plongeur plongeur : list) {
			System.out.println(plongeur);
		}
		List<Entity> objToDelete = new ArrayList<Entity>();
		objToDelete.add(objects.get(1));
		mService.deleteObjects(objToDelete);
		list = (List<Plongeur>) mService.requestObjects(new AllCriterion(Plongeur.class.getSimpleName()));
		for (Plongeur plongeur : list) {
			System.out.println(plongeur);
		}
		mService.endService();
	}
}
