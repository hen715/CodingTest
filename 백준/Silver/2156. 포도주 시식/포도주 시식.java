import java.io.*;


class Main {

    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       int N = Integer.parseInt(br.readLine());
       int[] list = new int[N];
       for(int i = 0 ; i < N ;i++){
           list[i] = Integer.parseInt(br.readLine());
       }
       int[] dp = new int[N];
       dp[0] = list[0];
       if(N>1){
           dp[1] = dp[0] + list[1];
       }
       if(N>2){
           dp[2] = Math.max(list[0]+list[2],Math.max(list[1] + list[2],list[0]+list[1]));
       }
       if(N>3) {
           for (int i = 3; i < N; i++) {
               dp[i] = Math.max(list[i] + list[i-1] + dp[i-3],Math.max(list[i] + dp[i-2],dp[i-1]));
           }
       }
       int max  = dp[0];
       for(int i = 0 ; i < N ; i++){
           max = Math.max(max,dp[i]);
       }
       System.out.print(max);
    }
}