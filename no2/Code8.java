package no2;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Code8 {


	public static void main(String[] args) {
		int numOfInput = 3;
		String[] result = new String[numOfInput];
		System.out.println("入力してください。");
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);

		for(int i = 0; i < numOfInput; i++) {
			String str = scan.next();
			result[i] = change(str);
		}

		System.out.println("右辺と左辺を逆に表示します");
		for(int i = 0; i < numOfInput; i++) {
			System.out.println(result[i]);
		}
	}

	private static String change(String input) {
		String[] regex = {"<", ">", "="};
		for(int i = 0; i < regex.length; i++) {
			Pattern pattern = Pattern.compile(regex[i]);
			Matcher match = pattern.matcher(input);
			if(match.find()) {
				return swap(input, match.group(), match.start(), match.end());
			}
		}
		return "Not match";

	}

	private static String swap(String str, String sign, int startIndex, int endIndex) {
		String right = str.substring(0, startIndex);
		String left = str.substring(endIndex, str.length());
		switch(sign) {
		case ">":
			sign = "<";
			break;
		case "<":
			sign = ">";
			break;
		}
		return left + sign + right;
	}
}