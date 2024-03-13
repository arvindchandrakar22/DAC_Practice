package com.thirdrule;

public interface I {

	void add();
	
	default void show() {
		System.out.println("Interface I.");
	}
}
