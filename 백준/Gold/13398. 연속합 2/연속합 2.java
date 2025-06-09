import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");
        int[] list = new int[n];
        for(int i = 0 ; i < n ; i++){
            list[i] = Integer.parseInt(s[i]);
        }
        int[][] dp = new int[2][n];
        dp[0][0] = list[0];
        dp[1][0] = list[0];
        int max = list[0];
        for(int i = 1 ; i < n ; i++){
            dp[0][i] = Math.max(dp[0][i-1] + list[i], list[i]);
            dp[1][i] = Math.max(dp[0][i-1], dp[1][i-1] + list[i]);
            max = Math.max(max,Math.max(dp[0][i], dp[1][i]));
        }

        System.out.print(max);
    }

}