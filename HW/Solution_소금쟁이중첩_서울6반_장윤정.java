package yun_hw;

import java.util.Scanner;

public class Solution_소금쟁이중첩_서울6반_장윤정 {
	
	public static int[] dx = {0,1,0};
	public static int[] dy = {0,0,1};

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int t= sc.nextInt();
		boolean[][] pond;
		
		for(int tc = 1; tc <= t; tc++) {
			int n = sc.nextInt();
			int b = sc.nextInt();
			
			pond = new boolean[n][n];
			int x,y,d;
			int ans = 0;
			for(int i = 0; i < b; i++) {
				x = sc.nextInt();
				y = sc.nextInt();
				d = sc.nextInt();
				
				pond[x][y] = true;
				
				for(int j = 3; j > 0; j--) {
					
					x += dx[d]*j;
					y += dy[d]*j;
					
					if(x < 0 || x >= n || y < 0 || y >= n) {
						break;
					}
					
					if(pond[x][y]) {
						ans = i+1;
						break;
					}
					
					pond[x][y] = true;
				}
						
			}
			

			System.out.println("#"+tc+" "+ans);
		}
	}

}
