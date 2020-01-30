package AlgorithmHw;

import java.util.Scanner;

public class Solution_42_미로도착지점_장윤정 {
	
	public static int[] dx = {0,-1,0,1,0};
	public static int[] dy = {0,0,1,0,-1};

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		int n, x, y;
		int jp;
		int m;
		boolean[][] map;
		
		for(int tc = 1; tc <= t; tc++) {
			n = sc.nextInt();
			x = sc.nextInt();
			y = sc.nextInt();
			
			jp = sc.nextInt();

			map = new boolean[n+1][n+1];
			int a,b;
			
			for(int i = 0; i < jp; i ++) {
				a = sc.nextInt();
				b = sc.nextInt();
				map[a][b]=true;
			}
			
			m = sc.nextInt();
			int direc, dist;
			
			for(int i = 0; i < m; i ++) {
				direc = sc.nextInt();
				dist = sc.nextInt();
				
				if(x == 0 && y == 0) continue;
				
				for(int d = 0; d < dist; d++) {
					x += dx[direc];
					y += dy[direc];
					
					//범벗
					if(x <= 0 || x > n || y <= 0 || y > n || map[x][y]) {
						x = 0;
						y = 0;
						break;
					}
				}
				
				
			}
			
			System.out.println("#"+tc+" "+x+" "+y);
			
		}
		
	}

}
