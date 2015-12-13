package com.jlb.plongee.datamodel.plongees;

public enum E_NIVEAU {

	P1(0, "P1"), P2(1, "P2"), P3(2, "P3"), P4(3, "P4"), P4_INITIATEUR(4, "P4 Initiateur"), P5(5, "P5"), E3(6,
			"MF1-BEES1"), E3_NITROX(7, "MF1-BEES1 NITROX"), E4(8, "MF2-BEES2"), E4_NITROX(9,
					"MF2-BEES2 NITROX"), E4_TRIMIX(10, "MF2-BEES2 TRIMIX");

	private int mIndex;
	private String mName;

	E_NIVEAU(int index, String name) {
		this.mIndex = index;
		this.mName = name;
	}

	public int getIndex() {
		return mIndex;
	}

	public void setIndex(int index) {
		this.mIndex = index;
	}

	public String getName() {
		return mName;
	}
}
