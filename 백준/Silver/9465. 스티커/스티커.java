import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < T ; i++){
            int n = Integer.parseInt(br.readLine());
            int[][] sticker = new int[2][n];
            for(int a = 0 ; a < 2 ; a++){
                String[] s = br.readLine().split(" ");
                for(int b = 0 ; b < n ; b++){
                    sticker[a][b] = Integer.parseInt(s[b]);
                }
            }
            if(n==1){
                sb.append(Math.max(sticker[0][0],sticker[1][0])).append("\n");
            }else{
                int[][] dp = new int[2][n];
                dp[0][0] = sticker[0][0];
                dp[1][0] = sticker[1][0];
                dp[1][1] = sticker[1][1] + dp[0][0];
                dp[0][1] = sticker[0][1] + dp[1][0];
                for(int a = 2 ; a < n ; a++){
                    int max = Math.max(dp[0][a-2],dp[1][a-1]);
                    max = Math.max(max,dp[1][a-2]);
                    dp[0][a] = max + sticker[0][a];
                    max = Math.max(dp[0][a-1],dp[1][a-2]);
                    max = Math.max(max,dp[0][a-2]);
                    dp[1][a] = max + sticker[1][a];
                }
                int max = Math.max(Math.max(dp[0][n-1],dp[0][n-2]),Math.max(dp[1][n-1],dp[1][n-2]));
                sb.append(max).append("\n");
            }
        }
        System.out.println(sb);
    }
}