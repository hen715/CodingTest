import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int t = 1 ; t <= T ; t++) {
            int N = Integer.parseInt(br.readLine());
            int sum = 0;
            int[][] list = new int[N][N];
            for(int i = 0 ; i < N ; i++){
                String str = br.readLine();
                for(int j = 0 ; j < N ; j++){
                    list[i][j] = str.charAt(j) - '0';
                }
            }
            for(int i = 0 ; i < N ; i++){
                if(i<=N/2) {
                    for (int j = N / 2 - i; j <= N / 2 + i; j++) {
                        sum += list[i][j];
                    }
                }
                else{
                    int n = N - i - 1;
                    for (int j = N / 2 - n; j <= N / 2 + n; j++) {
                        sum += list[i][j];
                    }
                }
            }


            sb.append('#').append(t).append(' ').append(sum);
            if(t!=T) {
                sb.append('\n');
            }
        }
        System.out.print(sb);
    }


}