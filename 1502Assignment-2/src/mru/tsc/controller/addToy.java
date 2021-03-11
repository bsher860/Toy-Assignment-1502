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

	public String getSN() {
		return SN;
	}
	
	public String getName() {
		return name;
	}
	public int getCount() {
	return count;
}
	public String getBrand() {
		return brand;
	}
	public double getPrice() {
		return price;
	}
	public int getAge() {
		return age;
	}
	public String getOp1() {
		return op1;
	}
	public String getOp2() {
		return op2;
	}
	
	public void setOp2(String Op2) {
		this.op2 = Op2;
	}
	
	public int groupSn(String SN) {
		String str = (SN).substring(0,1);
		int num = Integer.parseInt(str);
		return num;
		
	}
} 