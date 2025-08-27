import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int N;
    static int M;
    static int[][] list;
    static int[] dx = {1,-1,0,0};//아래, 위, 오른쪽, 왼쪽
    static int[] dy = {0,0,1,-1};
    static int landNum = 0;
    static PriorityQueue<Bridge> pq;
    static List<List<Bridge>> bridges;
    static boolean[][] visit;

    public static class Node{
        int x;
        int y;
        public Node(int x, int y){
            this.x = x;
            this.y =y ;
        }
    }

    public static class Bridge{
        int des;
        int cost;
        public Bridge(int des, int cost){
            this.des = des;
            this.cost = cost;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        list = new int[N][M];
        for(int i = 0 ; i < N ; i++){
            s = br.readLine().split(" ");
            for(int j = 0 ; j < M ; j++){
                list[i][j] = Integer.parseInt(s[j]);
            }
        }
        // 각 섬에 번호 부여
        visit = new boolean[N][M];
        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < M ; j++){
                if(!visit[i][j]&&list[i][j]==1){
                    setLandNum(i,j);
                }
            }
        }

        // 다리 만들기
        bridges = new ArrayList<>();
        for(int i = 0 ; i <=landNum ; i++){
            bridges.add(new ArrayList<>());
        }
        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < M ; j++){
                if(list[i][j]!=0) {
                    makeBridge(i, j);
                }
            }
        }

        // 모든 섬을 연결하는 다리 최솟값 구하기
        pq = new PriorityQueue<>((o1,o2)->o1.cost-o2.cost);
        boolean[] v = new boolean[landNum + 1];
        point: for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < M ; j++){
                if(list[i][j]!=0){
                    pq.add(new Bridge(list[i][j],0));
                    break point;
                }
            }
        }
        int cost = 0;
        while (!pq.isEmpty()){
            Bridge b = pq.poll();
            if(v[b.des]){
                continue;
            }
            v[b.des] = true;
            cost += b.cost;
            for(Bridge bridge : bridges.get(b.des)){
                if(!v[bridge.des]){
                    pq.add(bridge);
                }
            }
        }

        // 출력
        // 방문하지 않은 섬이 있다면 -1 출력
        int result = cost;
        for(int i = 1 ; i <=landNum ; i++){
            if (!v[i]){
               result = -1;
               break;
            }
        }
        System.out.print(result);
    }

    public static void makeBridge(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int ddx = x + dx[i];
            int ddy = y + dy[i];
            int count = 0;

            while (ddx >= 0 && ddx < N && ddy >= 0 && ddy < M && list[ddx][ddy] == 0) {
                count++;
                ddx += dx[i];
                ddy += dy[i];
            }

            if (ddx >= 0 && ddx < N && ddy >= 0 && ddy < M && count > 1) {
                int from = list[x][y];
                int to = list[ddx][ddy];
                bridges.get(from).add(new Bridge(to, count));
                bridges.get(to).add(new Bridge(from, count));
            }
        }
    }


    public static void setLandNum(int x, int y){
        landNum++;
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x,y));
        list[x][y] = landNum;
        visit[x][y] = true;
        while (!q.isEmpty()){
            Node now = q.poll();
            for(int i = 0 ; i < 4 ; i++){
                int ddx = now.x + dx[i];
                int ddy = now.y + dy[i];
                if(ddx >= 0 && ddx < N && ddy >= 0 && ddy < M && list[ddx][ddy]==1 && !visit[ddx][ddy]){
                    list[ddx][ddy] = landNum;
                    visit[ddx][ddy] = true;
                    q.add(new Node(ddx,ddy));
                }
            }
        }
    }

}