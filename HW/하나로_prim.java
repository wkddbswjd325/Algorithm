package AlgorithmHw;

import java.io.*;
import java.util.*;

public class 하나로_prim {
	static class Edge implements Comparable<Edge> {
		int v;
		double dist;
		public Edge(int v, double dist) {
			this.v = v; this.dist = dist;
		}
		@Override
		public int compareTo(Edge e) {
			return Double.compare(this.dist, e.dist);
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int n;
		double e;
		int[][] pos;
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		boolean[] visit;
		for(int tc = 1; tc <= t; tc++) {
			n = Integer.parseInt(br.readLine());
			
			pos = new int[n][2];
			for(int j = 0; j < 2; j++) {
				st = new StringTokenizer(br.readLine());
				for(int i = 0; i < n; i++) 
					pos[i][j] = Integer.parseInt(st.nextToken());
			}
			e = Double.parseDouble(br.readLine());
			pq.clear();
			double answer = 0.0;
			double tmp = 0.0;
			visit = new boolean[n];
			//0부터 가는 간선
			visit[0] = true;
			for(int i = 1; i < n; i++) {
				tmp = e*(Math.pow(Math.abs(pos[0][0]-pos[i][0]),2)+Math.pow(Math.abs(pos[0][1]-pos[i][1]),2));
				pq.offer(new Edge(i,tmp));
			}
			
			Edge ee;
			int cnt=0;
			while(!pq.isEmpty()) {
				ee = pq.poll();
				if(visit[ee.v]) continue;
				visit[ee.v] = true;
				answer += ee.dist;
				cnt++;
				for(int i = 1; i < n; i++) {
					if(visit[i]) continue;
					tmp = e*(Math.pow(Math.abs(pos[ee.v][0]-pos[i][0]),2)+Math.pow(Math.abs(pos[ee.v][1]-pos[i][1]),2));
					pq.offer(new Edge(i,tmp));
				}
				if(cnt == n-1) break;
			}
			sb.append("#").append(tc).append(" ").append(Math.round(answer)).append("\n");
		}
		System.out.println(sb.toString());
	}

}
