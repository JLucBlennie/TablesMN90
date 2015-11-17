package com.jlb.plongee.ihm.panels.plongeur;

import java.util.ArrayList;
import java.util.List;

import com.jlb.plongee.ihm.Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class PlongeurCtrl implements Controller<PlongeurView> {

	PlongeurView view;

	public PlongeurCtrl() {
		view = new PlongeurView();
		init();
	}

	@Override
	public PlongeurView getView() {
		return view;
	}

	@Override
	public void init() {
		List<String> list = new ArrayList<String>();
		list.add("Plongee 1");
		list.add("Plongee 2");
		list.add("Plongee 3");
		list.add("Plongee 4");
		list.add("Plongee 5");

		ObservableList<String> plongees = FXCollections.observableList(list);

		view.plongeesListe.setItems(plongees);
		// view.setStyle("-fx-border-color: #3eFBFF;-fx-border-width: 2px;");

	}

}
