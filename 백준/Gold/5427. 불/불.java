import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int N;
    static int M;
    static int[][] building;
    static boolean[][] visit;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static Queue<Node> fire;
    public static class Node{
        int x;
        int y;
        int time;
        public Node(int x, int y, int time){
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        fire = new LinkedList<>();
        for(int t = 0 ; t < T ; t++) {
            String[] s = br.readLine().split(" ");
            N = Integer.parseInt(s[1]);
            M = Integer.parseInt(s[0]);
            building = new int[N][M];
            visit = new boolean[N][M];
            String str;
            int x = 0;
            int y = 0;
            for(int i = 0 ; i < N ; i++){
                str = br.readLine();
                for(int j = 0 ; j < M ; j++){
                    building[i][j] = str.charAt(j);
                    if(building[i][j]=='@'){
                        x = i;
                        y = j;
                    }
                    if(building[i][j]=='*'){
                        fire.add(new Node(i,j,0));
                    }
                }
            }
            int time = search(x,y);
            if(time==-1){
                sb.append("IMPOSSIBLE").append('\n');
            }
            else{
                sb.append(time).append('\n');
            }
            fire.clear();
        }
        System.out.print(sb);
    }
    public static int search(int x, int y){
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x,y,0));
        while (!q.isEmpty()){
            Node now = q.poll();
            if(!fire.isEmpty()&&fire.peek().time==now.time){
                while (!fire.isEmpty()&&fire.peek().time==now.time){
                    Node f = fire.poll();
                    for(int i = 0 ; i < 4 ; i++){
                        int ddx = f.x + dx[i];
                        int ddy = f.y + dy[i];
                        if(ddx>=0&&ddx<N&&ddy>=0&&ddy<M&&building[ddx][ddy]=='.'){
                            building[ddx][ddy] = '*';
                            fire.add(new Node(ddx,ddy,f.time + 1));
                        }
                    }
                }
            }
            if(now.x==0||now.x==N-1||now.y==0||now.y==M-1){
                return now.time+1;
            }
            for(int i = 0 ; i < 4 ; i++){
                int ddx = now.x + dx[i];
                int ddy = now.y + dy[i];
                if(ddx>=0&&ddx<N&&ddy>=0&&ddy<M&&building[ddx][ddy]=='.'&&!visit[ddx][ddy]){
                    visit[ddx][ddy] = true;
                    q.add(new Node(ddx,ddy,now.time + 1));
                }
            }
        }
        return -1;
    }
}