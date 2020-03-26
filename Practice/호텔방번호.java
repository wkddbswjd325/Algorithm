package AlgorithmPractice;

import java.util.Scanner;

public class 호텔방번호 {
	static boolean[] check;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n,m;
		while(sc.hasNext()) {
			n = sc.nextInt();
			m = sc.nextInt();
			
			int count = 0;
			for(int k = n; k <= m; k++) {
				check = new boolean[10];
				if(check(k)) count++;
			}
			System.out.println(count);
		}
	}
	public static boolean check(int k) {
		String s = Integer.toString(k);
		
		for(int i = 0; i < s.length(); i++) {
			if(check[s.charAt(i)-'0']) return false;
			check[s.charAt(i)-'0'] = true;
		}
		return true;
	}
}
