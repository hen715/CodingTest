import java.io.*;
import java.util.*;

public class Main {
    static final int INF = Integer.MAX_VALUE;
    static int[][][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> steps = new ArrayList<>();

        while (true) {
            int x = Integer.parseInt(st.nextToken());
            if (x == 0) break;
            steps.add(x);
        }

        int n = steps.size();
        dp = new int[n + 1][5][5];
        for (int[][] d1 : dp)
            for (int[] d2 : d1)
                Arrays.fill(d2, INF);

        dp[0][0][0] = 0;

        for (int i = 0; i < n; i++) {
            int next = steps.get(i);
            for (int l = 0; l < 5; l++) {
                for (int r = 0; r < 5; r++) {
                    if (dp[i][l][r] == INF) continue;
                    // 왼발 이동
                    if (next != r) {
                        int cost = moveCost(l, next);
                        dp[i + 1][next][r] = Math.min(dp[i + 1][next][r], dp[i][l][r] + cost);
                    }
                    // 오른발 이동
                    if (next != l) {
                        int cost = moveCost(r, next);
                        dp[i + 1][l][next] = Math.min(dp[i + 1][l][next], dp[i][l][r] + cost);
                    }
                }
            }
        }

        int answer = INF;
        for (int l = 0; l < 5; l++) {
            for (int r = 0; r < 5; r++) {
                answer = Math.min(answer, dp[n][l][r]);
            }
        }

        System.out.println(answer);
    }

    static int moveCost(int from, int to) {
        if (from == 0) return 2;
        if (from == to) return 1;
        if ((from == 1 && to == 3) || (from == 3 && to == 1) ||
            (from == 2 && to == 4) || (from == 4 && to == 2)) return 4;
        return 3;
    }
}
