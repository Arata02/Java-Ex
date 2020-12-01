package no3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Code5 {

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
			List<String> list = new ArrayList<String>();

			while((str = br.readLine()) != null) {
				words = reverse(str);
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
}