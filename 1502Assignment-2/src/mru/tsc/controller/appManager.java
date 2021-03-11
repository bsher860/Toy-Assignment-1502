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
	

		while (flag) { option = appMen.showMainMenu();

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
		String sid = s.nextLine();
		String line = "";

		while (sid == null) {
			System.out.println("invalid input, try again");
			System.out.print("Enter SIN: ");
			sid = s.nextLine();

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

	public addToy addToy() {
		Scanner kb = new Scanner(System.in);
		String op1 = "";
		String op2 = "";

		System.out.println("Enter the Serial Number:");
		String SN = (kb.nextLine());

		System.out.println("Enter the Toy Name:");
		String name = kb.nextLine().toLowerCase();

		System.out.println("Enter the Toy Brand:");
		String brand = kb.nextLine().toLowerCase();

		System.out.println("Enter the Available Price:");
		Double price = Double.parseDouble(kb.nextLine());

		System.out.println("Enter the Available Count:");
		int count = Integer.parseInt(kb.nextLine());

		System.out.println("Enter the Appropriate Age:");
		int age = Integer.parseInt(kb.nextLine());

		
		if (groupSn(SN) == 0 || groupSn(SN) == 1) {
			System.out.println("Enter the Classification:");
			op1 = (kb.nextLine());
		
			
		} else if (groupSn(SN) == 2 || groupSn(SN) == 3) {
			System.out.println("Enter the Material:");
			op1 = (kb.nextLine());
			System.out.println("Enter the Size:");
			op2 = (kb.nextLine());
			
			
		} else if (groupSn(SN) == 4 || groupSn(SN) == 5 || groupSn(SN) == 6) {
			System.out.println("Enter the Puzzle Type:");
			op1 = (kb.nextLine());
			
			
		} else if (groupSn(SN) == 4 || groupSn(SN) == 5 || groupSn(SN) == 6) {
			System.out.println("Enter Type of Puzzle:");
			op1 = (kb.nextLine());
			
			
		} else if (groupSn(SN) == 7 || groupSn(SN) == 8 || groupSn(SN) == 9) {
			System.out.println("Enter Number of Players:");
			op1 = (kb.nextLine());
			System.out.println("Enter Designer(s) name:");
			op2 = (kb.nextLine());
			
		}
		addToy add = new addToy(SN, name, brand, price, count, age, op1, op2);

		return add;
	}

	public int groupSn(String SN) {
		String str = (SN).substring(0, 1);
		int num = Integer.parseInt(str);
		return num;
	}

	public void removeToy() throws IOException {

		Scanner s = new Scanner(System.in);
		System.out.print("Enter SIN: ");
		String sid = s.nextLine();
		String line = "";

		while (sid == null) {
			System.out.println("invalid input, try again");
			System.out.print("Enter SIN: ");
			sid = s.nextLine();

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

		System.out.println("Do you want to delete the following iteam? Y/N");
		response = y.nextLine();

		answer = response.charAt(0);

		if (Character.toUpperCase(answer) == 'Y') {

			Scanner kb = new Scanner(System.in);
			System.out.print("Enter SIN: ");
			String sic = kb.nextLine();

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
			System.out.println("\\deleting......... finished");
			System.out.println("");

			System.out.println("Press enter to continue");

			response = y.nextLine();
			if (x == "") {

				search();

			}

		} else {
			System.out.println("\\\\canceling deletion......... finished");
			System.out.println("");
			System.out.println("Press enter to continue");

			response = y.nextLine();
			if (x == "") {

				search();

			}
		}
	}
	
	private void save() {

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
