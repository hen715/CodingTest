import java.io.*;



class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);
        int[][] list = new int[N+1][M+1];
        for(int i = 1 ; i < N + 1; i++){
            s = br.readLine().split(" ");
            for(int j = 1 ; j < M +1 ; j++){
                list[i][j] = Integer.parseInt(s[j-1]);
            }
        }
        int[][] dp = new int[N+1][M+1];
        for(int i = 1 ; i < N + 1 ; i++){
            for(int j = 1 ; j < M + 1 ; j++){
                int max = Math.max(dp[i-1][j],dp[i][j-1]);
                max = Math.max(max,dp[i-1][j-1]);
                dp[i][j] = max + list[i][j];
            }
        }
        System.out.print(dp[N][M]);

    }

}