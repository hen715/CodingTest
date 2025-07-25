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
        visit = new boolean[N][M];
        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < M ; j++){
                if(!visit[i][j]&&list[i][j]==1){
                    landNum++;
                    setLandNum(i,j);
                }
            }
        }
        bridges = new ArrayList<>();
        for(int i = 0 ; i <=landNum ; i++){
            bridges.add(new ArrayList<>());
        }
        pq = new PriorityQueue<>((o1,o2)->o1.cost-o2.cost);
        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < M ; j++){
                if(list[i][j]!=0) {
                    makeBridge(i, j);
                }
            }
        }
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
        for(int i = 1 ; i <=landNum ; i++){
            if (!v[i]){
                System.out.print(-1);
                System.exit(0);
            }
        }
        if(cost==0){
            System.out.println(-1);
        }
        else {
            System.out.print(cost);
        }

    }

    public static void makeBridge(int x, int y){
        for(int i = 0 ; i < 4 ; i++){
            int ddx = x +dx[i];
            int ddy = y +dy[i];
            int count = 0;
            if(i==0){
                while (ddx<N&&list[ddx][ddy]==0){
                    count++;
                    ddx++;
                }
                if(ddx!=N&&count>1){
                    bridges.get(list[x][y]).add(new Bridge(list[ddx][ddy], count));
                    bridges.get(list[ddx][ddy]).add(new Bridge(list[x][y], count));
                }
            }
            if(i==1){
                while (ddx>=0&&list[ddx][ddy]==0){
                    count++;
                    ddx--;
                }
                if(ddx>=0&&count>1){
                    bridges.get(list[x][y]).add(new Bridge(list[ddx][ddy], count));
                    bridges.get(list[ddx][ddy]).add(new Bridge(list[x][y], count));
                }
            }
            if(i==2){
                while (ddy<M&&list[ddx][ddy]==0){
                    count++;
                    ddy++;
                }
                if(ddy!=M&&count>1){
                    bridges.get(list[x][y]).add(new Bridge(list[ddx][ddy], count));
                    bridges.get(list[ddx][ddy]).add(new Bridge(list[x][y], count));
                }
            }
            if(i==3){
                while (ddy>=0&&list[ddx][ddy]==0){
                    count++;
                    ddy--;
                }
                if(ddy>=0&&count>1){
                    bridges.get(list[x][y]).add(new Bridge(list[ddx][ddy], count));
                    bridges.get(list[ddx][ddy]).add(new Bridge(list[x][y], count));
                }
            }
        }
    }

    public static void setLandNum(int x, int y){
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