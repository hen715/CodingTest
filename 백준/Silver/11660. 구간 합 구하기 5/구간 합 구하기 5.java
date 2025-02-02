import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);
        int[][] list = new int[N][N];
        for(int i = 0 ; i < N ; i++){
            s = br.readLine().split(" ");
            for(int j = 0 ; j < N ; j++){
                list[i][j] = Integer.parseInt(s[j]);
            }
        }
        int[][] dp = new int[N][N];
        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < N ; j++){
                if(j == 0){
                    dp[i][j] = list[i][j];
                }
                else{
                    dp[i][j] = dp[i][j-1] + list[i][j];
                }
            }
        }
        for(int i = 0 ; i < M ; i++){
            s = br.readLine().split(" ");
            int x1 = Integer.parseInt(s[0]) - 1;
            int y1 = Integer.parseInt(s[1]) - 1;
            int x2 = Integer.parseInt(s[2]) - 1;
            int y2 = Integer.parseInt(s[3]) - 1;

            int sum = 0;
            if(y1-1>=0){
                for(int a = x1 ; a <=x2 ; a++){
                    sum += dp[a][y2] - dp[a][y1-1];
                }
            }
            else{
                for(int a = x1 ; a <=x2 ; a++) {
                        sum += dp[a][y2];
                    }
            }
            sb.append(sum).append("\n");

        }
        System.out.print(sb);

    }
}