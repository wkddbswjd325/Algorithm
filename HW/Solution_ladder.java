package AlgorithmHw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution_ladder {
 
    public static void main(String args[]) throws Exception
    {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        int[][] matrix;
        StringTokenizer st;
 
        for(int test_case = 1; test_case <= 10; test_case++)
        {
            int t = Integer.parseInt(br.readLine());
            matrix = new int[100][100];
            
            for(int i = 0; i < 100; i++) {
            	st = new StringTokenizer(br.readLine());
                for(int j = 0; j < 100; j++) {
                    matrix[i][j] = Integer.parseInt(st.nextToken());
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
             
            while(dx != 0) {
                 
                if(dy!=0 && matrix[dx][dy-1] == 1) {
                    while(dy != 0 && matrix[dx][dy-1] == 1) {
                        dy--;   
                    }
                    dx--;
                }
                 
                else if(dy!=99 && matrix[dx][dy+1] == 1) {
                    while(dy != 99 && matrix[dx][dy+1] == 1) {
                        dy++;
 
                    }
                    dx--;
                }
                 
                else dx--;
                 
                 
                 
            }
 
            System.out.println("#"+t + " " + dy);
        }
         
        br.close();
 
    }       
 
}