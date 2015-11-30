package com.jlb.tools.metamodel;

import java.util.ArrayList;
import java.util.List;

import com.jlb.tools.metamodel.attributes.IAttribute;

public class Entity {

	protected List<IAttribute> mAttributes = new ArrayList<IAttribute>();
	protected List<? extends Entity> mChildren = new ArrayList<>();

	public List<IAttribute> getAttributes() {
		return mAttributes;
	}
}
