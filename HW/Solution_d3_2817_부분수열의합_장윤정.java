package AlgorithmHw;

import java.util.Scanner;

public class Solution_d3_2817_부분수열의합_장윤정 {

	public static void main(String[] args) {
        // TODO Auto-generated method stub
 
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
         
        for(int tc = 1; tc <= t; tc++) {
             
            int count = 0;
             
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] arr = new int[n];
            for(int i = 0; i < n; i++)  {
                arr[i] = sc.nextInt();
            }
            int sum;
            for(int i = 0; i < (1<<n); i++) {
                sum = 0;
                for(int j = 0; j < n; j++) {
                    if((i&(1<<j)) > 0) {
                        sum += arr[j];
                    }
                }
                if(sum == k)
                    count++;
            }
                 
             
            System.out.println("#" + tc + " " + count);
        }
         
	}

}


