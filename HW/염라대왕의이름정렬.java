package AlgorithmHw;

import java.io.*;
import java.util.*;

public class 염라대왕의이름정렬 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		int n;
		Set<String> s = new HashSet<>();
		List<String> l;
		for(int tc = 1; tc <= t; tc++) {
			n = Integer.parseInt(br.readLine());
			s.clear();
			for(int i = 0 ; i < n; i++) 
				s.add(br.readLine().trim());
			
			l = new ArrayList<>(s);
			Collections.sort(l, new Comparator<String>(){

				@Override
				public int compare(String s1, String s2) {
					if(s1.length() == s2.length()) 
						return s1.compareTo(s2);
					return Integer.compare(s1.length(), s2.length());
				}
				
			});
			
			sb.append("#").append(tc).append("\n");
			for(String str : l) sb.append(str).append("\n");
			
		}
		System.out.println(sb.toString());
	}

}
