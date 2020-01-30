package AlgorithmHw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_d3_9229_한빈이와SpotMart {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T= Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int answer = -1;
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			int[] arr = new int[n];
			
			for(int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			int tmp;
			for(int i = 0; i < n; i++) {
				for(int j = i+1; j < n; j++) {
					tmp = arr[i] + arr[j];
					if(tmp <= m && tmp > answer)
						answer = tmp;
				}
			}
			
			
			
			System.out.println("#" + test_case + " " + answer);

		}
	}

}
