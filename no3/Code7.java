package no3;

import java.util.Scanner;

public class Code7 {
	public static void main(String[] args) {

		System.out.println("0：キャラ型, 1：キャラ型と検索開始位置,\n2：文字列, 3：文字列と検索開始位置");
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		int num;
		try {
			num = scan.nextInt();
		} catch (Exception e) {
			System.out.println("終了します");
			scan.close();
			return;
		}

		switch(num) {
		case 0:
			System.out.println("キャラ型");
			break;
		case 1:
			System.out.println("キャラ型と検索開始位置");
			break;
		case 2:
			System.out.println("文字列");
			break;
		case 3:
			System.out.println("文字列と検索開始位置");
			break;
		default:
			System.out.println("終了します");
			scan.close();
			return;
		}

		scan.nextLine();

		System.out.println("入力してください。");
		String input = scan.nextLine();

		SearchSentence s = new SearchSentence(input);
		System.out.println("入力された文字列は" + input + "です。");

		String words;
		char word;
		int position;

		System.out.println("検索したい文字を入力してください。");
		switch(num) {
		case 0:
			word = scan.next().charAt(0);
			System.out.println("検索文字は" + word + "です。");
			System.out.print("検索結果：");
			System.out.println(s.indexOf(word));
			break;
		case 1:
			word = scan.next().charAt(0);
			System.out.println("検索開始位置を入力してください。");
			position = scan.nextInt();
			System.out.println("検索文字は" + word + "検索開始位置は" + position + "です。");
			System.out.print("検索結果：");
			System.out.println(s.indexOf(word, position));
			break;
		case 2:
			scan = new Scanner(System.in);
			words = scan.nextLine();
			System.out.println("検索文字は" + words + "です。");
			System.out.print("検索結果：");
			System.out.println(s.indexOf(words));
			break;
		case 3:
			words = scan.nextLine();
			System.out.println("検索開始位置を入力してください。");
			position = scan.nextInt();
			System.out.println("検索文字は" + words + "検索開始位置は" + position + "です。");
			System.out.print("検索結果：");
			System.out.println(s.indexOf(words, position));
			break;
		}
	}
}

class SearchSentence {
	String sentence;
	char chr;
	public SearchSentence(String str) {
		this.sentence = str;
	}

	public int indexOf(char c) {
		for(int i = 0; i < sentence.length(); i ++) {
			if (sentence.charAt(i) == c) {
				return i;
			}
		}
		return -1;
	}

	public int indexOf(char c, int first) {
		for (int i = first; i < sentence.length(); i++) {
			if(sentence.charAt(i) == c) {
				return i;
			}
		}
		return -1;
	}

	public int indexOf(String str) {
		for(int i = 0; i < sentence.length() - str.length() + 1; i++) {
			if(sentence.substring(i, i + str.length()).equals(str) ) {
				return i;
			}
		}
		return -1;
	}

	public int indexOf(String str, int first) {
		for(int i = first; i < sentence.length() - str.length() + 1; i++) {
			if(sentence.substring(i, i + str.length()).equals(str) ) {
				return i;
			}
		}
		return -1;
	}
}