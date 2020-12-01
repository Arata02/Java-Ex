package no4;

public class Person {
	private int age;
	private double height;
	private double weight;

	public Person(int a, double h, double w) {
		age = a;
		height = h;
		weight = w;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public int getAge() {
		return age;
	}

	public double getHeight() {
		return height;
	}

	public double getWeight() {
		return weight;
	}
}