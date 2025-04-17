import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

class Main {
    static char[][] list;
    static boolean[][] visit;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int N;
    static int M;
    static int max = 0;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        list = new char[N][M];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                list[i][j] = str.charAt(j);
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(list[i][j]=='L'){
                    visit = new boolean[N][M];
                    bfs(i,j);
                }
            }
        }
        System.out.print(max);
    }

        public static void bfs (int x1, int y1){
            Node node = new Node(x1, y1, 0);
            Queue<Node> q = new LinkedList<>();
            q.add(node);
            visit[x1][y1] = true;
            while (!q.isEmpty()) {
                Node now = q.poll();
                int x = now.x;
                int y = now.y;
                if(now.count>max) {
                    max = now.count;
                }
                for (int i = 0; i < 4; i++) {
                    int ddx = dx[i] + x;
                    int ddy = dy[i] + y;
                    if (ddx >= 0 && ddx < N && ddy >= 0 && ddy < M && !visit[ddx][ddy] && list[ddx][ddy] == 'L') {
                        visit[ddx][ddy] = true;
                        q.add(new Node(ddx, ddy, now.count + 1));
                    }
                }
            }
        }

        static class Node {
            int x;
            int y;
            int count;

            public Node(int x, int y, int count) {
                this.x = x;
                this.y = y;
                this.count = count;
            }
        }

    }