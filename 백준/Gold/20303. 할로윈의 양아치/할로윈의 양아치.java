import java.io.*;
class Main
{
	public static int[] parent;
	public static void main(String args[]) throws Exception	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);
		int K = Integer.parseInt(s[2]);
		int[] list = new int[N+1];
		s = br.readLine().split(" ");
		for(int i = 1 ; i < N + 1; i++) {
			list[i] = Integer.parseInt(s[i-1]);
		}
		parent = new int[N+1];
		for(int i = 1 ; i < N + 1 ; i++) {
			parent[i] = i;
		}
		for(int i = 0 ; i < M ; i++) {
			s = br.readLine().split(" ");
			setParent(Integer.parseInt(s[0]),Integer.parseInt(s[1]));
		}
		int[][] result = new int[N + 1][2];
		for(int i = 1 ; i < N + 1 ; i++) {
			int p = getParent(i);
			result[p][0]++;
			result[p][1] += list[i];
		}
		int[][]dp = new int[N+1][K];
		for(int i = 1 ; i < N + 1 ; i++) {
			for(int j = 0 ; j < K ; j++) {
				if(result[i][0]>j) {
					dp[i][j] = dp[i-1][j];
				}
				else {
					dp[i][j] = Math.max(dp[i-1][j], result[i][1] + dp[i-1][j - result[i][0]]);
				}
			
			}
		}
		System.out.print(dp[N][K-1]);
	}
	
	public static void setParent(int a, int b) {
		int p1 = getParent(a);
		int p2 = getParent(b);
		if(p1>p2) {
			parent[p1] = p2; 
		}
		else {
			parent[p2] = p1; 
		}
	}
	
	public static int getParent(int num) {
		if(parent[num]==num) {
			return num;
		}
		return parent[num] = getParent(parent[num]);
	}
}