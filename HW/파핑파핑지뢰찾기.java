package AlgorithmHw;

import java.io.*;
import java.util.*;

public class 파핑파핑지뢰찾기 {
	static class Point{
		int x;
		int y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static int n;
	static int[][] map;
	static boolean[][] visit;
	static int[] dx = {-1,-1,-1,0,0,1,1,1};
	static int[] dy = {-1,0,1,-1,1,-1,0,1};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		String s;
		int nx, ny;
		for(int tc = 1; tc <= t; tc++) {
			int answer = 0;
			n = Integer.parseInt(br.readLine());
			map = new int[n][n];
			visit = new boolean[n][n];
			for(int i = 0; i < n; i++) {
				s = br.readLine();
				for(int j = 0; j < n; j++) {
					if(s.charAt(j) == '.') continue;
					visit[i][j] = true;
					for(int d = 0; d < 8; d++) {
						nx = i + dx[d];
						ny = j + dy[d];
						if(nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
						map[nx][ny]++;
					}
				}
			}
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					if(map[i][j] == 0 && !visit[i][j]) {
						check(i,j);
						answer++;
					}
				}
			}
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					if(!visit[i][j]) {
						answer++;
					}
				}
			}
			sb.append("#").append(tc).append(" ").append(answer).append("\n");
		}
		System.out.println(sb.toString());
	}
	public static void check(int x, int y) {
		Queue<Point> q = new LinkedList<>();
		Point p;
		q.offer(new Point(x,y));
		visit[x][y] = true;
		int nx,ny;
		while(!q.isEmpty()) {
			p = q.poll();
			for(int d = 0; d < 8; d++) {
				nx = p.x + dx[d];
				ny = p.y + dy[d];
				if(nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
				if(visit[nx][ny]) continue;
				visit[nx][ny] = true;
				if(map[nx][ny] == 0) q.offer(new Point(nx,ny));
			}
		}
	}

}
