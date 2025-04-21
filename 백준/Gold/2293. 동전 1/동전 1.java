import java.io.*;


class Main {



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int k = Integer.parseInt(s[1]);
        int[] coin = new int[n];
        for(int i = 0 ; i < n ; i++){
            coin[i] = Integer.parseInt(br.readLine());
        }
        int[] dp = new int[k +1];
        dp[0] = 1;
        for(int i = 0 ; i <  n ;i++){
            for(int j = coin[i] ; j < k+1 ; j++){
                dp[j] += dp[j - coin[i]];
            }
        }
        System.out.print(dp[k]);
    }
}