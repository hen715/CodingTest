import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static class Node{
		int m;
		int b;
		int time;
		
		public Node(int m ,int b, int time) {
			this.m = m;
			this.b = b;
			this.time = time;
		}
	}
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int S = Integer.parseInt(br.readLine());
		boolean[] visit = new boolean[10000];
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(1,0,0));
		while(!q.isEmpty()) {
			Node now = q.poll();
			visit[now.m] = true;
			if(now.m == S) {
				System.out.print(now.time);
				break;
			}
			if(now.b!=0) {
				if(!visit[now.m+now.b]) {
					q.add(new Node(now.m+now.b,now.b,now.time+1));
				}
			}
			q.add(new Node(now.m, now.m, now.time+1));
			if(now.m>0&&!visit[now.m-1]) {
				q.add(new Node(now.m - 1, now.b, now.time+1));
			}
		}
		
	}

}