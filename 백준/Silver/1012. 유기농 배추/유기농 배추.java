import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static boolean[][] list;
    public static int N;
    public static int M;
    public static int K;
    public static int[] dx = {1,-1,0,0};
    public static int[] dy = {0,0,1,-1};
    public static class Node{
        int x;
        int y;
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        String[] s;
        for(int t = 0 ; t < T ; t++){
            s = br.readLine().split(" ");
            M = Integer.parseInt(s[0]);
            N = Integer.parseInt(s[1]);
            K = Integer.parseInt(s[2]);
            list = new boolean[N][M];
            for(int i = 0 ; i < K ; i++){
                s = br.readLine().split(" ");
                list[Integer.parseInt(s[1])][Integer.parseInt(s[0])] = true;
            }
            int count = 0;
            for(int i = 0 ; i < N ; i++){
                for(int j = 0 ; j < M ; j++){
                    if(list[i][j]){
                        count++;
                        bfs(i,j);
                    }
                }
            }
            sb.append(count);
            if(t!=T-1){
                sb.append("\n");
            }
        }
        System.out.print(sb);
    }
    public static void bfs(int x, int y){
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x,y));
        while (!q.isEmpty()){
            Node now = q.poll();
            for(int i = 0 ; i < 4 ; i++){
                int ddx = now.x + dx[i];
                int ddy = now.y + dy[i];
                if(ddx>=0&&ddx<N&&ddy>=0&&ddy<M&&list[ddx][ddy]){
                    list[ddx][ddy] = false;
                    q.add(new Node(ddx,ddy));
                }
            }
        }
    }
}