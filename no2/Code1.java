package no2;

import java.util.Scanner;

public class Code1 {

	public static void main(String[] args) {
		System.out.println("名前を入力してください。");
		Scanner scanner = new Scanner(System.in);
		String input_text = scanner.nextLine();
		System.out.println("あなたの名前は" + input_text + "です。");

		scanner.close();

	}

}
