package no3;

import java.util.Scanner;

public class Code1 {

	public static void main(String[] args) {
		System.out.println("メッセージを入力してください。");

		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);

		String input = scan.nextLine();

		int num = input.length();

		System.out.println("文字数は" + num + "です。");

	}

}
