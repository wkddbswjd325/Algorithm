import java.util.*;
import java.io.*;

public class 연결요소의개수_11724 {
	static int n;
	static List<Integer>[] list;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		list = new LinkedList[n+1];
		for(int i = 1; i <= n; i++)
			list[i] = new LinkedList<>();
		int u,v;
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			u = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());
			list[u].add(v);
			list[v].add(u);
		}
		System.out.println(getCount());
	}
	private static int getCount() {
		int cnt = 0;
		boolean[] visited = new boolean[n+1];
		Queue<Integer> q = new LinkedList<>();
		for(int i = 1; i <= n; i++) {
			if(visited[i]) continue;
			
			q.offer(i);
			visited[i] = true;
			
			while(!q.isEmpty()) {
				int n = q.poll();
				for(int nn : list[n]) {
					if(visited[nn]) continue;
					q.offer(nn);
					visited[nn] = true;
				}
			}
			cnt++;
		}
		
		return cnt;
	}

}
