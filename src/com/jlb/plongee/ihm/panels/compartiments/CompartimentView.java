package com.jlb.plongee.ihm.panels.compartiments;

import com.jlb.plongee.ihm.widget.UpwardProgress;

import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;

public class CompartimentView extends GridPane {

	private UpwardProgress comp5min = new UpwardProgress("5'", 25, 100);
	private UpwardProgress comp7min = new UpwardProgress("7'", 25, 100);
	private UpwardProgress comp10min = new UpwardProgress("10'", 25, 100);
	private UpwardProgress comp15min = new UpwardProgress("15'", 25, 100);
	private UpwardProgress comp20min = new UpwardProgress("20'", 25, 100);
	private UpwardProgress comp30min = new UpwardProgress("30'", 25, 100);
	private UpwardProgress comp40min = new UpwardProgress("40'", 25, 100);
	private UpwardProgress comp50min = new UpwardProgress("50'", 25, 100);
	private UpwardProgress comp60min = new UpwardProgress("60'", 25, 100);
	private UpwardProgress comp80min = new UpwardProgress("80'", 25, 100);
	private UpwardProgress comp100min = new UpwardProgress("100'", 25, 100);
	private UpwardProgress comp120min = new UpwardProgress("120'", 25, 100);

	public CompartimentView() {
		this.add(this.comp5min, 0, 0);
		this.add(this.comp7min, 1, 0);
		this.add(this.comp10min, 2, 0);
		this.add(this.comp15min, 3, 0);
		this.add(this.comp20min, 4, 0);
		this.add(this.comp30min, 5, 0);
		this.add(this.comp40min, 6, 0);
		this.add(this.comp50min, 7, 0);
		this.add(this.comp60min, 8, 0);
		this.add(this.comp80min, 9, 0);
		this.add(this.comp100min, 10, 0);
		this.add(this.comp120min, 11, 0);
		this.setPadding(new Insets(10, 10, 10, 10));
		// this.setGridLinesVisible(true);
	}
}
