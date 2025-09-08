import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int t = 1 ; t <= T ; t++) {
            String[] s = br.readLine().split(" ");
            int N = Integer.parseInt(s[0]);
            int K = Integer.parseInt(s[1]);
            int[][] list = new int[N+1][2];
            for(int i = 1 ; i <= N ; i++){
                s = br.readLine().split(" ");
                list[i][0] = Integer.parseInt(s[0]);
                list[i][1] = Integer.parseInt(s[1]);
            }
            int[][] dp = new int[N+1][K+1];

            for(int i = 1 ; i <= N ; i++){
                for(int j = 1; j <= K ; j++){
                    if(list[i][0]>j){
                        dp[i][j] = dp[i-1][j];
                    }
                    else{
                        dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-list[i][0]]+list[i][1]);
                    }
                }
            }
            sb.append('#').append(t).append(' ').append(dp[N][K]);
            if(t!=T) {
                sb.append('\n');
            }
        }
        System.out.print(sb);
    }



}