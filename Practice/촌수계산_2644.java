import java.util.*;
import java.io.*;
public class ÃÌ¼ö°è»ê_2644 {
	static final int INF = 987654321;
	static List<Integer>[] family;
	static boolean[] checked;
	static int relationship = INF;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		family = new LinkedList[n+1];
		for(int i = 1; i <= n; i++)
			family[i] = new LinkedList<Integer>();
		
		st = new StringTokenizer(br.readLine());
		int p1 = Integer.parseInt(st.nextToken());
		int p2 = Integer.parseInt(st.nextToken());
		
		int m = Integer.parseInt(br.readLine());
		int x, y;
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			family[x].add(y);
			family[y].add(x);
		}
		
		checked = new boolean[n+1];
		getRelationship(p1, p2, 0);
		
		relationship = (relationship == INF) ? -1 : relationship;
		System.out.println(relationship);
	}
	private static void getRelationship(int p1, int p2, int count) {
		if(relationship <= count) return;
		
		if(p1==p2) {
			relationship = count;
			return;
		}
		
		checked[p1] = true;
		for(int person : family[p1]) {
			if(checked[person]) continue;
			getRelationship(person, p2, count+1);
		}
		checked[p1] = false;
		
	}
}
