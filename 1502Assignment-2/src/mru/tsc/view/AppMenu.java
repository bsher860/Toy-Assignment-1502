package mru.tsc.view;

import java.util.Scanner;

public class AppMenu {

	Scanner input;

	public AppMenu() {

		input = new Scanner(System.in);

	}

	/**
	 * This is the Main Menu method The Main Menu contains 3 different options. User
	 * can pick Player, Search and Exit.
	 * 
	 * @return Prints the Main Menu in console along with options
	 */
	public char showMainMenu() {

		boolean flage = true;
		char option;

		do {
			System.out.println("****************************************");
			System.out.println("*     WELCOME TO TOY STORY COMPANY     *");
			System.out.println("****************************************");
			System.out.println();
			System.out.println("How we may help you?");
			System.out.println();
			System.out.println("(A) Search inventory and purchse toy");
			System.out.println("(B) Add new toy");
			System.out.println("(C) Remove toy");
			System.out.println("(D) Save and Exit");
			System.out.println();
			System.out.print("Enter a choice here:");

			option = input.nextLine().toLowerCase().charAt(0);

			if (option == 'a' || option == 'b' || option == 'c' || option == 'd') {
				flage = false;
			} else {
				System.out.println("try again");
			}
		} while (flage);

		return option;

	}

	public char showSearchMenu() {
		boolean flage = true;
		char option;
		do {

			System.out.println("Find toys with: ");
			System.out.println();
			System.out.println("(A) Serial number(SN)");
			System.out.println("(B) Toy name");
			System.out.println("(C) Type");
			System.out.println("(D) Back to main menu");
			System.out.println();
			System.out.print("Enter a choice here:");

			option = input.nextLine().toLowerCase().charAt(0);

			if (option == 'a' || option == 'b' || option == 'c' || option == 'd') {
				flage = false;
			} else {
				System.out.println("try again");
			}
		} while (flage);

		return option;

	}

}
