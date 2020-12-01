package no2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Code11 {

	public static void main(String[] args) {
		System.out.println("入力してください。");
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		if(scan.hasNext("q")) {
			System.out.println("終了します");
			return;
		}
		int numOfInput = 3;
		String[] inputTexts = new String[numOfInput];
		String result;
		for(int i = 0; i < numOfInput; i++) {
			inputTexts[i] = scan.next();
		}
		System.out.println("値の大きな記号から表示します。");
		result = check(inputTexts);
		System.out.println(result);
	}

	public static String check(String[] texts) {
		String regex = "(<=|>=|<|>)";
		Set<String> wordSet = new HashSet<>();
		for(int i = 0; i < texts.length; i++) {
			Pattern pattern = Pattern.compile(regex);
			Matcher match = pattern.matcher(texts[i]);
			if(match.find()) {
				String left, right;
				left = texts[i].substring(0, match.start());
				right = texts[i].substring(match.end(), texts[i].length());
				wordSet.add(left);
				wordSet.add(right);
			}
		}
		Map<String, Integer> map = new HashMap<>();
		Iterator<String> iter = wordSet.iterator();
		while(iter.hasNext()) {
			map.put(iter.next(), 0);
		}

		String[] regexes = {"<=", ">=", "<", ">"};
		for(int i = 0; i < texts.length; i++) {
			for(int j = 0; j < regexes.length; j++) {
				Pattern pattern = Pattern.compile(regexes[j]);
				Matcher match = pattern.matcher(texts[i]);
				if(match.find()) {
					String operator = match.group();
					String left, right;
					left = texts[i].substring(0, match.start());
					right = texts[i].substring(match.end(), texts[i].length());
					switch(operator){
					case "<=":
					case "<":
						map.replace(right, map.get(right)+1);
						break;
					case ">=":
					case ">":
						map.replace(left, map.get(left)+1);
						break;
					}
					break;
				}
			}
		}

		List<Entry<String, Integer>> listEntry = new ArrayList<>(map.entrySet());

		Collections.sort(listEntry, new Comparator<Entry<String, Integer>>(){
			public int compare(Entry<String, Integer> obj1, Entry<String, Integer>obj2) {
				return obj2.getValue().compareTo(obj1.getValue());
			}
		});

		String result = "";
		for(Entry<String, Integer> entry : listEntry) {
			result+= entry.getKey();
		}
		return result;
	}
}