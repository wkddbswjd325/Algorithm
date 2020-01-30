package AlgorithmHw;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_d2_1954_달팽이숫자 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		int T;
		T = scan.nextInt();
		
		int[] dx = {0,1,0,-1};
		int[] dy = {1,0,-1,0};
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int n = scan.nextInt();
			int[][] arr = new int[n][n];
			int x = 0;
			int y = 0;
			int d = 0;
			int num = 1;
			
			int dist = n - 1;
			arr[0][0] = num;
			for(int i = 0; i < dist; i++) {
				arr[x+=dx[d]][y+=dy[d]] = ++num;
			}
			d++;
			
			while(dist > 0) {
				for(int k = 0; k < 2; k++) {
					
					for(int i = 0; i < dist; i++) {
						arr[x+=dx[d]][y+=dy[d]] = ++num;
					}
					
					d++;
					if(d == dx.length) d = 0;
					
				}
				dist--;
			}
			
			System.out.println("#" + test_case);
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					System.out.print(arr[i][j] +" ");
				}
				System.out.println();
			}
		}
		
	}

}
