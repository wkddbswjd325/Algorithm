package AlgorithmHw;

import java.io.*;
import java.util.*;

public class 스타일리쉬들여쓰기 {
	static class Line {
		int indent;
		int rcnt;
		int ccnt;
		int scnt;
		public Line(int indent) {
			this.indent = indent;
		}
	}
	static int p,q;
	static List<Line> master = new ArrayList<>();
	static List<Line> me = new ArrayList<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		List<int[]> rcsList = new ArrayList<>();
		Line line;
		for(int tc = 1; tc <= t; tc++) {
			st = new StringTokenizer(br.readLine());
			p = Integer.parseInt(st.nextToken());
			q = Integer.parseInt(st.nextToken());
			
			master.clear();
			me.clear();
			for(int i = 0; i < p; i++) {
				line = makeLine(br.readLine());
				if(i!=0) {
					line.rcnt += master.get(i-1).rcnt;
					line.ccnt += master.get(i-1).ccnt;
					line.scnt += master.get(i-1).scnt;
				}
				master.add(line);
			}
			for(int i = 0; i < q; i++) {
				line = makeLine(br.readLine().trim());
				if(i!=0) {
					line.rcnt += me.get(i-1).rcnt;
					line.ccnt += me.get(i-1).ccnt;
					line.scnt += me.get(i-1).scnt;
				}
				me.add(line);
			}
			rcsList = findRCS();
			calcIndent(rcsList);
			sb.append("#").append(tc);
			for(Line l : me) sb.append(" ").append(l.indent); 
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	public static void calcIndent(List<int[]> rcsList) {
		int tmp;
		for(int i = 1; i < me.size(); i++) {
			for(int j = 0; j < rcsList.size(); j++) {
				tmp = rcsList.get(j)[0]*me.get(i-1).rcnt;
				tmp += rcsList.get(j)[1]*me.get(i-1).ccnt;
				tmp += rcsList.get(j)[2]*me.get(i-1).scnt;
				
				if(j != 0 && me.get(i).indent != tmp) {
					me.get(i).indent = -1;
					break;
				}
				
				me.get(i).indent = tmp;
			}
		}
	}
	public static List<int[]> findRCS() {
		List<int[]> rcsList = new ArrayList<>();
		for(int r = 1; r <= 20; r++) {
			for(int c = 1; c <= 20; c++) {
				loop:for(int s = 1; s <= 20; s++) {
					for(int i = 1; i < master.size(); i++) {
						if(r*master.get(i-1).rcnt+c*master.get(i-1).ccnt+
								s*master.get(i-1).scnt != master.get(i).indent) continue loop;
					}
					
					rcsList.add(new int[] {r,c,s});
				}
			}
		}
		return rcsList;
	}
	public static Line makeLine(String s) {
		int cnt = 0;
		while(s.charAt(cnt) == '.') {
			cnt++;
		}
		Line l = new Line(cnt);
		for(int j = cnt; j < s.length(); j++) {
			switch(s.charAt(j)) {
			case '(': 
				l.rcnt++;
				break;
			case ')':
				l.rcnt--;
				break;
			case '{':
				l.ccnt++;
				break;
			case '}':
				l.ccnt--;
				break;
			case '[':
				l.scnt++;
				break;
			case ']':
				l.scnt--;
				break;
			}
		}
		
		return l;
	}
}
