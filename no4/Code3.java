package no4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Code3 {

	public static void main(String[] args) {

		Data[] data = new Data[3];

		FileInputStream fs = null;
		InputStreamReader ir = null;
		BufferedReader br = null;

		try {
			fs = new FileInputStream("C:\\Users\\Kaiki\\Desktop\\Code3.csv");

			ir = new InputStreamReader(fs);
			br = new BufferedReader(ir);

			String input;
			int i = 0;


			while((input = br.readLine()) != null) {
				String[] line = input.split(",");

				data[i] = new Data();
				data[i].setName(line[0]);
				data[i].setAge(Integer.parseInt(line[1]));
				data[i].setAddress(line[2]);
				i++;
			}

			for(Data dt : data) {
				System.out.println("名前: " + dt.getName() + "\n年齢: " + dt.getAge() + "\n住所: " + dt.getAddress());
			}


		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}finally {
			try {
				br.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}