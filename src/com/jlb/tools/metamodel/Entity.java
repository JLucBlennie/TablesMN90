package com.jlb.tools.metamodel;

import java.util.ArrayList;
import java.util.List;

import com.jlb.tools.metamodel.attributes.IAttribute;

public abstract class Entity {

	protected List<IAttribute> mAttributes = new ArrayList<IAttribute>();
	protected List<Entity> mChildren = new ArrayList<>();
	protected static List<Class> mAuthorizedChildrenClass = new ArrayList<Class>();
	protected Entity mParent;
	protected int mId;

	public static List<Class> getAuthorizedChildrenClass() {
		return mAuthorizedChildrenClass;
	}

	public void setParent(Entity parent) {
		this.mParent = parent;
	}

	public Entity getParent() {
		return mParent;
	}

	public int getId() {
		return this.mId;
	}

	public List<IAttribute> getAttributes() {
		return mAttributes;
	}

	public IAttribute getAttribute(String attrName) {
		IAttribute resAttr = null;
		for (IAttribute attribute : mAttributes) {
			if (attribute.getName().equals(attrName))
				resAttr = attribute;
		}
		return resAttr;
	}

	public List<Entity> getChildrenOfType(String className) {
		List<Entity> results = new ArrayList<Entity>();
		for (Entity child : mChildren) {
			if (child.getClass().getName().equals(className) && !results.contains(child)) {
				results.add(child);
			}
		}
		return results;
	}

	public Entity getChildOfType(String className, int id) {
		for (Entity child : getChildrenOfType(className)) {
			if (child.getId() == id)
				return child;
		}

		// Si pas de resultat
		return null;
	}

	public List<Entity> getChildren() {
		return mChildren;
	}
}
