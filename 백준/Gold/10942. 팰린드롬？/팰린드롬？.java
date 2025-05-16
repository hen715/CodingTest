import java.io.*;


class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int[] list = new int[N];
        String[] s = br.readLine().split(" ");
        for(int i = 0 ; i < N ; i++){
            list[i] = Integer.parseInt(s[i]);
        }
        int[][] dp = new int[N][N];
        for(int i = 0 ; i < N ; i++){
            dp[i][i] = 1;
        }
        for(int i = 1 ; i < N  ; i++){
            int start = 0;
            int end = i;
            while (end < N){
                if (list[start] != list[end]) {
                    dp[start][end] = 0;
                }
                else{
                    if(end - start ==1){
                        dp[start][end] = 1;
                    }
                    else if(dp[start+1][end-1]==1){
                        dp[start][end] = 1;
                    }
                }
                start++;
                end++;
            }
        }
        int M = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < M ; i++){
            s = br.readLine().split(" ");
            int S = Integer.parseInt(s[0]) - 1;
            int E = Integer.parseInt(s[1]) - 1;
            sb.append(dp[S][E]).append('\n');
        }
        System.out.print(sb);
    }
}