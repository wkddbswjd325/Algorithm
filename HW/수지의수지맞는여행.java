package AlgorithmHw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 수지의수지맞는여행 {
	static int r,c;
	static char[][] city;
	static int[] dx = {-1,0,0,1};
	static int[] dy = {0,-1,1,0};
	static int max = 0;
	static boolean[] alpha;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			city = new char[r+1][c+1];
			String s;
			for (int i = 1; i <= r; i++) {
				s = br.readLine();
				for(int j = 1; j <= c; j++) {
					city[i][j] = s.charAt(j-1);
				}
			}
			alpha = new boolean['Z'-'A'];
			travel(1,1,1);
			System.out.println("#"+t+" "+max);
			max = 0;
		}
	}
	public static void travel(int x, int y, int cnt) {
		
		alpha[city[x][y]-'A'] = true;
		for(int d = 0; d < 4; d++) {
			if(x+dx[d] <= 0 || x+dx[d]>r || y+dy[d] <= 0 || y+dy[d]>c) continue;
			if(alpha[city[x+dx[d]][y+dy[d]] -'A']) continue;
			travel(x+dx[d], y+dy[d], cnt+1);
		}
		alpha[city[x][y]-'A'] = false;
		if(max < cnt) max = cnt;
		
	}
}
