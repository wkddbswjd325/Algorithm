package AlgorithmHw;

import java.io.*;
import java.util.*;

public class 하나로 {
	static class Edge implements Comparable<Edge> {
		int s; int e;
		double dist;
		public Edge(int s, int e, double dist) {
			this.s= s; this.e = e; this.dist = dist;
		}
		@Override
		public int compareTo(Edge e) {
			return Double.compare(this.dist, e.dist);
		}
	}
	static int[] parent;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int n;
		double e;
		int[][] pos;
		PriorityQueue<Edge> pq = new PriorityQueue<>();
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
			double tmp = 0.0;
			for(int i = 0; i < n; i++) {
				for(int j = i+1; j < n; j++) {
					tmp = e*(Math.pow(Math.abs(pos[i][0]-pos[j][0]),2)+Math.pow(Math.abs(pos[i][1]-pos[j][1]),2));
					pq.offer(new Edge(i,j,tmp));
				}
			}
			
			double answer = 0.0;
			parent = new int[n];
			for(int i = 0; i < n; i++) parent[i] = i;
			
			Edge ee = null;
			while(!pq.isEmpty()) {
				ee = pq.poll();
				if(findSet(ee.s) != findSet(ee.e)) {
					answer += ee.dist;
					union(ee.s, ee.e);
				}
			}
			
			sb.append("#").append(tc).append(" ").append(Math.round(answer)).append("\n");
		}
		System.out.println(sb.toString());
	}
	public static void union(int s, int e) {
		s = findSet(s);
		e = findSet(e);
		if(s!=e)
			parent[e] = s;
	}
	public static int findSet(int n) {
		if(n == parent[n]) return n;
		return parent[n] = findSet(parent[n]);
	}
}
