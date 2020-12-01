package no2;

import java.util.Scanner;

public class Code5 {

	public static void main(String[] args) {
		int n = -1;
		Scanner scan = null;
		while(n > 10 || n < 0){
			System.out.println("10以下の整数nの値を入力してください。");
			scan = new Scanner(System.in);
			if(scan.hasNextInt()) {
				n = scan.nextInt();
				calc(n);
			}
		}
		scan.close();
	}

	private static void calc(int x)  {
		if(x<0) {
			System.out.println("非負整数を入力してください");
			return;
		}
		if(x==0) {
			System.out.println("0! = 1");
			return;
		}if(x>10) {
			System.out.println("10以下の整数を入力してください。");
			return;
		}for(int i = 1; i<=x; i++) {
			int mul = 1;
			String formula = "";
			for(int j = i; j > 0; j--) {
				mul *=j;
				formula += ""+j;
				if(j==1)continue;
				formula += "*";
			}
			System.out.println(x + "! = " + formula + "=" + mul);
		}
	}
}