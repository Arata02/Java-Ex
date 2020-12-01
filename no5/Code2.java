package no5;

import java.util.Scanner;

public class Code2 {

	public static void main(String[] args) {
		System.out.println("文を入力してください");
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		String letter = scan.nextLine();
		letter = letter.replaceAll("[^a-zA-Z]", "").toLowerCase();

		System.out.println(letter);

		if(isPalindrome(letter)) {
			System.out.println("回文です");
		}else {
			System.out.println("回文ではありません");
		}
	}

	public static boolean isPalindrome(String sentence) {
		StringBuilder sb = new StringBuilder(sentence);
		return sentence.equals(sb.reverse().toString());
	}
}