import java.io.*;
import java.util.*;

public class Main {
	final static int PUYO = 4;
	final static int[] dx = {0, 1, 0, -1};
	final static int[] dy = {-1, 0, 1, 0};
	
	static char[][] arr;
	static boolean[][] v;
	static int ans;
	static final int W = 6, H = 12;

	static void board(char[][] arr) {
		for (char[] ia : arr) {
	        System.out.println(Arrays.toString(ia));
	    }
		System.out.println();
	}
	
	static void fall() {
		int p;
		for (int i = H-2; i >= 0; i--) {
			for (int j = 0; j < W; j++) {
				p = i;
				while (p>=0 && p<=H-2 && arr[p][j] != '.' && arr[p+1][j] == '.') {
					arr[p+1][j] = arr[p][j];
					arr[p][j] = '.';
					p++;
				}
			}
		}
	}
	
	static int boom() {
		v = new boolean[H][W];
		boolean isBoom = false;
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if (v[i][j]) continue;
				if (arr[i][j] == '.') continue;
				ArrayDeque<int[]> q = new ArrayDeque<>();
				ArrayList<int[]> l = new ArrayList<>();
				q.offer(new int[] {i, j});
				l.add(new int[] {i, j});
				v[i][j] = true;
				while (!q.isEmpty()) {
					int[] a = q.poll();
					int ti = a[0], tj = a[1];
					for (int k = 0; k < 4; k++) {
						int ni = ti + dx[k], nj = tj + dy[k];
						if (0<=ni && ni < H && 0<=nj && nj<W && arr[ti][tj] == arr[ni][nj] && !v[ni][nj]) {
							q.offer(new int[] {ni, nj});
							l.add(new int[] {ni, nj});
							v[ni][nj] = true;
						}
					}
				}
				if (l.size() >= PUYO) {
					for (int[] ks : l) {
						arr[ks[0]][ks[1]] = '.';
					}
					isBoom = true;
				}
			}
		}
		if (isBoom) return 1;
		return 0;
	}

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str;
		arr = new char[H][W];
		v = new boolean[H][W];
		
		for (int i = 0; i < H; i++) {
			str = br.readLine();
			for (int j = 0; j < W; j++) {
				arr[i][j] = str.charAt(j);
			}
		}
		while (true) {
			int chain = boom();
			if (chain == 0) break;
			fall();
			ans += chain;
			
		}
		System.out.println(ans);
	}
}
