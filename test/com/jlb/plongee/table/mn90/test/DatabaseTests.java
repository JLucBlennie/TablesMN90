package com.jlb.plongee.table.mn90.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.jlb.plongee.datamodel.MN90DataProcessorServices;
import com.jlb.plongee.datamodel.Plongeur;
import com.jlb.plongee.datamodel.exercices.E_TYPE_EXERCICE;
import com.jlb.plongee.datamodel.exercices.Exercice;
import com.jlb.plongee.datamodel.logbook.Participant;
import com.jlb.tools.metamodel.DataProcessorServices;
import com.jlb.tools.metamodel.Entity;
import com.jlb.tools.metamodel.criterion.E_OPERATOR;
import com.jlb.tools.metamodel.criterion.impl.AllCriterion;
import com.jlb.tools.metamodel.criterion.impl.IntegerCriterion;

public class DatabaseTests {

	@Test
	public void testDatabase() {
		List<Class<? extends Entity>> clazzs = new ArrayList<Class<? extends Entity>>();
		clazzs.add(Plongeur.class);
		clazzs.add(Participant.class);
		DataProcessorServices dpServices = new MN90DataProcessorServices("database/mn90.db");
		dpServices.createDatabase();
		Plongeur plongeur = new Plongeur(0, "Moi");
		plongeur.addExercice(new Exercice(0, "Exercice 1", E_TYPE_EXERCICE.UNE_PLONGEE));
		List<Entity> objects = new ArrayList<Entity>();
		objects.add(plongeur);
		Plongeur plongeur2 = new Plongeur(2, "Toi");
		plongeur2.addExercice(new Exercice(1, "Exercice 2", E_TYPE_EXERCICE.UNE_PLONGEE));
		plongeur2.addExercice(new Exercice(2, "Exercice 3", E_TYPE_EXERCICE.UNE_PLONGEE));
		objects.add(plongeur2);
		dpServices.storeObjects(objects);
		List<Entity> list = dpServices
				.requestEntities(new IntegerCriterion(Plongeur.class.getSimpleName(), "Id", E_OPERATOR.EQUALS, 2));
		for (Entity entity : list) {
			System.out.println(entity);
		}
		List<Entity> objToDelete = new ArrayList<Entity>();
		objToDelete.add(objects.get(1));
		dpServices.deleteObjects(objToDelete);
		list = dpServices.requestEntities(new AllCriterion(Plongeur.class.getSimpleName()));
		for (Entity entity : list) {
			System.out.println(entity);
		}
		dpServices.endDatabaseService();
	}
}
