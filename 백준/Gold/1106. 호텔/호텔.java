import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int C = Integer.parseInt(s[0]);
        int N = Integer.parseInt(s[1]);
        int[][] list = new int[N][2];
        for(int i = 0 ; i < N ; i++){
            s = br.readLine().split(" ");
            list[i][0] = Integer.parseInt(s[0]);
            list[i][1] = Integer.parseInt(s[1]);
        }
        int[] dp = new int[C + 101];
        for(int i = 1 ; i < C + 101 ; i++){
            dp[i] = 1000000000;
        }
        for(int i = 0 ; i < N ; i++){
            for(int j = list[i][1] ; j < C + 101 ; j++){
                dp[j] = Math.min(dp[j], dp[j - list[i][1]] + list[i][0]);
            }
        }
        int answer = Integer.MAX_VALUE;
        for(int i = C ; i < C+101 ; i++){
            answer = Math.min(answer,dp[i]);
        }
        System.out.print(answer);
    }

}