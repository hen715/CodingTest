import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] list = new int[N+1];
        String[] s = br.readLine().split(" ");
        for(int i = 1 ; i < N + 1 ; i++){
            list[i] = Integer.parseInt(s[i-1]);
        }
        int[] dp = new int[N+1];
        for(int i = 1 ; i < N +1 ; i++){
            for(int j = 1 ; j < N + 1; j++){
                if(j<=i){
                    dp[i] = Math.max(dp[i],dp[i-j] + list[j]);
                }
            }
        }
        System.out.print(dp[N]);
    }
}