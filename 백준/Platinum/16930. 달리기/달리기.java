import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static int M;
    static int K;
    static char[][] list;
    static int[][] visit;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        K = Integer.parseInt(s[2]);
        list = new char[N + 1][M + 1];
        visit = new int[N + 1][M + 1];
        String str;
        for (int i = 1; i <= N; i++) {
            str = br.readLine();
            for (int j = 1; j <= M; j++) {
                list[i][j] = str.charAt(j - 1);
            }
        }
        s = br.readLine().split(" ");
        int sx = Integer.parseInt(s[0]);
        int sy = Integer.parseInt(s[1]);
        int ex = Integer.parseInt(s[2]);
        int ey = Integer.parseInt(s[3]);
        Queue<int[]> q = new ArrayDeque();
        q.add(new int[]{sx, sy, 0});
        visit[sx][sy] = -1;
        while (!q.isEmpty()) {
            int[] now = q.poll();
            //System.out.println(now[0]+" "+now[1]);
            for (int i = 0; i < 4; i++) {
                for (int a = 1; a <= K; a++) {
                    int ddx = now[0] + dx[i] * a;
                    int ddy = now[1] + dy[i] * a;
                    if (ddx >= 1 && ddx <= N && ddy >= 1 && ddy <= M) {
                        if (list[ddx][ddy] == '#') {
                            break;
                        }
                        if(visit[ddx][ddy]!=0 && visit[ddx][ddy]<now[2]+1){
                            break;
                        }
                        if(visit[ddx][ddy]!=0 && visit[ddx][ddy]==now[2]+1){
                            continue;
                        }
                        //System.out.println(ddx+" "+ddy + " "+ now[0]+" "+now[1]);
                        if (visit[ddx][ddy] == 0 && list[ddx][ddy] == '.') {
                            visit[ddx][ddy] = now[2] + 1;
                            q.add(new int[]{ddx, ddy, now[2] + 1});
                        }
                    }
                }
            }
        }
        if (visit[ex][ey] == 0) {
            System.out.print(-1);
        } else if (sx == ex && sy == ey) {
            System.out.print(0);
        } else {
            System.out.print(visit[ex][ey]);
        }

    }
}