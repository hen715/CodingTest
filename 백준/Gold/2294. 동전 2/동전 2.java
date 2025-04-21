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
        for(int i = 0 ; i < k+1 ; i++){
            dp[i] = 100000;
        }
        for(int i= 1 ; i < k + 1 ; i++){
            for(int j = 0 ; j < n ; j++){
                if(coin[j]==i){
                    dp[i] = 1;
                }
                else if(coin[j]<i){
                    dp[i] = Math.min(dp[i-coin[j]]+1,dp[i]);
                }
            }
        }
        if(dp[k]==100000){
            System.out.print(-1);
        }
        else{
            System.out.print(dp[k]);
        }
    }
}