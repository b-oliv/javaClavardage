package com.clavardage.app;

import java.util.Scanner;

public class Monologue {

	private Scanner input = new Scanner(System.in);
	private String str;

	public Monologue() {

	}

	public void getInput() {
		System.out.println("Veuillez saisir un mot :");
		String str = this.input.next();
		System.out.println("Vous avez saisi : " + str);
	}

	public String render() {
		return "Vous avez tapé: " + this.str;
	}

}
