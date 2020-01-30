package AlgorithmHw;

import java.util.Scanner;

public class Solution_d2_2007_패턴마디의길이_장윤정 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        char[] carr = new char[30];
        for(int tc = 1; tc <= t; tc++) {
        	carr = sc.next().toCharArray();
        	
        	int count = 1;
        	
        	bp:for(int i = 1; i < 11; i++) {
        		count = 1;

        		if(carr[0] == carr[i]) {
        			
        			
        			for(int j = 1; j < i; j++) {
        				if(carr[j] != carr[i+j]) {
        					continue bp;
        				}
        				
        				count++;
        			}
        			
        			break;
        		}
        	}
        	
        	System.out.println("#" + tc + " " + count);
        	
        	
        }

	}

}
