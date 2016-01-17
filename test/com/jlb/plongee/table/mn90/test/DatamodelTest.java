package com.jlb.plongee.table.mn90.test;

import org.junit.Test;

import com.jlb.plongee.datamodel.Plongeur;
import com.jlb.plongee.datamodel.exercices.E_TYPE_EXERCICE;
import com.jlb.plongee.datamodel.exercices.Exercice;

public class DatamodelTest {

	@Test
	public void test() {
		Plongeur plongeur = new Plongeur(0, "JLuc");
		Exercice exo1 = new Exercice(0, "Exercice 1", E_TYPE_EXERCICE.SIMPLE);
		plongeur.addExercice(exo1);
	}

}
