package yun_hw;

import java.util.Scanner;

public class Solution_로봇이동거리_서울_06_장윤정 {
	
	public static int[] dx = {0,0,1,-1};
	public static int[] dy = {1,-1,0,0};

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		char[][] carr;
		for (int tc = 1; tc <= t; tc++) {
			int n = sc.nextInt();
			carr = new char[n][n];

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					carr[i][j] = sc.next().charAt(0);
				}
			}
			
			int direc, x, y;
			int count = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if(carr[i][j] != 'S' && carr[i][j] != 'W') {
						direc = carr[i][j] - 'A'; 
						if(direc == 2) direc++;
						for(int d = 0; d <= direc; d++) {
							x = i + dx[d];
							y = j + dy[d];
							while(0 <= x && x < n && 0 <= y && y < n && carr[x][y] == 'S') {								
								count++;
								x += dx[d];
								y += dy[d];
							}
							
						}
					}
				}
			}
			
		
			System.out.println("#"+tc+" "+count);
			
		}

	}

}
