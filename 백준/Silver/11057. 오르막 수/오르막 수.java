import java.io.*;

class Main {



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[n + 1][10];
        for(int i = 0 ; i < 10 ; i++){
            dp[1][i] = 1;
        }
        for(int i = 2 ; i < n + 1 ; i++){
            for(int j = 0 ; j < 10 ; j++){
                for(int k = 0 ; k <= j; k++ ){
                    dp[i][j] += dp[i-1][k] %10007;
                }
            }
        }
        int count = 0;
        for(int i = 0 ; i <10 ; i++){
            count += dp[n][i]%10007;
        }
        System.out.print(count%10007);
    }

}