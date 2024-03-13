package com.designpattern.compositedesign;

public class CompositeTest {

	public static void main(String[] args) {
		 Component hd = new Leaf(4000,"HardDrive");
		 Component mouse = new Leaf(500,"Mouse");
		 Component monitor = new Leaf(8000,"Monitor");
		 Component ram = new Leaf(3000,"RAM");
		 Component cpu = new Leaf(5000,"CPU");
		 
		 Composite ph = new Composite("Peri");
		 Composite cabinet = new Composite("Cabinet");
		 Composite mb = new Composite("MotherBoard");
		 Composite computer = new Composite("Computer");
		 
		 mb.addComponent(cpu);
		 mb.addComponent(ram);
		 
		 ph.addComponent(mouse);
		 ph.addComponent(monitor);
		 
		 cabinet.addComponent(hd);
		 cabinet.addComponent(mb);
		 
		 computer.addComponent(ph);
		 computer.addComponent(cabinet);
		 
		 ram.showPrice();
		 ph.showPrice();
		 computer.showPrice();
	}
}
