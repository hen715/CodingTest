import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;


public class Main {
    static int R;
    static int C;
    static char[][] list;
    static boolean[][] visit;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        R = Integer.parseInt(s[0]);
        C = Integer.parseInt(s[1]);
        list = new char[R][C];
        visit = new boolean[R][C];
        int x = 0;
        int y = 0;
        for(int i = 0 ; i < R ; i++){
            String str = br.readLine();
            for(int j = 0 ; j < C ; j++){
                list[i][j] = str.charAt(j);
                if(list[i][j]=='S'){
                    x = i;
                    y = j;
                }
            }
        }
        int answer = bfs(x,y);
        if(answer==-1){
            System.out.print("KAKTUS");
        }
        else{
            System.out.print(answer);
        }
    }

    public static class Node{
        int x;
        int y;
        int time;
        Node(int x, int y, int time){
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }


    public static int bfs(int x , int y) {
        ArrayDeque<Node> q = new ArrayDeque<>();
        visit[x][y] = true;
        q.offerLast(new Node(x, y,0));
        int time = 0;
        expand();
        while (!q.isEmpty()) {
            Node now = q.poll();
            if(now.time>time){
                time = now.time;
                expand();
            }
            if (list[now.x][now.y]=='D') {
                return now.time;
            }
            for (int i = 0; i < 4; i++) {
                int ddx = dx[i] + now.x;
                int ddy = dy[i] + now.y;
                if (ddx >= 0 && ddx < R && ddy >= 0 && ddy < C && (list[ddx][ddy] == '.'||list[ddx][ddy] == 'D')&& !visit[ddx][ddy]) {
                    visit[ddx][ddy] = true;
                    q.offerLast(new Node(ddx, ddy, now.time + 1));
                }
            }
        }
        return -1;
    }

    public static void expand(){
        ArrayDeque<Node> q= new ArrayDeque<>();
        for(int i = 0 ; i < R; i++){
            for(int j = 0 ; j < C ; j++){
                if(list[i][j]=='*'){
                    q.offerLast(new Node(i,j,0));
                }
            }
        }
        while (!q.isEmpty()){
            Node water = q.poll();
            for (int i = 0; i < 4; i++) {
                int ddx = dx[i] + water.x;
                int ddy = dy[i] + water.y;
                if (ddx >= 0 && ddx < R && ddy >= 0 && ddy < C && (list[ddx][ddy] == '.'||list[ddx][ddy] == 'S')) {
                    list[ddx][ddy] = '*';
                }
            }
        }
    }
}