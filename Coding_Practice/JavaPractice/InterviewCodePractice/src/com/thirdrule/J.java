package com.thirdrule;

public interface J {
	
	void add();
	
	default void show() {
		System.out.println("Interface J.");
	}

}
