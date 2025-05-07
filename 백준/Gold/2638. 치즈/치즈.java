import java.io.*;
import java.util.LinkedList;
import java.util.Queue;


class Main {
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int N;
    static int M;
    static boolean[][] visit;
    static int[][] list;



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        list = new int[N][M];
        for (int i = 0; i < N; i++) {
            s = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                list[i][j] = Integer.parseInt(s[j]);
            }
        }
        visit = new boolean[N][M];
        init();

        boolean isEmpty = false;
        int time = 0;
        while (!isEmpty) {
            isEmpty = true;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (list[i][j] == 1) {
                        isEmpty = false;
                        int c = 0;
                        for (int a = 0; a < 4; a++) {
                            int ddx = i + dx[a];
                            int ddy = j + dy[a];
                            if (ddx >= 0 && ddx < N && ddy >= 0 && ddy < M && visit[ddx][ddy]) {
                                c++;
                            }
                        }
                        if (c > 1) {
                            list[i][j] = 3;
                        }
                    }

                }
            }
            for(int i = 0 ; i < N ; i++){
                for(int j = 0 ; j < M ; j++){
                    if(list[i][j]!=1){
                        list[i][j] = 0;
                    }
                }
            }
            init();
            time++;

        }
        System.out.print(time - 1);
    }
    public static class Node{
        int x;
        int y;
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public static void init(){
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0,0));
        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < M ; j++){
                visit[i][j] = false;
            }
        }
        while (!q.isEmpty()){
            Node now = q.poll();
            for (int a = 0; a < 4; a++) {
                int ddx = now.x + dx[a];
                int ddy = now.y + dy[a];
                if (ddx >= 0 && ddx < N && ddy >= 0 && ddy < M && list[ddx][ddy] == 0 && !visit[ddx][ddy]) {
                    visit[ddx][ddy] = true;
                    q.add(new Node(ddx,ddy));
                }
            }
        }
    }
}