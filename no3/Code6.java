package no3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Code6 {

	public static void main(String[] args) {

		try {
			File file = new File("C:\\Users\\Kaiki\\Desktop\\Sample.txt");

			if (!file.exists()) {
				System.out.println("No File");
				return;
			}

			BufferedReader br = new BufferedReader(new FileReader(file));

			String str;
			String words;
			String revAlha;
			List<String> list = new ArrayList<String>();

			while((str = br.readLine()) != null) {
				revAlha = reverseAlhabet(str);
				words = reverse(revAlha);
				list.add(words);
			}

			for(int i = list.size() - 1; i >= 0; i--) {
				System.out.println(list.get(i));
			}

			br.close();

		}catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static String reverse(String source) {
		StringBuffer dest = new StringBuffer();
		for (int i = source.length() - 1; i >= 0; i-- ) {
			dest.append(source.charAt(i));
		}
		return dest.toString();
	}

	public static String reverseAlhabet(String s) {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			char cc = s.charAt(i);
			if (Character.isUpperCase(c)) {
				cc = Character.toLowerCase(c);
				sb.append(cc);
			}else if(Character.isLowerCase(c)){
				cc = Character.toUpperCase(c);
				sb.append(cc);
			}else {
				sb.append(cc);
			}
		}
		return sb.toString();
	}
}