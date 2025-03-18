import java.io.*;


class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] list = new int[N];
        String[] s = br.readLine().split(" ");
        for(int i = 0 ; i < N ;i++){
            list[i] = Integer.parseInt(s[i]);
        }
        int[] dp = new int[N];
        dp[0] = list[0];
        int max = list[0];
        for(int i = 1 ; i < N ; i++){
            dp[i] = Math.max(dp[i-1] + list[i],list[i]);
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);

    }


}