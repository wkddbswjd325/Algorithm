package AlgorithmPractice;

import java.util.Scanner;

public class 퇴사 {
	static int n;
	static int[] memo;
	static int[] t, p;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		memo = new int[n+1];
		t = new int[n+1];
		p = new int[n+1];
		for(int i = 1; i <=n; i++) {
			t[i] = sc.nextInt();
			p[i] = sc.nextInt();
		}
		
		System.out.println(meeting(1));
	}
	public static int meeting(int day) {
		if(day > n) return 0;
		
		if(memo[day]>0) return memo[day];
		
		int result = 0;
		result = Math.max(result, meeting(day+1));
		
		if(day+t[day]-1 <= n)
			result = Math.max(result, p[day] + meeting(day+t[day]));
		
		return memo[day] = result;
	}

}
