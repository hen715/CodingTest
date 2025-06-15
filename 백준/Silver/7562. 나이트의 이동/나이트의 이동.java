import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;


public class Main {
    static int L;
    static int[][] board;
    static boolean[][] visit;
    static int[] dx = {-2,-1,1,2,2,1,-1,-2};
    static int[] dy = {1,2,2,1,-1,-2,-2,-1};
    public static class Node{
        int x;
        int y;
        int count;
        public Node(int x, int y, int count){
            this.x = x;
            this.y = y;
            this.count = count;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int t = 0 ; t < T ; t++){
            L = Integer.parseInt(br.readLine());
            board = new int[L][L];
            visit = new boolean[L][L];
            String[] s = br.readLine().split(" ");
            int x = Integer.parseInt(s[0]);
            int y = Integer.parseInt(s[1]);
            s = br.readLine().split(" ");
            int targetX = Integer.parseInt(s[0]);
            int targetY = Integer.parseInt(s[1]);
            sb.append(bfs(x,y,targetX,targetY)).append('\n');
        }
        System.out.print(sb);
    }

    public static int bfs(int x, int y ,int targetX, int targetY){
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x,y,0));
        while (!q.isEmpty()){
            Node now = q.poll();
            if(now.x==targetX&&now.y==targetY){
                return now.count;
            }
            for(int i = 0 ; i < 8 ; i++){
                int ddx = now.x + dx[i];
                int ddy = now.y + dy[i];
                if(ddx>=0&&ddx<L&&ddy>=0&&ddy<L&&!visit[ddx][ddy]){
                    visit[ddx][ddy] = true;
                    q.add(new Node(ddx,ddy,now.count+1));
                }
            }

        }
        return 0;
    }
}