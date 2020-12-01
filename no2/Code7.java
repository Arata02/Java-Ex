package no2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Code7 {

	public static void main(String[] args) {
		File file = new File("C:\\Users\\Kaiki\\Desktop\\in.txt");
		try(BufferedReader br = new BufferedReader(new FileReader(file))){
			System.out.println("in.txtを読み込みました");
			String str;
			while((str = br.readLine()) != null) {
				System.out.println(str);
			}
			br.close();
		}catch(FileNotFoundException e) {
			System.out.println("ファイルが存在しません");
			System.out.println(e);
			return;
		}catch(IOException e) {
			System.out.println("エラー");
			System.out.println(e);
			return;
		}
	}
}
