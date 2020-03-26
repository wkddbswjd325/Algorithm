package AlgorithmHw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
public class 오나의여신님 {
	static class Point {
		int x; int y;
		int time;
		public Point(int x, int y) {
			this.x = x; this.y = y;
		}
	}
	static int n,m;
	static char[][] map;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,-1,0,1};
	static Queue<Point> devil = new LinkedList<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringTokenizer st;
		String s;
		int x = 0,y = 0;
		for(int tc = 1; tc <= t; tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			
			map = new char[n][m];
			devil.clear();
			for(int i = 0; i < n; i++) {
				s = br.readLine();
				for(int j = 0; j < m; j++) {
					map[i][j] = s.charAt(j);
					if(map[i][j] == 'S') {
						x = i;
						y = j;
						map[i][j] = '.';
					}
					if(map[i][j] == '*') 
						devil.offer(new Point(i,j));
					
				}
			}
			
			int answer = move(x,y);
			if(answer == -1) System.out.println("#"+tc+" GAME OVER");
			else System.out.println("#"+tc+" "+answer);
		}
	}
	public static int move(int x, int y) {
		boolean[][] visit = new boolean[n][m];
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(x,y));
		visit[x][y] = true;
		Point p, tmp;
		int nx,ny,len;
		while(!q.isEmpty()) {
			
			len = q.size();
			for(int i = 0; i < len; i++) {
				p = q.poll();
				if(map[p.x][p.y] == 'D') return p.time;
				if(map[p.x][p.y] == '*') continue;
				
				for(int d = 0; d < 4; d++) {
					nx = p.x+dx[d];
					ny = p.y+dy[d];
					
					if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
					if(map[nx][ny] == 'X' || map[nx][ny] == '*' || visit[nx][ny]) continue;
					tmp = new Point(nx,ny);
					tmp.time = p.time+1;
					q.offer(tmp);
					visit[nx][ny] = true;
				}
			}
			
			len = devil.size();
			for(int i = 0; i < len; i++) {
				p = devil.poll();
				
				for(int d = 0; d < 4; d++) {
					nx = p.x+dx[d];
					ny = p.y+dy[d];
					
					if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
					if(map[nx][ny] != '.') continue;
					map[nx][ny] = '*';
					devil.offer(new Point(nx,ny));
				}
			}
			
		}
		
		return -1;
	}

}
