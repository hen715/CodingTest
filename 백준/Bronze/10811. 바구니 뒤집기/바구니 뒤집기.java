import java.io.*;
import java.util.*;
public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);
		int[] list = new int[N + 1];
		for(int i = 1 ; i <= N ; i++) {
			list[i] = i;
		}
		for(int i = 0 ; i < M ; i++) {
			s = br.readLine().split(" ");
			int a = Integer.parseInt(s[0]);
			int b = Integer.parseInt(s[1]);
			int[] temp = new int[b-a+1];
			int point = 0;
			for(int j = a ; j <= b  ; j++ ) {
				temp[point++] = list[j];
			}
			point = 0;
			for(int j = b ; j >= a ; j--) {
				list[j] = temp[point++];
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 1 ; i < N+1 ; i++) {
			sb.append(list[i]).append(' ');
		}
		System.out.print(sb);
		
	}


}