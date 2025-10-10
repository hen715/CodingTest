import java.util.*;
import java.io.*;
public class Main {

    static int[][] list;
    static int[][] dp;
    static int min;
    static int N;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        list = new int[N][N];
        dp = new int[N][N];
        for(int i = 0 ; i < N ; i++){
            String s = br.readLine();
            for(int j = 0 ; j < N ; j++){
                list[i][j] = s.charAt(j)-'0';
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        min = Integer.MAX_VALUE;
        dfs(0,0,0);
        System.out.print(dp[N-1][N-1]);
    }
    static void dfs(int x, int y, int count){
        if(count>=dp[x][y]){
            return;
        }
        dp[x][y] = count;
        if(x==N-1&&y==N-1){
            return;
        }
        for(int i = 0 ; i < 4 ; i++){
            int ddx = x + dx[i];
            int ddy = y + dy[i];
            if(ddx>=0&&ddx<N&&ddy>=0&&ddy<N){
                if(list[ddx][ddy]==1){
                    dfs(ddx,ddy,count);
                }
                else {
                    dfs(ddx, ddy, count + 1);
                }
            }

        }

    }
}