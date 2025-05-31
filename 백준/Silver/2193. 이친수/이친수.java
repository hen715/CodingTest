import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] dp = new long[90];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2 ; i < 90 ; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        System.out.print(dp[N-1]);
    }
}