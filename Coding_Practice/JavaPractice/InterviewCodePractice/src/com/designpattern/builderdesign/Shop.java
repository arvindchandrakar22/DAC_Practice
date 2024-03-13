package com.designpattern.builderdesign;

public class Shop {

	public static void main(String[] args) {
		
//		Phone p = new Phone("Android", 2, "QualComm", 5.5, 3100);
//		System.out.println(p);
		
		Phone p = new PhoneBuilder().setOs("Android").setRam(4).getPhone();
		System.out.println(p);
		
		PhoneBuilder p1 = new PhoneBuilder();
		p1.setOs("Android");
		p1.setRam(8);
		Phone ph = p1.getPhone();
		System.out.println(ph);
	}
}
