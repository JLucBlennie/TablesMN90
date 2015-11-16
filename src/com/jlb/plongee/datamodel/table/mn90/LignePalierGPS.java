/**
 * 
 */
package com.jlb.plongee.datamodel.table.mn90;

/**
 * @author JLB
 *
 */
public class LignePalierGPS {

	private int mProfondeur;
	private int mTempsPlongee;
	private int mTpsP3M;
	private int mTpsP6M;
	private int mTpsP9M;
	private int mTpsP12M;
	private int mTpsP15M;

	private String mGPS;

	public LignePalierGPS(int profondeur, int tempsPlongee, int tpsP3M, int tpsP6M, int tpsP9M, int tpsP12M,
			int tpsP15M, String GPS) {
		this.mProfondeur = profondeur;
		this.mTempsPlongee = tempsPlongee;
		this.mTpsP3M = tpsP3M;
		this.mTpsP6M = tpsP6M;
		this.mTpsP9M = tpsP9M;
		this.mTpsP12M = tpsP12M;
		this.mTpsP15M = tpsP15M;
		this.mGPS = GPS;
	}

	/**
	 * @return the mProfondeur
	 */
	public int getProfondeur() {
		return mProfondeur;
	}

	/**
	 * @return the mTempsPlongee
	 */
	public int getTempsPlongee() {
		return mTempsPlongee;
	}

	/**
	 * @return the mTpsP3M
	 */
	public int getTpsP3M() {
		return mTpsP3M;
	}

	/**
	 * @return the mTpsP6M
	 */
	public int getTpsP6M() {
		return mTpsP6M;
	}

	/**
	 * @return the mTpsP9M
	 */
	public int getTpsP9M() {
		return mTpsP9M;
	}

	/**
	 * @return the mTpsP12M
	 */
	public int getTpsP12M() {
		return mTpsP12M;
	}

	/**
	 * @return the mTpsP15M
	 */
	public int getTpsP15M() {
		return mTpsP15M;
	}

	/**
	 * @return the mGPS
	 */
	public String getGPS() {
		return mGPS;
	}

	@Override
	public String toString() {
		return "Profondeur = " + mProfondeur + " - Temps de plongee = " + mTempsPlongee + " - Paliers 3m = " + mTpsP3M
				+ " 6m = " + mTpsP6M + " 9m = " + mTpsP9M + " 12m = " + mTpsP12M + " 15m = " + mTpsP15M + " - GPS = "
				+ mGPS;
	}
}
