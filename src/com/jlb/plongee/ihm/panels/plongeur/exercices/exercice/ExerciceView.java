package com.jlb.plongee.ihm.panels.plongeur.exercices.exercice;

import com.jlb.plongee.application.MN90;
import com.jlb.plongee.datamodel.exercices.E_TYPE_EXERCICE;
import com.jlb.plongee.datamodel.exercices.E_TYPE_PLONGEE_EXERCICE;
import com.jlb.plongee.ihm.panels.plongees.PlongeesView;

import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class ExerciceView extends GridPane {

	private Label mPlongee1NameLabel = new Label(
			MN90.TABLES_MN90_PROPERTIES.getString("com.jlb.plongee.view.exercice.plongee1.name.label"));
	private TextField mPlongee1Name = new TextField("Plongee1");
	private Label mPlongee1TypeLabel = new Label(
			MN90.TABLES_MN90_PROPERTIES.getString("com.jlb.plongee.view.exercice.plongee1.type.label"));
	private ComboBox<String> mTypePlongee1 = new ComboBox<String>(
			FXCollections.observableList(E_TYPE_PLONGEE_EXERCICE.getNames()));

	private PlongeesView mPlongeesView;

	public ExerciceView(Pane plongeesView) {
		MN90.getLogger().debug(this, "Contruction de la vue Exercice");
		mPlongeesView = (PlongeesView) plongeesView;

		MN90.getLogger().debug(this, "Ajout des composants à la vue Exercice");
		this.add(mPlongeesView, 0, 0);
		this.add(initPlongeePane(), 2, 0);
		this.setPadding(new Insets(0, 0, 0, 50));
		this.setGridLinesVisible(MN90.AFFICHAGE_GRILLE);
	}

	private Pane initPlongeePane() {
		GridPane plongeePane = new GridPane();

		plongeePane.setVgap(5);
		plongeePane.setHgap(5);
		mPlongee1NameLabel.setPrefWidth(100);
		mPlongee1NameLabel.setMaxWidth(100);
		mPlongee1NameLabel.setMinWidth(100);
		plongeePane.add(mPlongee1NameLabel, 0, 0);
		mPlongee1Name.setPrefWidth(100);
		mPlongee1Name.setMaxWidth(100);
		mPlongee1Name.setMinWidth(100);
		plongeePane.add(mPlongee1Name, 1, 0);
		plongeePane.add(mPlongee1TypeLabel, 0, 1);
		plongeePane.add(mTypePlongee1, 1, 1);
		mTypePlongee1.setValue(E_TYPE_PLONGEE_EXERCICE.SIMPLE.getLabel());

		return plongeePane;

	}

	public void refreshWithType(E_TYPE_EXERCICE exoType) {
		// TODO : Ici on met les setVisible en fonction du type
		switch (exoType) {
		case CONSECUTIVE:
		case SUCCESSIVE:
			// TODO : On affiche tout ce qui concerne la plongee 2
			break;
		case SIMPLE:
		default:
			// TODO : On cache tout ce qui concerne la plongee 1
		}
	}

	public void setPlongee1Name(String name) {
		mPlongee1Name.setText(name);
	}

	public String getNamePlongee1() {
		return mPlongee1Name.getText();
	}

	public void setTypePlongee1(String type) {
		mTypePlongee1.setValue(type);
	}

	public String getTypeValuePlongee1() {
		return mTypePlongee1.getValue();
	}

	public ComboBox<String> getTypePlongee1() {
		return mTypePlongee1;
	}
}
