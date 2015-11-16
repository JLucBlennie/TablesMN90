package com.jlb.plongee.ihm.impl;

import java.util.ArrayList;
import java.util.List;

import com.jlb.plongee.ihm.Controller;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class MN90Ctrl implements Controller<MN90View> {

	private MN90View view = new MN90View();

	public MN90Ctrl() {
		init();
	}

	@Override
	public MN90View getView() {
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
		view.setStyle("-fx-border-color: #2e8b57;-fx-border-width: 2px;");
		view.plongeurPane.setStyle("-fx-border-color: #3eFBFF;-fx-border-width: 2px;");
		view.compartimentPane.setStyle("-fx-border-color: #FFFB3E;-fx-border-width: 2px;");
		view.exitButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				Platform.exit();
				System.exit(0);
			}

		});
	}

}
