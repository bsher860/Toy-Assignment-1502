package mru.tsc.controller;

public class addToy {

	private String SN;
	private String name;
	private int count;
	private String brand;
	private double price;
	private int age;
	private String op1;
	private String op2;

	public addToy(String SN, String name, String brand, Double price, int count, int age, String op1, String op2) {

		this.SN = SN;
		this.name = name;
		this.count = count;
		this.brand = brand;
		this.price = price;
		this.age = age;
		this.op1 = op1;
		this.op2 = op2;

	}
	/**
	 * 
	 * @return SN of Toy.
	 */

	public String getSN() {
		return SN;
	}
	
	/**
	 * 
	 * @return The toy name.
	 */

	public String getName() {
		return name;
	}
	/**
	 * 
	 * @return remainder of toys.
	 */

	public int getCount() {
		return count;
	}
/**
 * 
 * @return The toy brand.
 */
	public String getBrand() {
		return brand;
	}
/**
 * 
 * @return The cost of toy.
 */
	public double getPrice() {
		return price;
	}
/**
 * 
 * @return age rating for toy (age appropriate)
 */
	public int getAge() {
		return age;
	}
	/**
	 * 
	 * @return option 1 (initialization for item)
	 */

	public String getOp1() {
		return op1;
	}
/**
 * 
 * @return option 2 (initialization for item)
 */
	public String getOp2() {
		return op2;
	}
/**
 * No.2 (initialization for item)
 * @param Op2
 */
	public void setOp2(String Op2) {
		this.op2 = Op2;
	}

	/**
	 * 
	 * @param SN
	 * @return First number in the string
	 */
	public int groupSn(String SN) {
		String str = (SN).substring(0, 1);
		int num = Integer.parseInt(str);
		return num;

	}
} 