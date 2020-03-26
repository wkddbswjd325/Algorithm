package AlgorithmPractice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 지희의고장난계산기 {
	static boolean[] calc = new boolean[10];
	static int x;
	static int min;
	static final int INF = 987654321;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < 10; i++) {
				if(Integer.parseInt(st.nextToken()) == 1) calc[i] = true;
				else calc[i] = false;
			}
			x = Integer.parseInt(br.readLine());
			min = INF;
			calculation(x, 1);
			if(min == INF) min = -1;
			System.out.println("#"+tc+" "+min);
		}
	}
	public static void calculation(int num, int cnt) {
		if(cnt >= min) return;
		
		int l = check(num);
		if(l != -1) {
			min = cnt + l;
			return;
		}
		
		for(int i = 2; i <= (num+1)/2; i++) {
			l = check(i);
			if(num%i == 0 && l != -1) calculation(num/i,cnt+l+1);
		}
	}
	public static int check(int num) {
		String s = Integer.toString(num);
		for(int i = 0; i < s.length(); i++) {
			if(!calc[s.charAt(i)-'0']) return -1;
		}
		return s.length();
	}
}
