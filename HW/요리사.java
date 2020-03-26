package AlgorithmHw;

import java.io.*;
import java.util.*;

public class 요리사 {
	static int n;
	static int[][] board;
	static boolean[] food;
	static int min;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		for(int tc = 1; tc <= t; tc++) {
			n = Integer.parseInt(br.readLine());
			board = new int[n][n];
			for(int i = 0 ; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0 ; j < n; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			food = new boolean[n];
			min = 987654321;
			food[0] = true;
			cook(1,1);
			
			sb.append("#").append(tc).append(" ").append(min).append("\n");
		}
		System.out.println(sb.toString());
	}
	public static void cook(int idx, int cnt) {
		if(cnt == n/2) {
			//값 만들기
			int gap = calc();
			if(gap < min) 
				min = gap;
			return;
		}
		
		for(int i = idx; i <= n/2+cnt; i++) {
			food[i] = true;
			cook(i+1, cnt+1);
			food[i] = false;
		}
	}
	public static int calc() {
		int a = 0;
		int b = 0;
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(food[i]) {
					if(food[j]) a += board[i][j];
				}
				if(!food[i]) {
					if(!food[j]) b += board[i][j];
				}
			}
		}
		return Math.abs(a-b);
	}
}
