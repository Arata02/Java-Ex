package no4;

import java.util.Scanner;

public class Code1 {

	public static void main(String[] args) {

		Person[] person = new Person[2];
		int a = 0;
		double h = 0.0;
		double w = 0.0;

		for(int i = 0; i < 2; i++) {
			System.out.println(i+1 + "人目の年齢を入力してください。");
			@SuppressWarnings("resource")
			Scanner scan = new Scanner(System.in);
			a = scan.nextInt();

			System.out.println(i+1 + "人目の身長を入力してください。");
			h = scan.nextDouble();

			System.out.println(i+1 + "人目の体重を入力してください。");
			w = scan.nextDouble();

			person[i] = new Person(a, h, w);
		}

		for(int j = 0; j < 2; j++) {
			System.out.println(j+1 + "人目:年齢 " + person[j].getAge() + " 身長 " + person[j].getHeight() + " 体重 "  + person[j].getWeight());
		}

	}
}