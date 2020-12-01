package no2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Code3 {

	public static void main(String[] args) {

		try {
			File file = new File("C:\\Users\\Kaiki\\Desktop\\in.txt");

			if (!file.exists()) {
				System.out.println("No File");
				return;
			}

			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String data;

			System.out.println("in.txtを読み込みました。");
			while((data = bufferedReader.readLine()) != null) {
				System.out.println("読み込んだ文字は"+ data);
			}
			bufferedReader.close();

		}catch (IOException e) {
			e.printStackTrace();
		}

	}

}
