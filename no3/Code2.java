package no3;

import java.util.Scanner;

public class Code2 {

	public static void main(String[] args) {
		System.out.println("メッセージを入力してください。");

		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);

		String input = scan.nextLine();

		int num = input.length();

		System.out.println("文字数は" + num + "です。");

		System.out.println("スペースを改行に変換します。");

		System.out.println(input.replaceAll(" ", "\n"));

	}
}
