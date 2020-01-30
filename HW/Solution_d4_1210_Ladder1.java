package AlgorithmHw;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution_d4_1210_Ladder1 {

	public static void main(String args[]) throws Exception
	{
		System.setIn(new FileInputStream("res/input_1210.txt"));
		Scanner sc = new Scanner(System.in);
		
		int[][] matrix;
		int answer = 0;
		
		int[][] direction = {{-1,0},{0,-1},{0,1}}; // 위 d[0][0], d[0][1]
		

		for(int test_case = 1; test_case <= 10; test_case++)
		{
			int t = sc.nextInt();
			matrix = new int[100][100];
			
			for(int i = 0; i < 100; i++) {
				for(int j = 0; j < 100; j++) {
					matrix[i][j] = sc.nextInt();
				}
			}
				
			int dx = 99;
			int dy = 0;
			
			for(int i = 0; i < 100; i++) {
				if(matrix[99][i] == 2) {
					dy = i;
					break;
				}
			}
			
			int d = 0;
			
			while(dx != 0) {
				
				//위
				if(d == 0) {
					
				}
				
				//왼
				else if(d == 1) {
					
				}
			
				//오
				else if (d==2) {
					
				}
				
			}

			System.out.println(t + " " + answer);
		}
		
		sc.close();

	}		

}
