import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] triangle = new int[n][n];
        for(int i = 0 ; i < n ; i++){
            String[] s = br.readLine().split(" ");
            for(int j = 0 ; j < i+1; j++){
                triangle[i][j] = Integer.parseInt(s[j]);
            }
        }
        int[][] dp = new int[n][n];
        dp[0][0] = triangle[0][0];
        for(int i = 1 ; i < n ; i++){
            for(int j = 0 ; j < i+1; j++){
                if(j==0){
                    dp[i][j] = dp[i-1][j] + triangle[i][j];
                }
                else if(j == i){
                    dp[i][j] = dp[i-1][j-1] + triangle[i][j];
                }
                else{
                    dp[i][j] = dp[i-1][j-1] > dp[i-1][j] ? dp[i-1][j-1] + triangle[i][j] : dp[i-1][j] + triangle[i][j];
                }
            }
        }
        int max = 0;
        for(int i = 0 ; i < n ; i++){
            max = Math.max(max,dp[n-1][i]);
        }
        System.out.println(max);
    }
}