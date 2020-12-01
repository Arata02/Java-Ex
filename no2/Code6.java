package no2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Code6 {

	public static void main(String[] args) {

		int numOfInput = 3;
		BufferedWriter bw = null;
		//String filename = "out.txt";
		System.out.println("名前を" + numOfInput + "回入力してください。");


		try {
			File file = new File("C:\\Users\\Kaiki\\Desktop\\out.txt");
			FileWriter fw = new FileWriter(file);
			bw = new BufferedWriter(fw);
			Scanner scan = new Scanner(System.in);
			String name;
			String names = "";

			for(int i = 0; i < numOfInput; i++) {
				name = scan.next();
				bw.write(name);
				bw.newLine();
				names += name;
				if(i==numOfInput-1)continue;
				names += ",";
			}
			bw.flush();
			scan.close();
			System.out.printf("out.txtに%sと出力しました。\n", names);
		}catch(Exception e) {
			System.out.println("例外");
			System.out.println(e);
			e.printStackTrace();
		}finally {
			try {
				if(bw != null) {
					bw.close();
				}
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
}