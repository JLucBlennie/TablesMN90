package com.jlb.plongee.datamodel;

import com.jlb.plongee.datamodel.logbook.Participant;
import com.jlb.plongee.datamodel.logbook.Site;
import com.jlb.tools.metamodel.Version;

/**
 * Classe decrivant le modele de donnees du logiciel MN90
 * 
 * @author JLuc
 *
 */
public class MN90Version extends Version {

	static {
		mClazzs.add(Plongeur.class);
		mClazzs.add(Participant.class);
		mClazzs.add(Site.class);
	}

	public MN90Version() {
		super();
	}

}
