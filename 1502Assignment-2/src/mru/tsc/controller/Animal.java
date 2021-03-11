package mru.tsc.controller;

import java.util.Scanner;

public class Animal {
	
	//This method will return true if the Sn value is unique
		public boolean searchForSN(String value) {

			Scanner s = new Scanner(System.in);
			String line = "";

		Scanner kb  = new Scanner(System.in);
		System.out.println("Please put enter the SN number for the item.");
		String SN_number  = kb.next();
		boolean checkIfSame = true;
		while(checkIfSame) {
			checkIfSame = searchForSN(SN_number);
			System.out.println("Enter again");
			SN_number = kb.next();
		}
		System.out.println("Please put enter the SN for the item.");
		String sn  = kb.next();
		System.out.println("Please put enter the name for the item.");
		String name  = kb.next();
		System.out.println("Please put enter the brand for the item.");
		String brand  = kb.next();
		System.out.println("Please put enter the price for the item.");
		String price  = kb.next();
		System.out.println("Please put enter the available-count for the item.");
		String available_count  = kb.next();
		System.out.println("Please put enter the age-appropriate for the item.");
		String age  = kb.next();
		System.out.println("Please put enter the material for the item.");
		String material  = kb.next();
		System.out.println("Please put enter the size for the item.");
		String size  = kb.next();
		
		String animal_info = sn +", "+  name +", "+ brand +", "+ price+", "+ available_count +","+ age+", "+ material+", "+ size;
		return animal_info;

}
}