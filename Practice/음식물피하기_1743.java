import java.io.*;
import java.util.*;

public class 음식물피하기_1743 {
	static class Point {
		int x;
		int y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,-1,0,1};
	static int n,m;
	static int[][] map;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		map = new int[n+1][m+1];
		int x, y;
		for(int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			map[x][y] = 2;
		}
		System.out.println(getMaxTrash());
	}
	private static int getMaxTrash() {
		int max = 0;
		
		Queue<Point> q = new LinkedList<>();
		Point p;
		int nx,ny;
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= m; j++) {
				if(map[i][j] != 2) continue;
				
				q.offer(new Point(i,j));
				map[i][j] = 1;
				int cnt = 1;
				
				while(!q.isEmpty()) {
					p = q.poll();
					
					for(int d = 0; d < 4; d++) {
						nx = p.x + dx[d];
						ny = p.y + dy[d];
						if(nx <= 0 || ny <= 0 || nx > n || ny > m || map[nx][ny] != 2) continue;
						q.offer(new Point(nx,ny));
						map[nx][ny] = 1;
						cnt++;
					}
					
				}
				
				max = (max < cnt)? cnt : max; 
			}
		}
		return max;
	}
}
