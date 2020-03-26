package AlgorithmHw;
import java.io.*;
import java.util.*;
public class 벽돌깨기2 {
	static class Point {
		int x; int y;
		int value;
		public Point(int x, int y) {
			this.x = x; this.y = y;
		}
	}
	static int n,w,h;
	static int[][] matrix;
	static int min;
	static int brick;
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for(int tc = 1; tc <= t; tc++) {
			brick = 0;
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			matrix = new int[h][w];
			for(int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < w; j++) {
					matrix[i][j] = Integer.parseInt(st.nextToken());
					if(matrix[i][j] > 0) brick++;
				}
			}
			min = brick;
			dfs(matrix,0, brick);
			sb.append("#").append(tc).append(" ").append(min).append("\n");
		}
		System.out.println(sb.toString());
	}
	public static void dfs(int[][] array, int cnt, int bb) {
		if(cnt == n) {
			if(bb < min)
				min = bb;
			return;
		}
		
		for(int i = 0 ; i < w; i++) {
			int[][] copy = new int[h][w];
			for(int a=0; a<h; a++){
	            copy[a] = array[a].clone();
	        }
			int disa = game(copy, i);
			dfs(copy, cnt+1, bb-disa);
		}
	}
	public static int game(int[][] array ,int idx) {
		int result = 0;
		Queue<Point> q = new LinkedList<>();
		Point p;
		Point tmp;
		int nx,ny,dist;
		for(int i = 0; i < h; i++) {
			if(array[i][idx] != 0) {
				tmp = new Point(i,idx);
				tmp.value = array[i][idx];
				q.offer(tmp);
				array[i][idx] = 0;
				break;
			}
		}
		//벽돌깨기
		while(!q.isEmpty()) {
			p = q.poll();
			dist = p.value;
			result++;
			for(int k = 1; k < dist; k++) {
				for(int d = 0; d < 4; d++) {
					nx = p.x+dx[d]*k;
					ny = p.y+dy[d]*k;
					if(nx < 0 || nx >= h || ny < 0 || ny >= w) continue;
					if(array[nx][ny] == 0) continue;
					tmp = new Point(nx,ny);
					tmp.value = array[nx][ny];
					q.offer(tmp);
					array[nx][ny] = 0;
					
				}
			}
		}
		//밑으로 당기기
		for(int j = 0; j < w; j++) {
			loop:for(int i = h-1; i > 0; i--) {
				if(array[i][j] == 0) {
					for(int k = i-1; k >= 0; k--) {
						if(array[k][j] != 0) {
							array[i][j] = array[k][j];
							array[k][j] = 0;
							if(k == 0) continue loop;
							break;
						}
					}
				}
			}
		}
		
		return result;
	}
}
