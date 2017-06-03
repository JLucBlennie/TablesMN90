package com.jlb.plongee.ihm;

public interface IController<T> {
	T getView();

	void init();
}
