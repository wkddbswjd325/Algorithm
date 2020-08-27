import java.io.*;
import java.util.*;
public class »ó¹üºôµù_6593 {
	static class Point {
		int x;
		int y;
		int z;
		public Point(int x, int y, int z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}
	static int[] dx = {-1,1,0,0,0,0};
	static int[] dy = {0,0,-1,1,0,0};
	static int[] dz = {0,0,0,0,-1,1};
	static char[][][] map;
	static int l,r,c;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		Point start = null;
		String s;
		while(true) {
			st = new StringTokenizer(br.readLine());
			l = Integer.parseInt(st.nextToken());
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			if(l == 0 && r == 0 && c == 0) break;
			
			map = new char[l][r][c];
			
			for(int i = 0; i < l; i++) {
				for(int j = 0; j < r; j++) {
					s = br.readLine();
					for(int k = 0; k < c; k++) {
						map[i][j][k] = s.charAt(k);
						if(map[i][j][k] == 'S') 
							start = new Point(i,j,k);
					}
				}
				br.readLine();
			}
			int time = escape(start);
			if(time == -1) System.out.println("Trapped!");
			else System.out.println("Escaped in "+time+" minute(s).");
			
		}
		
	}
	private static int escape(Point start) {
		Queue<Point> q = new LinkedList<>();
		int time = 0;
		q.offer(start);
		Point p;
		int len, nx, ny, nz;
		while(!q.isEmpty()) {
			len =  q.size();
			for(int i = 0; i < len; i++) {
				p = q.poll();
				
				for(int d = 0; d < 6; d++) {
					nx = p.x+dx[d];
					ny = p.y+dy[d];
					nz = p.z+dz[d];
					
					if(nx < 0 || ny < 0 || nz < 0 || nx >= l || ny >= r || nz >= c) continue;
					if(map[nx][ny][nz] == '#') continue;
					if(map[nx][ny][nz] == 'E') return time+1;
					
					q.offer(new Point(nx,ny,nz));
					map[nx][ny][nz] = '#';
				}
			}
			time++;
		}
		
		return -1;
	}

}
