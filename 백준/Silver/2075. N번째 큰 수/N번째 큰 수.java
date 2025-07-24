import java.io.*;
import java.util.*;

public class Main {
	
	static void board(int[][] arr) {
		for (int[] ia : arr) System.out.println(Arrays.toString(ia));
	}

	public static void main(String[] args) throws Exception{
		//System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][N];
		String str;
		for (int i = 0; i < N; i++) {
			str = br.readLine();
			StringTokenizer st = new StringTokenizer(str, " ");
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int[] x: arr) {
			for (int val : x) {
				maxHeap.add(val);
			}
		}
		int result = -1;
		for (int i = 0; i < N; i++) {
			result = maxHeap.poll();
		}
		System.out.println(result);
	}
}
