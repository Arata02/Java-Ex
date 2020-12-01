package no3;

import java.util.Random;

public class Code4 {


	public static void main(String[] args) {


		Random rnd = new Random();
		int[] num = new int[20];
		int[] plus = new int[20];
		int[] minus = new int[20];
		int count_plus = 0;
		int count_minus = 0;

		for(int i = 0; i < 20; i++) {
			num[i] = rnd.nextInt();
			if(num[i] >= 0) {
				plus[i] = num[i];
				count_plus++;
			}else if(num[i] < 0){
				minus[i] = num[i];
				count_minus++;
			}
		}

		System.out.println(count_plus);

		System.out.println(">=0");
		for(int j = 0; j < 20; j++) {
			if(plus[j] != 0) {
				System.out.print(plus[j]);
				if(count_plus  != 1) {
					System.out.print(", ");
					count_plus--;
				}
			}
		}
		System.out.println("\n");

		System.out.println("<0");
		for(int j = 0; j < 20; j++) {
			if(minus[j] != 0) {
				System.out.print(minus[j]);
				if(count_minus  != 1) {
					System.out.print(", ");
					count_minus--;
				}
			}
		}
		System.out.print("\n");
	}
}