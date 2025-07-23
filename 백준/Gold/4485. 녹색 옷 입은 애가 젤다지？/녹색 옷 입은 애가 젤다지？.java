import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;


public class Main {
    public static class Node{
        int x;
        int y;
        int cost;
        public Node(int x, int y, int cost){
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int p = 1;
        while (N!=0){
            int[][] list = new int[N][N];
            String[] s;
            for(int i = 0 ; i < N ; i++){
                s = br.readLine().split(" ");
                for(int j = 0 ; j < N ; j++){
                    list[i][j] = Integer.parseInt(s[j]);
                }
            }
            int[][] dis = new int[N][N];
            for(int i = 0 ; i < N ; i++){
                for(int j = 0 ; j < N ; j++){
                    dis[i][j] = Integer.MAX_VALUE;
                }
            }
            boolean[][] visit = new boolean[N][N];
            PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2)->o1.cost-o2.cost);
            pq.add(new Node(0,0,list[0][0]));
            dis[0][0] = list[0][0];
            while (!pq.isEmpty()){
                Node now = pq.poll();
                if(!visit[now.x][now.y]){
                    visit[now.x][now.y] = true;
                    for(int i = 0 ; i < 4 ; i++){
                        int ddx = now.x + dx[i];
                        int ddy = now.y + dy[i];
                        if(ddx>=0&&ddx<N&&ddy>=0&&ddy<N&&dis[ddx][ddy] > now.cost + list[ddx][ddy]){
                            dis[ddx][ddy] = now.cost + list[ddx][ddy];
                            pq.add(new Node(ddx,ddy,now.cost + list[ddx][ddy]));
                        }
                    }
                }
            }
            sb.append("Problem ").append(p).append(": ").append(dis[N-1][N-1]).append('\n');
            p++;
            N = Integer.parseInt(br.readLine());
        }
        System.out.print(sb);
    }
}