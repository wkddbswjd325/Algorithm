package AlgorithmHw;

import java.util.Scanner;

public class Solution_d3_5356_의석이의세로로말해요 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		int T;
		T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			String[] sarr = new String[5];
			StringBuilder sb = new StringBuilder();
			int length = 0;
			
			for(int i = 0; i < sarr.length; i++) {
				sarr[i] = sc.next();
				if(length < sarr[i].length()) 
					length = sarr[i].length();
			}
						
			for(int k = 0; k < length; k++) {
				for(int i = 0; i < sarr.length; i++) {
					if(k >= sarr[i].length()) continue;
					sb.append(sarr[i].charAt(k));
					
				}
				
			}
			
			System.out.println("#" + test_case + " " + sb);
			
		}
		
	}

}
