import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    static int N;
    static int[][] list;
    static long min;
    static long totalX, totalY;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            list = new int[N][2];
            min = Long.MAX_VALUE;
            totalX = 0;
            totalY = 0;

            for (int i = 0; i < N; i++) {
                String[] s = br.readLine().split(" ");
                list[i][0] = Integer.parseInt(s[0]);
                list[i][1] = Integer.parseInt(s[1]);
                totalX += list[i][0];
                totalY += list[i][1];
            }

            dfs(0, 0, 0,  0);
            sb.append('#').append(t).append(' ').append(min);
            if (t != T) sb.append('\n');
        }

        System.out.print(sb);
    }

    public static void dfs(int idx, int cnt, long selX, long selY) {
        if (cnt == N / 2) {
            long x = totalX - 2 * selX;
            long y = totalY - 2 * selY;
            min = Math.min(min, x * x + y * y);
            return;
        }
        if (idx == N) return;
        dfs(idx + 1, cnt + 1, selX + list[idx][0], selY + list[idx][1]);
        dfs(idx + 1, cnt, selX, selY);
    }
}