package AlgorithmPractice;

import java.io.*;
import java.util.*;
public class 최솟값찾기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		ArrayDeque<Integer> dq = new ArrayDeque<>();
		st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int[] arr = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			while(!dq.isEmpty() && arr[dq.peekLast()] > arr[i]) dq.pollLast();
			dq.offer(i);
			if(dq.peek() < i-l+1) dq.pollFirst();
			sb.append(arr[dq.peekFirst()]).append(" ");
		}
		bw.write(sb.toString());
		bw.close();
	}
}
