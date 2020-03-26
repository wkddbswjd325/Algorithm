package AlgorithmHw;

import java.util.Scanner;

public class 달리기2 {
	static int T,N,M;
	static int count;
	static int[] needs;
	static long[] memo;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		T = scan.nextInt();
		for(int t = 1; t <= T; t++) {
			int f,s;
			count = 0;
			N = scan.nextInt();
			M = scan.nextInt();
			needs = new int[N];
			memo = new long[(1<<N)];
			for(int i = 0; i < M; i++) {
				f = scan.nextInt()-1;
				s = scan.nextInt()-1;
				needs[f] |= (1<<s);
			}
			
			long r = dfs(0);
			System.out.println("#"+t+" "+r);
		}
	}
	private static long dfs(int flag) {
		if(flag==(1<<N)-1) {
//			count++;
			return 1;
		}
		if(memo[flag] > 0) return memo[flag];
		for(int i = 0; i < N; i++) {
			if((flag & 1 << i) == 0) { //안 간 길이 있다면
				if((flag & needs[i]) == needs[i]) {
					memo[flag] += dfs(flag | 1<<i);
				}
			}
		}
		
		return memo[flag];
	}

}
