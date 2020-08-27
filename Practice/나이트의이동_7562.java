import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 나이트의이동_7562 {
	static class Point {
		int x;
		int y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static int[] dx = {-2,-2,-1,-1,1,1,2,2};
	static int[] dy = {-1,1,-2,2,-2,2,-1,1};
	static boolean[][] map;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		int x, y;
		for(int t = 1; t <= T; t++) {
			int l = Integer.parseInt(br.readLine());
			map = new boolean[l][l];
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			Point start = new Point(x, y);
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			Point dest = new Point(x, y);
		
			System.out.println(getMoveCount(start, dest));
			
		}
		
	}

	private static int getMoveCount(Point start, Point dest) {
		int count = 0;
		
		Queue<Point> q = new LinkedList<Point>();
		map[start.x][start.y] = true;
		q.offer(start);
		Point p;
		int nx, ny, len;
		
		while(!q.isEmpty()) {
			len = q.size();
			for(int i = 0; i < len; i++) {
				p = q.poll();
				if(p.x == dest.x && p.y == dest.y) return count;
				
				for(int d = 0; d < 8; d++) {
					nx = p.x + dx[d];
					ny = p.y + dy[d];
					
					if(nx < 0 || ny < 0 || nx >= map.length || ny >= map.length) continue;
					if(map[nx][ny]) continue;
					
					q.offer(new Point(nx, ny));
					map[nx][ny] = true;
				}
				
			}
			count++;
		}
		
		
		return count;
	}

}
