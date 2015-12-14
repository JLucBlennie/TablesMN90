package com.jlb.plongee.datamodel.logbook;

import com.jlb.plongee.datamodel.tools.Localisation;
import com.jlb.tools.metamodel.Entity;
import com.jlb.tools.metamodel.attributes.impl.DoubleAttribute;
import com.jlb.tools.metamodel.attributes.impl.StringAttribute;

public class Site extends Entity {

	public static final String ATTRIBUT_NAME = DICO_PROPERTIES.getString("datamodel.site.attribut.name");
	public static final String ATTRIBUT_LOCALISATION_LATITUDE = DICO_PROPERTIES
			.getString("datamodel.site.attribut.localisation.latitude");
	public static final String ATTRIBUT_LOCALISATION_LONGITUDE = DICO_PROPERTIES
			.getString("datamodel.site.attribut.localisation.longitude");

	public Site() {
		super();

		// Definition des attributs
		StringAttribute attrName = new StringAttribute(ATTRIBUT_NAME);
		mAttributes.add(attrName);

		DoubleAttribute attrLocLat = new DoubleAttribute(ATTRIBUT_LOCALISATION_LATITUDE);
		mAttributes.add(attrLocLat);
		DoubleAttribute attrLocLong = new DoubleAttribute(ATTRIBUT_LOCALISATION_LONGITUDE);
		mAttributes.add(attrLocLong);
	}

	public Site(int id, String name, Localisation loc) {
		this.mId = id;

		// Definition des attributs
		StringAttribute attrName = new StringAttribute(ATTRIBUT_NAME, name);
		mAttributes.add(attrName);
		DoubleAttribute attrLocLat = new DoubleAttribute(ATTRIBUT_LOCALISATION_LATITUDE, loc.getLatitude());
		mAttributes.add(attrLocLat);
		DoubleAttribute attrLocLong = new DoubleAttribute(ATTRIBUT_LOCALISATION_LONGITUDE, loc.getLongitude());
		mAttributes.add(attrLocLong);
	}

	@Override
	public String toString() {
		return getAttribute(ATTRIBUT_NAME).getValue() + " - Lat = "
				+ getAttribute(ATTRIBUT_LOCALISATION_LATITUDE).getValue() + " ; Long = "
				+ getAttribute(ATTRIBUT_LOCALISATION_LONGITUDE).getValue();
	}
}
