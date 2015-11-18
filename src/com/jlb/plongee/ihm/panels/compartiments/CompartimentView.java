package com.jlb.plongee.ihm.panels.compartiments;

import com.jlb.plongee.application.MN90;
import com.jlb.plongee.ihm.widget.UpwardProgress;

import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;

public class CompartimentView extends GridPane {

	private UpwardProgress mComp5minProgressBar = new UpwardProgress(
			MN90.TABLES_MN90_PROPERTIES.getString("com.jlb.plongee.view.compartiment.comp5minprogress"), 25, 100);
	private UpwardProgress mComp7minProgressBar = new UpwardProgress(
			MN90.TABLES_MN90_PROPERTIES.getString("com.jlb.plongee.view.compartiment.comp7minprogress"), 25, 100);
	private UpwardProgress mComp10minProgressBar = new UpwardProgress(
			MN90.TABLES_MN90_PROPERTIES.getString("com.jlb.plongee.view.compartiment.comp10minprogress"), 25, 100);
	private UpwardProgress mComp15minProgressBar = new UpwardProgress(
			MN90.TABLES_MN90_PROPERTIES.getString("com.jlb.plongee.view.compartiment.comp15minprogress"), 25, 100);
	private UpwardProgress mComp20minProgressBar = new UpwardProgress(
			MN90.TABLES_MN90_PROPERTIES.getString("com.jlb.plongee.view.compartiment.comp20minprogress"), 25, 100);
	private UpwardProgress mComp30minProgressBar = new UpwardProgress(
			MN90.TABLES_MN90_PROPERTIES.getString("com.jlb.plongee.view.compartiment.comp30minprogress"), 25, 100);
	private UpwardProgress mComp40minProgressBar = new UpwardProgress(
			MN90.TABLES_MN90_PROPERTIES.getString("com.jlb.plongee.view.compartiment.comp40minprogress"), 25, 100);
	private UpwardProgress mComp50minProgressBar = new UpwardProgress(
			MN90.TABLES_MN90_PROPERTIES.getString("com.jlb.plongee.view.compartiment.comp50minprogress"), 25, 100);
	private UpwardProgress mComp60minProgressBar = new UpwardProgress(
			MN90.TABLES_MN90_PROPERTIES.getString("com.jlb.plongee.view.compartiment.comp60minprogress"), 25, 100);
	private UpwardProgress mComp80minProgressBar = new UpwardProgress(
			MN90.TABLES_MN90_PROPERTIES.getString("com.jlb.plongee.view.compartiment.comp80minprogress"), 25, 100);
	private UpwardProgress mComp100minProgressBar = new UpwardProgress(
			MN90.TABLES_MN90_PROPERTIES.getString("com.jlb.plongee.view.compartiment.comp100minprogress"), 25, 100);
	private UpwardProgress mComp120minProgressBar = new UpwardProgress(
			MN90.TABLES_MN90_PROPERTIES.getString("com.jlb.plongee.view.compartiment.comp120minprogress"), 25, 100);

	public CompartimentView() {
		this.add(this.mComp5minProgressBar, 0, 0);
		this.add(this.mComp7minProgressBar, 1, 0);
		this.add(this.mComp10minProgressBar, 2, 0);
		this.add(this.mComp15minProgressBar, 3, 0);
		this.add(this.mComp20minProgressBar, 4, 0);
		this.add(this.mComp30minProgressBar, 5, 0);
		this.add(this.mComp40minProgressBar, 6, 0);
		this.add(this.mComp50minProgressBar, 7, 0);
		this.add(this.mComp60minProgressBar, 8, 0);
		this.add(this.mComp80minProgressBar, 9, 0);
		this.add(this.mComp100minProgressBar, 10, 0);
		this.add(this.mComp120minProgressBar, 11, 0);
		this.setPadding(new Insets(10, 10, 10, 10));
		// this.setGridLinesVisible(true);
	}
}
