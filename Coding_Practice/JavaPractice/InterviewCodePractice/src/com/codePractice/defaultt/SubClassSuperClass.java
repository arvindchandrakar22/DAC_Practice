package com.codePractice.defaultt;

public class SubClassSuperClass {

	public static void main(String[] args) {
		
		Chandrakar c = new Arvind();
		
		if(c instanceof Arvind) {
		
		Arvind arvind = (Arvind) new Chandrakar();
		
		System.out.println("Sub Class Referencing to Object Of Super Class.");
		arvind.printInvite();
		arvind.printWelcome();
		}
		
		Chandrakar chandrakar = new Arvind();
		
		System.out.println("Super Class Referecing to Object Of Sub Class.");
		chandrakar.printInvite();
		
	}
}

class Chandrakar {
	public void printInvite() {
		System.out.println("Invite");
	}
}

class Arvind extends Chandrakar {
	public void printWelcome() {
		System.out.println("Welcome");
	}
}