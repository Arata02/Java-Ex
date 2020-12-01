package no5;

import java.util.Scanner;

public class Code1 {

	public static void main(String[] args) {

		int count[] = new int[10];
		for(int i = 0; i < count.length; i++) {
			count[i] = 0;
		}

		System.out.println("成績を入力してください。\n終了の場合は負の値を入力してください。");
		while(true) {
			@SuppressWarnings("resource")
			Scanner scan = new Scanner(System.in);
			int num = scan.nextInt();

			if(num < 0) {
				break;
			}else if(num > 100){
				System.out.println("無効な入力です。");
				return;
			}
			count[num % 10 == 0 && num != 0? num / 10-1 : num / 10]++;
		}

		System.out.println("\t 点数\t人数\tヒストグラム");
		for(int i = 0; i < count.length; i++){
			String bottomSpace = "";
			String topSpace = "";
			String bottom = ""+(i*10+(1*(new Boolean(i!=0)).compareTo(false)));
			String top = ""+(i*10+10);
			for(int j = 0; j<3-bottom.length(); j++) bottomSpace+=" ";
			for(int j = 0; j<3-top.length(); j++) topSpace+=" ";
			System.out.print("\t"+bottomSpace+bottom+"-"+topSpace+top+"\t\t"+count[i]+"\t");
			//System.out.print("\t"+(i*10+(1*(new Boolean(i!=0)).compareTo(false)))+"-"+(i*10+10)+"\t\t"+count[i]+"\t");
			for(int j = 0; j < count[i]; j++){
				System.out.print("*");
			}
			System.out.println();
		}
	}
}