package com.jlb.plongee.ihm.panels.plongees.types;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.jlb.plongee.application.MN90;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;

public class PlongeeSimpleView extends GridPane implements IPlongeeExerciceView {

	protected Label mHeureDepartLabel = new Label(
			MN90.TABLES_MN90_PROPERTIES.getString("com.jlb.plongee.view.plongee.simple.heuredepart.label"));
	protected Image mImgPlongeeFond = new Image("./resources/img/profilsplongees/PlongeeSimple1Palier.png");
	protected ImageView mImgView = new ImageView();
	protected TextField mHeureDepartValue = new TextField("09:30");
	protected Label mProfMaxLabel = new Label(
			MN90.TABLES_MN90_PROPERTIES.getString("com.jlb.plongee.view.plongee.simple.profmax.label"));
	protected TextField mProfMaxValue = new TextField("30");
	protected Label mProfMaxUniteLabel = new Label(
			MN90.TABLES_MN90_PROPERTIES.getString("com.jlb.plongee.view.plongee.simple.profmax.unite.label"));
	protected Label mHeureSortieLabel = new Label(
			MN90.TABLES_MN90_PROPERTIES.getString("com.jlb.plongee.view.plongee.simple.heuresortie.label"));
	protected TextField mHeureSortieValue = new TextField("09:55");
	protected Label mDureePlongeeLabel = new Label(
			MN90.TABLES_MN90_PROPERTIES.getString("com.jlb.plongee.view.plongee.simple.dureeplongee.label"));
	protected TextField mDureePlongeeValue = new TextField("40");
	protected Label mDureePlongeeUniteLabel = new Label(
			MN90.TABLES_MN90_PROPERTIES.getString("com.jlb.plongee.view.plongee.simple.duree.unite.label"));
	protected Label mPalier3mLabel = new Label(
			MN90.TABLES_MN90_PROPERTIES.getString("com.jlb.plongee.view.plongee.simple.palier3m.label"));
	protected TextField mDureePalier3mValue = new TextField("50");
	protected Label mDureePalier3mUniteLabel = new Label(
			MN90.TABLES_MN90_PROPERTIES.getString("com.jlb.plongee.view.plongee.simple.duree.unite.label"));
	protected Label mDTRLabel = new Label(
			MN90.TABLES_MN90_PROPERTIES.getString("com.jlb.plongee.view.plongee.simple.dtr.label"));
	protected TextField mDTRValue = new TextField("40");
	protected Label mDTRUniteLabel = new Label(
			MN90.TABLES_MN90_PROPERTIES.getString("com.jlb.plongee.view.plongee.simple.duree.unite.label"));

	protected Label mGPSLabel = new Label(
			MN90.TABLES_MN90_PROPERTIES.getString("com.jlb.plongee.view.plongee.simple.gps.label"));
	protected TextField mGPSValue = new TextField("A");

	private SimpleDateFormat mDateFormat = new SimpleDateFormat("HH:mm");

	public PlongeeSimpleView() {
		MN90.getLogger().debug(this, "Construction de la vue PlongeeSimple");
		// this.setGridLinesVisible(MN90.AFFICHAGE_GRILLE);
		this.setGridLinesVisible(true);

		ColumnConstraints col = new ColumnConstraints();
		// col.setPercentWidth(5);
		col.setHgrow(Priority.ALWAYS);
		this.getColumnConstraints().add(col);
		// col.setPercentWidth(90);
		col.setHgrow(Priority.ALWAYS);
		this.getColumnConstraints().add(col);
		// col.setPercentWidth(5);
		col.setHgrow(Priority.ALWAYS);
		this.getColumnConstraints().add(col);
		// col.setPercentWidth(5);
		col.setHgrow(Priority.ALWAYS);
		this.getColumnConstraints().add(col);
		// col.setPercentWidth(5);
		col.setHgrow(Priority.ALWAYS);
		this.getColumnConstraints().add(col);
		// col.setPercentWidth(5);
		col.setHgrow(Priority.ALWAYS);
		this.getColumnConstraints().add(col);
		// col.setPercentWidth(5);
		col.setHgrow(Priority.ALWAYS);
		this.getColumnConstraints().add(col);
		// col.setPercentWidth(5);
		col.setHgrow(Priority.ALWAYS);
		this.getColumnConstraints().add(col);
		// col.setPercentWidth(5);
		col.setHgrow(Priority.ALWAYS);
		this.getColumnConstraints().add(col);
		// col.setPercentWidth(5);
		col.setHgrow(Priority.ALWAYS);
		this.getColumnConstraints().add(col);
		// col.setPercentWidth(5);
		col.setHgrow(Priority.ALWAYS);
		this.getColumnConstraints().add(col);
		// col.setPercentWidth(5);
		col.setHgrow(Priority.ALWAYS);
		this.getColumnConstraints().add(col);
		// col.setPercentWidth(5);
		col.setHgrow(Priority.ALWAYS);
		this.getColumnConstraints().add(col);

		RowConstraints row = new RowConstraints();
		// row.setPercentHeight(90);
		row.setVgrow(Priority.ALWAYS);
		this.getRowConstraints().add(row);
		// row.setPercentHeight(90);
		row.setVgrow(Priority.ALWAYS);
		this.getRowConstraints().add(row);
		row.setVgrow(Priority.ALWAYS);
		this.getRowConstraints().add(row);
		row.setVgrow(Priority.ALWAYS);
		this.getRowConstraints().add(row);
		row.setVgrow(Priority.ALWAYS);
		this.getRowConstraints().add(row);
		row.setVgrow(Priority.ALWAYS);
		this.getRowConstraints().add(row);
		row.setVgrow(Priority.ALWAYS);
		this.getRowConstraints().add(row);
		row.setVgrow(Priority.ALWAYS);
		this.getRowConstraints().add(row);
		row.setVgrow(Priority.ALWAYS);
		this.getRowConstraints().add(row);

		mImgView.setImage(mImgPlongeeFond);
		mImgView.setFitWidth(100);
		mImgView.setManaged(true);
		mImgView.setPreserveRatio(true);
		mImgView.setSmooth(true);
		mImgView.setCache(true);
		this.add(mImgView, 0, 1, 13, 8);

		this.add(mHeureDepartLabel, 0, 0);

		mHeureDepartValue.setPrefWidth(100);
		mHeureDepartValue.setMaxWidth(100);
		mHeureDepartValue.setMinWidth(100);
		this.add(mHeureDepartValue, 1, 0, 2, 1);

		this.add(mProfMaxLabel, 2, 8);

		mProfMaxValue.setPrefWidth(45);
		mProfMaxValue.setMaxWidth(45);
		mProfMaxValue.setMinWidth(45);
		this.add(mProfMaxValue, 3, 8);

		this.add(mHeureSortieLabel, 10, 0);

		mHeureSortieValue.setPrefWidth(100);
		mHeureSortieValue.setMaxWidth(100);
		mHeureSortieValue.setMinWidth(100);
		this.add(mHeureSortieValue, 11, 0, 2, 1);

		this.add(mDureePlongeeLabel, 2, 7);

		mDureePlongeeValue.setPrefWidth(45);
		mDureePlongeeValue.setMaxWidth(45);
		mDureePlongeeValue.setMinWidth(45);
		this.add(mDureePlongeeValue, 3, 7);

		this.add(mPalier3mLabel, 11, 2);

		mDureePalier3mValue.setPrefWidth(50);
		mDureePalier3mValue.setMaxWidth(50);
		mDureePalier3mValue.setMinWidth(50);
		this.add(mDureePalier3mValue, 11, 3);

		this.add(mDTRLabel, 10, 8);

		mDTRValue.setPrefWidth(50);
		mDTRValue.setMaxWidth(50);
		mDTRValue.setMinWidth(50);
		this.add(mDTRValue, 11, 8);

		this.add(mGPSLabel, 10, 7);

		mGPSValue.setPrefWidth(50);
		mGPSValue.setMaxWidth(50);
		mGPSValue.setMinWidth(50);
		this.add(mGPSValue, 11, 7);
	}

	@Override
	public void setHeureDepartValuePlongee1(long hdms) {
		mHeureDepartValue.setText(mDateFormat.format(new Date(hdms)));
	}

	@Override
	public void setHeureDepartValuePlongee2(long hdms) {
		// Rien a faire => une seule plongee dans la vue
	}

	@Override
	public void setHeureSortieValuePlongee1(long hdms) {
		mHeureSortieValue.setText(mDateFormat.format(new Date(hdms)));
	}

	@Override
	public void setHeureSortieValuePlongee2(long hdms) {
		// Rien a faire => une seule plongee dans la vue
	}

	@Override
	public void setDTRValuePlongee1(int dtr) {
		mDTRValue.setText(String.valueOf(dtr));
	}

	@Override
	public void setDTRValuePlongee2(int dtr) {
		// Rien a faire => une seule plongee dans la vue
	}

	@Override
	public void setProfondeurMaxValuePlongee1(int profMax) {
		mProfMaxValue.setText(String.valueOf(profMax));
	}

	@Override
	public void setProfondeurMaxValuePlongee2(int profMax) {
		// Rien a faire => une seule plongee dans la vue
	}

	@Override
	public void setTempsPlongeeValuePlongee1(int tpsPlongee) {
		mDureePlongeeValue.setText(String.valueOf(tpsPlongee));
	}

	@Override
	public void setTempsPlongeeValuePlongee2(int tpsPlongee) {
		// Rien a faire => une seule plongee dans la vue
	}

	@Override
	public void setTempsPalier3mValuePlongee1(int tpsPalier) {
		// TODO Auto-generated method stub
		mDureePalier3mValue.setText(String.valueOf(tpsPalier));
	}

	@Override
	public void setTempsPalier6mValuePlongee1(int tpsPalier) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setTempsPalier9mValuePlongee1(int tpsPalier) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setTempsPalier12mValuePlongee1(int tpsPalier) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setTempsPalier15mValuePlongee1(int tpsPalier) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setTempsPalier3mValuePlongee2(int tpsPalier) {
		// Rien a faire => une seule plongee dans la vue
	}

	@Override
	public void setTempsPalier6mValuePlongee2(int tpsPalier) {
		// Rien a faire => une seule plongee dans la vue
	}

	@Override
	public void setTempsPalier9mValuePlongee2(int tpsPalier) {
		// Rien a faire => une seule plongee dans la vue
	}

	@Override
	public void setTempsPalier12mValuePlongee2(int tpsPalier) {
		// Rien a faire => une seule plongee dans la vue
	}

	@Override
	public void setTempsPalier15mValuePlongee2(int tpsPalier) {
		// Rien a faire => une seule plongee dans la vue
	}

	@Override
	public void setIntervalleValue(int tpsIntervalle) {
		// Rien a faire => une seule plongee dans la vue
	}

	@Override
	public void setMajorationValue(int tpsMajo) {
		// Rien a faire => une seule plongee dans la vue
	}

	@Override
	public void setGPSValuePlongee1(String gps) {
		mGPSValue.setText(gps);
	}

	@Override
	public void setGPSValuePlongee2(String gps) {
		// Rien a faire => une seule plongee dans la vue
	}

	@Override
	public void resizeNode(double width, double height) {
		MN90.getLogger().debug(this, "Changement de taille : " + width + " - " + height);
		double widthForFit = width > height ? width : height;
		for (int i = 0; i < this.getColumnConstraints().size(); i++) {
			double value = 5;
			if (i == 1) {
				value = 10;
			}
			this.getColumnConstraints().get(i).setPercentWidth(value);
		}

		for (int i = 0; i < this.getRowConstraints().size(); i++) {
			double value = 5;
			if (i == 0) {
				value = 5;
			}
			this.getRowConstraints().get(i).setPercentHeight(value);
		}
		if (mImgView.getFitWidth() != widthForFit)
			mImgView.setFitWidth(widthForFit);
	}
}
