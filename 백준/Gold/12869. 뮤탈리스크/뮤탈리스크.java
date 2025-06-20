import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



public class Main {
    static int count;
    static int[][][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] list = new int[3];
        String[] s = br.readLine().split(" ");
        for(int i = 0 ; i < N ; i++){
            list[i] = Integer.parseInt(s[i]);
        }
        dp = new int[61][61][61];
        count = Integer.MAX_VALUE;
        search(list[0], list[1], list[2], 0);
        System.out.print(count);
    }



    public static void search(int a, int b, int c, int cnt){
        if(a<=0&&b<=0&&c<=0){
            if(cnt<count){
                count = cnt;
            }
            return;
        }
        a = Math.max(a, 0);
        b = Math.max(b, 0);
        c = Math.max(c, 0);
        if(dp[a][b][c]<=cnt && dp[a][b][c] != 0){
            return;
        }
        dp[a][b][c] = cnt;
        search(a - 9, b - 3, c - 1, cnt + 1);
        search(a - 9, b - 1, c - 3, cnt + 1);
        search(a - 3, b - 9, c - 1, cnt + 1);
        search(a - 1, b - 9, c - 3, cnt + 1);
        search(a - 1, b - 3, c - 9, cnt + 1);
        search(a - 3, b - 1, c - 9, cnt + 1);
    }
}