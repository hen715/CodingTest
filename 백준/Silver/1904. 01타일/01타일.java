import java.io.*;


class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        if(N==1){
            System.out.print(1);
            return;
        }
        if(N==2){
            System.out.print(2);
            return;
        }
        long[] dp = new long[N];
        dp[0] = 1;
        dp[1] = 2;
        for(int i = 2; i < N; i++){
            dp[i] = (dp[i-1] + dp[i-2]) %15746;
        }
        System.out.print(dp[N-1] % 15746);
    }
}