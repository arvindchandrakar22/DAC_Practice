package com.designpattern.prototypedesign;

public class MainMethod {

	public static void main(String[] args) throws CloneNotSupportedException {
		
		BookShop bs = new BookShop();
		bs.setShopName("Novelty");
		bs.loadData();
		System.out.println(bs);
		
		//here we are creating new object but as prototype design says clone it from that previous object
//		BookShop bs1 = new BookShop();
//		bs1.setShopName("A1");
//		bs1.loadData();
//		System.out.println(bs1);
		
		//This was for shallow copy
//		BookShop bs1 = (BookShop) bs.clone();
//		bs1.setShopName("A1");
//		bs1.loadData();
//		System.out.println(bs1);
		
		BookShop bs1 = bs.clone();
		bs.getBooks().remove(2); // here we are removing data from previous object, and this will not affect our new object
		bs1.setShopName("A1");
		bs1.loadData();
		System.out.println("After removing data from the 1st object");
		System.out.println(bs);
		System.out.println(bs1);
	}
}
