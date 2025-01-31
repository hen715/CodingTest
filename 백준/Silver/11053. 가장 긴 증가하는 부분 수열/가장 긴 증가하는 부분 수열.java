import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] list = new int[N];
        String[] s = br.readLine().split(" ");
        for(int i = 0 ; i < N ; i++){
            list[i] = Integer.parseInt(s[i]);
        }
        int[] dp = new int[N];
        dp[0] = 1;
        for(int i = 1 ; i < N ; i++){
            int max = dp[i];
            int index = i;
            for(int j = i - 1 ; j >= 0 ; j--){
                if(max<dp[j]&&list[j]<list[i]){
                    max = dp[j];
                    index = j;
                }
            }
            dp[i] = dp[index] +1;
        }
        int max = dp[0];
        for(int i = 0 ; i < N ; i++){
            if(max<dp[i]){
                max = dp[i];
            }
        }
        System.out.println(max);

    }
}
