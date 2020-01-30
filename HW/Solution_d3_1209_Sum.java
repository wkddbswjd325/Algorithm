package AlgorithmHw;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_d3_1209_Sum {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		System.setIn(new FileInputStream("res/input_1209.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = 100;
		int[] sum_v;
		int[] sum_h;
		int sum_a;
		int sum_b;
		
		for(int test_case = 1; test_case <= 10; test_case++) {
			int t = Integer.parseInt(br.readLine());
			int answer = 0;
			sum_v = new int[n];
			sum_h = new int[n];
			sum_a = 0;
			sum_b = 0;
			int num;
			
			for(int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < n; j++) {
					num = Integer.parseInt(st.nextToken());
					sum_v[i] += num;
					sum_h[j] += num;
					
					if(i == j) 
						sum_a += num;
					
					if(i+j == n-1)
						sum_b += num;
				}
			}
			
			if(sum_a > sum_b) 
				answer = sum_a;
			else
				answer = sum_b;
			
			for(int i = 0; i < n; i++) {
				if(sum_v[i] > answer)
					answer = sum_v[i];
				
				if(sum_h[i] > answer)
					answer = sum_h[i];
				
			}
			
			
			System.out.println("#" + t + " " + answer);
		}
	}

}
