package mru.tsc.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import mru.tsc.view.AppMenu;

public class appManager {

	mru.tsc.view.AppMenu appMen;

	public appManager() throws Exception {

		appMen = new AppMenu();

	}

	public static void main(String[] args) throws Exception {
		appManager newThing = new appManager();
		newThing.addToy();
	}

	public void launchApplication() throws IOException {

		boolean flag = true;
		char option;
		option = appMen.showMainMenu();

		while (flag) {

			switch (option) {
			case 'a':

				search();
				break;

			case 'b':

				addToy();
				break;

			case 'c':
				removeToy();
				break;

			case 'd':
				flag = false;
				save();
				System.out.println("\nSaving......... finished, come back soon!");
				break;

			default:

				System.out.println("Incorrect character, try again");

			}
		}

	}

	public void search() throws IOException {

		boolean flag = true;
		char option;

		while (flag) {

			option = appMen.showSearchMenu();
			switch (option) {

			case 'a':
				searchSin();
				break;

			case 'b':
				searchName();
				break;

			case 'c':
				searchType();
				break;

			case 'd':
				flag = false;
				launchApplication();

				break;

			default:
				System.out.println("Incorrect character, try again");

			}
		}

	}

	public void searchType() throws IOException {
		File input = new File("res/toyfile");
		FileReader fr = null;
		Scanner ob = new Scanner(System.in);
		String ToyName, str;
		System.out.print("Enter name of toy: ");
		ToyName = ob.nextLine();

		while (ToyName == null) {

			System.out.println("invalid input, try again");
			ToyName = ob.nextLine();

		}

		try {

			fr = new FileReader(input);
			BufferedReader br = new BufferedReader(fr);

			while ((str = br.readLine()) != null) {
				if (str.toUpperCase().contains(ToyName.toUpperCase()))
					System.out.print(str + "\n");

			}
			fr.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();

		}

		Scanner y = new Scanner(System.in);
		char answer = 'Y';
		String response;
		String line = "";

		System.out.println("Do you want to purchase iteams? Y/N");
		response = y.nextLine();

		answer = response.charAt(0);

		if (Character.toUpperCase(answer) == 'Y') {
			System.out.println("Purchase succeesful");
			System.out.println("");

			System.out.println("Press enter to continue");

			response = y.nextLine();
			if (line == "") {

				search();

			}

		} else {
			System.out.println("Purchase cancelled");
		}

	}

	public void searchName() throws IOException {
		File input = new File("res/toyfile");
		FileReader fr = null;
		Scanner ob = new Scanner(System.in);
		String ToyName, str;
		System.out.print("Enter name of toy: ");
		ToyName = ob.nextLine();

		while (ToyName == null) {

			ToyName = ob.nextLine();
			System.out.println("invalid input, try again");
		}

		try {

			fr = new FileReader(input);
			BufferedReader br = new BufferedReader(fr);

			while ((str = br.readLine()) != null) {
				if (str.toUpperCase().contains(ToyName.toUpperCase()))
					System.out.print(str + "\n");
			}
			fr.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();

		}

		Scanner y = new Scanner(System.in);
		char answer = 'Y';
		String response;
		String line = "";

		System.out.println("Do you want to purchase iteams? Y/N");
		response = y.nextLine();

		answer = response.charAt(0);

		if (Character.toUpperCase(answer) == 'Y') {
			System.out.println("Purchase succeesful");
			System.out.println("");

			System.out.println("Press enter to continue");

			response = y.nextLine();
			if (line == "") {

				search();

			}

		} else {
			System.out.println("Purchase cancelled");
		}

	}

	public void searchSin() throws IOException {

		Scanner s = new Scanner(System.in);
		System.out.print("Enter SIN: ");
		String sid = s.next();
		String line = "";

		while (sid == null) {
			System.out.println("invalid input, try again");
			System.out.print("Enter SIN: ");
			sid = s.next();

		}

		try {
			FileInputStream fin = new FileInputStream("res/toyfile");
			Scanner sc = new Scanner(fin);
			while (sc.hasNextLine()) {
				line = sc.nextLine();
				if (line.startsWith(sid))
					System.out.println(line + "\n");
			}

			sc.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();

		}

		Scanner y = new Scanner(System.in);
		char answer = 'Y';
		String response;
		String x = "";

		System.out.println("Do you want to purchase iteams? Y/N");
		response = y.nextLine();

		answer = response.charAt(0);

		if (Character.toUpperCase(answer) == 'Y') {
			System.out.println("Purchase succeesful");
			System.out.println("");

			System.out.println("Press enter to continue");

			response = y.nextLine();
			if (x == "") {

				search();

			}

		} else {
			System.out.println("Purchase cancelled");
		}

	}

	private void addToy() {
		Scanner kb = new Scanner(System.in);
		String addingToData = null;
		System.out.println("What would you like to add?");
		System.out.println("(1) Animal");
		System.out.println("(2) Figures");
		System.out.println("(3) Puzzles");
		System.out.println("(4) Board Games");
		int number = kb.nextInt();
		switch (number) {
		case 1:
			addingToData = animal();
			break;
		case 2:
			addingToData = figure();
			break;
		case 3:
			addingToData = puzzle();
			break;
		case 4:
			addingToData = boardGame();
			break;
		}
		// Use and Printer package to print the value into the file.
		try {
			FileWriter myWriter = new FileWriter("toyfile.txt");
			myWriter.write(addingToData);
			myWriter.close();
			System.out.println("Successfully wrote to the file.");
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

	}

	public void removeToy() throws IOException {

		Scanner kb = new Scanner(System.in);
		System.out.print("Enter SIN: ");
		String sic = kb.next();

		File inputFile = new File("res/toyfile");
		File tempFile = new File("res/myFile.txt");

		BufferedReader reader = new BufferedReader(new FileReader(inputFile));
		BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

		String lineToRemove = sic;
		String currentLine;

		while ((currentLine = reader.readLine()) != null) {
			// trim newline when comparing with lineToRemove
			String trimmedLine = currentLine.trim();
			if (trimmedLine.equals(lineToRemove))
				continue;
			writer.write(currentLine + System.getProperty("line.seperator"));
		}
		writer.close();
		reader.close();
		boolean successful = tempFile.renameTo(inputFile);

	}

	private void save() {

	}

	private String animal() {
		Scanner kb = new Scanner(System.in);
		System.out.println("Please put enter the SN number for the item.");
		String SN_number = kb.next();
		boolean checkIfSame = true;
		while (checkIfSame) {
			checkIfSame = searchForSN(SN_number);
			System.out.println("Enter again");
			SN_number = kb.next();
		}
		System.out.println("Please put enter the SN for the item.");
		String sn = kb.next();
		System.out.println("Please put enter the name for the item.");
		String name = kb.next();
		System.out.println("Please put enter the brand for the item.");
		String brand = kb.next();
		System.out.println("Please put enter the price for the item.");
		String price = kb.next();
		System.out.println("Please put enter the available-count for the item.");
		String available_count = kb.next();
		System.out.println("Please put enter the age-appropriate for the item.");
		String age = kb.next();
		System.out.println("Please put enter the material for the item.");
		String material = kb.next();
		System.out.println("Please put enter the size for the item.");
		String size = kb.next();

		String animal_info = sn + ", " + name + ", " + brand + ", " + price + ", " + available_count + "," + age + ", "
				+ material + ", " + size;
		return animal_info;

	}

	private String figure() {
		Scanner kb = new Scanner(System.in);
		System.out.println("Please put enter the SN number for the item.");
		String SN_number = kb.next();
		boolean checkIfSame = true;
		while (checkIfSame) {
			checkIfSame = searchForSN(SN_number);
			System.out.println("Enter again");
			SN_number = kb.next();
		}
		System.out.println("Please put enter the SN for the item.");
		String sn = kb.next();
		System.out.println("Please put enter the name for the item.");
		String name = kb.next();
		System.out.println("Please put enter the brand for the item.");
		String brand = kb.next();
		System.out.println("Please put enter the price for the item.");
		String price = kb.next();
		System.out.println("Please put enter the available-count for the item.");
		String available_count = kb.next();
		System.out.println("Please put enter the age-appropriate for the item.");
		String age = kb.next();
		String material = kb.next();
		System.out.println("Please put enter the size for the item.");
		String size = kb.next();

		String figure_info = sn + ", " + name + ", " + brand + ", " + price + ", " + available_count + "," + age + ", "
				+ material + ", " + size;
		return figure_info;

	}

	private String puzzle() {
		Scanner kb = new Scanner(System.in);
		System.out.println("Please put enter the SN number for the item.");
		String SN_number = kb.next();
		boolean checkIfSame = true;
		while (checkIfSame) {
			checkIfSame = searchForSN(SN_number);
			System.out.println("Enter again");
			SN_number = kb.next();
		}
		System.out.println("Please put enter the SN for the item.");
		String sn = kb.next();
		System.out.println("Please put enter the name for the item.");
		String name = kb.next();
		System.out.println("Please put enter the brand for the item.");
		String brand = kb.next();
		System.out.println("Please put enter the price for the item.");
		String price = kb.next();
		System.out.println("Please put enter the available-count for the item.");
		String available_count = kb.next();
		System.out.println("Please put enter the age-appropriate for the item.");
		String age = kb.next();
		System.out.println("Please put enter the puzzle-type for the item.");
		String puzzletype = kb.next();
		String puzzle_info = sn + ", " + name + ", " + brand + ", " + price + ", " + available_count + "," + puzzletype
				+ "," + age;
		return puzzle_info;

	}

	private String boardGame() {
		Scanner kb = new Scanner(System.in);
		System.out.println("Please put enter the SN number for the item.");
		String SN_number = kb.next();
		boolean checkIfSame = true;
		while (checkIfSame) {
			checkIfSame = searchForSN(SN_number);
			System.out.println("Enter again");
			SN_number = kb.next();
		}
		System.out.println("Please put enter the name for the item.");
		String name = kb.next();
		System.out.println("Please put enter the brand for the item.");
		String brand = kb.next();
		System.out.println("Please put enter the price for the item.");
		String price = kb.next();
		System.out.println("Please put enter the available-count for the item.");
		String available_count = kb.next();
		System.out.println("Please put enter the age-appropriate for the item.");
		String age = kb.next();
		System.out.println("Please put enter the Number of Players for the item.");
		String numOfplyrs = kb.next();
		System.out.println("Please put enter the designer(s) for the item.");
		String designr = kb.next();
		String boardGame_info = name + ", " + brand + ", " + price + ", " + available_count + "," + age + ", "
				+ numOfplyrs + "-" + "," + designr;
		return boardGame_info;
	}

	// This method will return true if the Sn value is unique
	public boolean searchForSN(String value) {

		Scanner s = new Scanner(System.in);
		String line = "";

		if (value == null) {
			System.out.println("invalid input, try again");
			return true;

		} else if (!Character.isDigit(value.length())) {
			System.out.println("invalid input, try again");
			return true;
		}

		try {
			FileInputStream fin = new FileInputStream("res/toyfile");
			Scanner sc = new Scanner(fin);
			while (sc.hasNextLine()) {
				line = sc.nextLine();
				if (line.startsWith(value))
					System.out.println(line + "\n");
			}

			sc.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();

		}
		return false;

	}

}
