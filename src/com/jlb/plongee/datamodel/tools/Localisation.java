package com.jlb.plongee.datamodel.tools;

/**
 * Classe decrivant la situtation d'un site
 * 
 * @author JLuc
 *
 */
public class Localisation {

	private double mLatitude;
	private double mLongitude;

	public Localisation(double latitude, double longitude) {
		mLatitude = latitude;
		mLongitude = longitude;
	}

	public double getLatitude() {
		return mLatitude;
	}

	public double getLongitude() {
		return mLongitude;
	}
}
