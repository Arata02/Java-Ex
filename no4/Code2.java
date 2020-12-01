package no4;

import java.util.Scanner;

public class Code2 {

	public static void main(String[] args) {

		Data[] data = new Data[3];

		String name;
		int age = 0;
		String address = "";

		for(int i = 0; i < 3; i++) {
			data[i] = new Data();
			System.out.println("名前");
			@SuppressWarnings("resource")
			Scanner scan = new Scanner(System.in);
			name = scan.nextLine();
			data[i].setName(name);

			System.out.println("年齢");
			age = scan.nextInt();
			scan.nextLine();

			data[i].setAge(age);

			System.out.println("住所");
			address = scan.nextLine();

			data[i].setAddress(address);
		}

		for(Data dt : data) {
			System.out.println("名前: " + dt.getName() + "\n年齢: " + dt.getAge() + "\n住所: " + dt.getAddress());
		}

	}
}