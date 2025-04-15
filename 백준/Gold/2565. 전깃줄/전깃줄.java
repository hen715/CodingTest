import java.io.*;
import java.util.Arrays;

class Main {


    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] list = new int[n+1][2];
        for(int i = 1 ; i <= n ; i++){
            String[] s = br.readLine().split(" ");
            list[i][0] = Integer.parseInt(s[0]);
            list[i][1] = Integer.parseInt(s[1]);
        }
        Arrays.sort(list,(o1, o2) -> o1[0]-o2[0]);
        int[] dp = new int[n+1];
        for(int i =1 ; i < n ; i++){
            dp[i] = 1;
        }
        for(int i = 1 ; i <= n ; i++){
            for(int j  = 1 ; j < i ; j++){
                if(list[i][1] > list[j][1]){
                    if(dp[j] >=dp[i]){
                        dp[i] = dp[j] + 1;
                    }
                }
            }
        }
        int max = 1;
        for(int i : dp){
            if(i > max){
                max = i;
            }
        }
        System.out.print(n - max);


    }

}