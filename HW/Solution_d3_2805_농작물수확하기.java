package AlgorithmHw;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_d3_2805_농작물수확하기 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		System.setIn(new FileInputStream("res/input_2805.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		String str;
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int n = Integer.parseInt(br.readLine());

			
			int a = n/2;
			int cnt = 1;
			int profit = 0;
			
			for(int i = 0 ; i < n; i++) {
				str = br.readLine();
				for(int j = a; j < a+cnt; j++) {
					profit += str.charAt(j) - '0';		
				}
				
				if(i < n/2) {
					a--;
					cnt+=2;
				}
				else {
					a++;
					cnt-=2;
				}
			}	
			
			
			System.out.println("#"+test_case+" "+profit);
			
			
		}

	}

}
