import java.io.*;
import java.util.*;

public class Main {
	final static int[] di = { 0, 1, 0, -1, 0, 0 };
	final static int[] dj = { -1, 0, 1, 0, 0, 0 };
	final static int[] dk = { 0, 0, 0, 0, -1, 1 };
	static int M, N, H, unripedT;
	static ArrayDeque<int[]> q = new ArrayDeque<>();

	static void board(int[][][] arr) {
//		for (int[][] ia : arr) {
//			for (int[] ib : ia) {
//				System.out.println(Arrays.toString(ib));
//			}
//			System.out.println();
//		}
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < M; k++) {
					System.out.print(arr[j][k][i] + " ");
				}
				System.out.println();
			}
			System.out.println("----------");
		}
		System.out.println("=======");
	}

	static int getAmount(int[][][] arr) {
		int amnt = 0;
		for (int[][] ia : arr) {
			for (int[] ib : ia) {
				for (int val : ib) {
					if (val == 0)
						amnt++;
				}
			}
		}
		return amnt;
	}

	static void ripe(int m, int n, int h, int[][][] arr) {
		int ni, nj, nk;
		for (int i = 0; i < 6; i++) {
			ni = n + di[i];
			nj = m + dj[i];
			nk = h + dk[i];
			if (0 <= ni && N > ni && 0 <= nj && M > nj && 0 <= nk && H > nk && arr[ni][nj][nk] == 0) {
				arr[ni][nj][nk] = 1;
				//board(arr);
				unripedT--;
				q.add(new int[] { nj, ni, nk});
			}
		}
	}

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		int[][][] arr = new int[N][M][H];
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < M; k++) {
					arr[j][k][i] = Integer.parseInt(st.nextToken());
				}
			}
		}
		unripedT = getAmount(arr);
		if (unripedT == 0) {
			System.out.println(0);
			return;
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				for (int k = 0; k < H; k++) {
					if (arr[i][j][k] == 1) {
						q.add(new int[] { j, i, k });
					}
				}
			}
		}
		int ans = 0;
		while (!q.isEmpty()) {
			int n = q.size();
			for (int i = 0; i < n; i++) {
				int[] l = q.poll();
				ripe(l[0], l[1], l[2], arr);
			}
			ans++;
			//System.out.println("day" + ans);
		}
		if (getAmount(arr) > 0) {
			System.out.println(-1);
			return;
		}
		System.out.println(ans-1);
	}
}
