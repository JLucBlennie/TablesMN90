package com.jlb.plongee.table.mn90.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.jlb.plongee.datamodel.Plongeur;
import com.jlb.plongee.datamodel.exercices.Exercice;
import com.jlb.plongee.datamodel.exercices.E_TYPE_EXERCICE;
import com.jlb.tools.database.impl.DatabaseServiceSQLite;
import com.jlb.tools.metamodel.Entity;
import com.jlb.tools.metamodel.criterion.E_OPERATOR;
import com.jlb.tools.metamodel.criterion.impl.AllCriterion;
import com.jlb.tools.metamodel.criterion.impl.IntegerCriterion;

public class DatabaseTests {

	@Test
	public void testDatabase() {
		DatabaseServiceSQLite mService = new DatabaseServiceSQLite("database/mn90.db");
		Plongeur plongeur = new Plongeur(0, "Moi");
		plongeur.ajouterExercice(new Exercice(0, "Exercice 1", E_TYPE_EXERCICE.UNE_PLONGEE));
		mService.createDatabase(plongeur);
		List<Entity> objects = new ArrayList<Entity>();
		objects.add(plongeur);
		Plongeur plongeur2 = new Plongeur(2, "Toi");
		plongeur2.ajouterExercice(new Exercice(1, "Exercice 2", E_TYPE_EXERCICE.UNE_PLONGEE));
		plongeur2.ajouterExercice(new Exercice(2, "Exercice 3", E_TYPE_EXERCICE.UNE_PLONGEE));
		objects.add(plongeur2);
		mService.storeObjects(objects);
		List<Entity> list = mService
				.requestObjects(new IntegerCriterion(Plongeur.class.getSimpleName(), "Id", E_OPERATOR.EQUALS, 2));
		for (Entity entity : list) {
			System.out.println(entity);
		}
		List<Entity> objToDelete = new ArrayList<Entity>();
		objToDelete.add(objects.get(1));
		mService.deleteObjects(objToDelete);
		list = mService.requestObjects(new AllCriterion(Plongeur.class.getSimpleName()));
		for (Entity entity : list) {
			System.out.println(entity);
		}
		mService.endService();
	}
}
