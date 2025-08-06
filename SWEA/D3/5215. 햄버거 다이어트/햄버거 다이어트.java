import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("res/input_d3_5215.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int t = 1 ; t <= T ; t++) {
            String[] s  = br.readLine().split(" ");
            int N = Integer.parseInt(s[0]);
            int L = Integer.parseInt(s[1]);
            int[][] list = new int[N + 1][2];
            for(int i = 1 ; i < N + 1 ; i++){
                s  = br.readLine().split(" ");
                list[i][0] = Integer.parseInt(s[0]);
                list[i][1] = Integer.parseInt(s[1]);
            }
            int[][] dp = new int [N+1][L+1];
            for(int i = 1 ; i < N + 1 ; i++){
                for(int j = 1 ; j < L+1 ; j++){
                    if(j<list[i][1]){
                        dp[i][j] = dp[i-1][j];
                    }
                    else{
                        dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-list[i][1]] + list[i][0]);
                    }
                }
            }

            sb.append('#').append(t).append(' ').append(dp[N][L]);
            if(t!=T) {
                sb.append('\n');
            }
        }
        System.out.print(sb);

    }

}