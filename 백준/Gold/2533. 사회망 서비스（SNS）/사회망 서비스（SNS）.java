import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static List<List<Integer>> list;
    static boolean[] visit;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        for(int i = 0 ; i <= N ; i++){
            list.add(new ArrayList<>());
        }
        String[] s;
        for(int i = 0 ; i < N - 1 ; i++){
            s = br.readLine().split(" ");
            list.get(Integer.parseInt(s[0])).add(Integer.parseInt(s[1]));
            list.get(Integer.parseInt(s[1])).add(Integer.parseInt(s[0]));
        }
        visit = new boolean[N+1];
        dp = new int[N+1][2];
        dfs(1);
        System.out.print(Math.min(dp[1][0], dp[1][1]));
    }
    public static void dfs(int num){
        visit[num] = true;
        dp[num][0] = 0;
        dp[num][1] = 1;
        for(int child :list.get(num)){
            if(!visit[child]) {
                dfs(child);
                dp[num][0] += dp[child][1];
                dp[num][1] += Math.min(dp[child][0], dp[child][1]);
            }
        }
    }
}