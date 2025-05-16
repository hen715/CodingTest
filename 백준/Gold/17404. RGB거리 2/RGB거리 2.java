import java.io.*;


class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] list = new int[N][3];
        String[] s;
        for(int i = 0 ; i < N ;i++){
            s = br.readLine().split(" ");
            list[i][0] =  Integer.parseInt(s[0]);
            list[i][1] =  Integer.parseInt(s[1]);
            list[i][2] =  Integer.parseInt(s[2]);
        }

        int[][] dp = new int[N][3];
        int min = Integer.MAX_VALUE;
        for(int a = 0 ; a < 3 ; a++){
            if(a==0){
                dp[0][0] = list[0][0];
                dp[0][1] = 10000000;
                dp[0][2] = 10000000;
            }
            else if(a==1){
                dp[0][0] = 10000000;
                dp[0][1] = list[0][1];
                dp[0][2] = 10000000;
            }
            else {
                dp[0][0] = 10000000;
                dp[0][1] = 10000000;
                dp[0][2] = list[0][2];
            }

            for(int i = 1 ; i < N ; i++){
                dp[i][0] = list[i][0] + Math.min(dp[i-1][1],dp[i-1][2]);
                dp[i][1] = list[i][1] + Math.min(dp[i-1][0],dp[i-1][2]);
                dp[i][2] = list[i][2] +  Math.min(dp[i-1][0],dp[i-1][1]);
            }
            if(a==0){
                min = Math.min(min,dp[N-1][1]);
                min = Math.min(min,dp[N-1][2]);
            }
            else if(a==1){
                min = Math.min(min,dp[N-1][0]);
                min = Math.min(min,dp[N-1][2]);
            }
            else {
                min = Math.min(min,dp[N-1][0]);
                min = Math.min(min,dp[N-1][1]);
            }
        }
        System.out.print(min);
    }
}