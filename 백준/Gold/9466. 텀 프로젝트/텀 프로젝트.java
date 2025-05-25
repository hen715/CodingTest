import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static boolean[] visit;
    static boolean[] hasTeam;
    static int[] list;
    static int n;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        String[] s;
        for (int t = 0; t < T; t++) {
            n = Integer.parseInt(br.readLine());
            list = new int[n + 1];
            s = br.readLine().split(" ");
            for (int i = 1; i < n + 1; i++) {
                list[i] = Integer.parseInt(s[i - 1]);
            }
            visit = new boolean[n + 1];
            hasTeam = new boolean[n + 1];
            count = 0;
            for (int i = 1; i < n + 1; i++) {
                if (!visit[i]) {
                    search(i);
                }
            }
            sb.append(n - count);
            if (t != T - 1) {
                sb.append('\n');
            }
        }
        System.out.print(sb);
    }

    public static void search(int start) {
        int now = start;
        List<Integer> path = new ArrayList<>();
        while (!visit[now]) {
            visit[now] = true;
            path.add(now);
            now = list[now];
        }

        if (!hasTeam[now]) {
            int idx = path.indexOf(now);
            if (idx != -1) {
                for (int i = idx; i < path.size(); i++) {
                    hasTeam[path.get(i)] = true;
                    count++;
                }
            }
        }
    }
}