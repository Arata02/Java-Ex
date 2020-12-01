package no2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class Code2 {

	public static void main(String[] args) {

		String str = "";

		System.out.println("名前を入力してください。");

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
		str = br.readLine();
		}catch(IOException e) {
			System.out.println("Error");
		}

		try {
			File file = new File("C:\\Users\\Kaiki\\Desktop\\out.txt");
			FileWriter fw = new FileWriter(file);

			fw.write(str);

			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("out.txtに" + str + "と出力しました。");

	}

}
