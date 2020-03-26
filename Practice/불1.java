package AlgorithmPractice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
public class 불1 {
	static class Point {
		int x; int y;
		int time;
		public Point(int x, int y) {
			this.x = x; this.y = y;
		}
	}
	static int h,w;
	static char[][] map;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,-1,0,1};
	static Queue<Point> fire = new LinkedList<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringTokenizer st;
		String s;
		int x = 0,y = 0;
		for(int tc = 1; tc <= t; tc++) {
			st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			
			map = new char[h][w];
			fire.clear();
			for(int i = 0; i < h; i++) {
				s = br.readLine();
				for(int j = 0; j < w; j++) {
					map[i][j] = s.charAt(j);
					if(map[i][j] == '@') {
						x = i;
						y = j;
						map[i][j] = '.';
					}
					if(map[i][j] == '*') 
						fire.offer(new Point(i,j));
					
				}
			}
			
			int answer = move(x,y);
			if(answer == -1) System.out.println("IMPOSSIBLE");
			else System.out.println(answer);
		}
	}
	public static int move(int x, int y) {
		boolean[][] visit = new boolean[h][w];
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(x,y));
		visit[x][y] = true;
		Point p, tmp;
		int nx,ny,len;
		while(!q.isEmpty()) {
			
			len = q.size();
			for(int i = 0; i < len; i++) {
				p = q.poll();
				if(map[p.x][p.y] == '*') continue;
				
				for(int d = 0; d < 4; d++) {
					nx = p.x+dx[d];
					ny = p.y+dy[d];

					if(nx < 0 || nx >= h || ny < 0 || ny >= w) return p.time+1;
					if(map[nx][ny] == '#' || map[nx][ny] == '*' || visit[nx][ny]) continue;
					tmp = new Point(nx,ny);
					tmp.time = p.time+1;
					q.offer(tmp);
					visit[nx][ny] = true;
				}
			}
			
			len = fire.size();
			for(int i = 0; i < len; i++) {
				p = fire.poll();
				
				for(int d = 0; d < 4; d++) {
					nx = p.x+dx[d];
					ny = p.y+dy[d];
					
					if(nx < 0 || nx >= h || ny < 0 || ny >= w) continue;
					if(map[nx][ny] != '.') continue;
					map[nx][ny] = '*';
					fire.offer(new Point(nx,ny));
				}
			}
			
		}
		
		return -1;
	}

}
