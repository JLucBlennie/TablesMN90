package com.jlb.plongee.ihm;

public interface Controller<T> {
	T getView();

	void init();
}
