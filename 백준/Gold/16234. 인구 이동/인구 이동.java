import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int[][] list;
    static int N;
    static int L;
    static int R;
    static boolean isChanged = true;
    static boolean[][] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        L = Integer.parseInt(s[1]);
        R = Integer.parseInt(s[2]);
        list = new int[N][N];
        for(int i = 0 ; i <N ; i++){
            s = br.readLine().split(" ");
            for(int j = 0 ; j < N ; j++){
                list[i][j] = Integer.parseInt(s[j]);
            }
        }
        int day = 0;
        while (isChanged){
            isChanged = false;
            visit = new boolean[N][N];
            for(int i = 0 ; i <N ; i++){
                for(int j = 0 ; j < N ; j++){
                    if(!visit[i][j]){
                        move(i,j);
                    }
                }
            }
            if(isChanged){
                day++;
            }
        }
        System.out.print(day);
    }

    public static class Node{
        int x;
        int y;
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    public static void move(int x, int y){
        Queue<Node> q = new LinkedList<>();
        Queue<Node> trace = new LinkedList<>();
        q.add(new Node(x,y));
        trace.add(new Node(x,y));
        visit[x][y] = true;
        int sum = 0;
        while (!q.isEmpty()){
            Node now = q.poll();
            sum += list[now.x][now.y];
            for(int i = 0 ; i < 4;  i++){
                int ddx = dx[i] + now.x;
                int ddy = dy[i] + now.y;

                if(ddx>=0&&ddx<N&&ddy>=0&&ddy<N&&!visit[ddx][ddy]&&Math.abs(list[now.x][now.y]-list[ddx][ddy])>=L&&Math.abs(list[now.x][now.y]-list[ddx][ddy])<=R){
                    isChanged = true;
                    visit[ddx][ddy] = true;
                    q.add(new Node(ddx,ddy));
                    trace.add(new Node(ddx,ddy));
                }
            }
        }
        sum /= trace.size();
        if(trace.size()!=1){
            while (!trace.isEmpty()){
                Node node = trace.poll();
                list[node.x][node.y] = sum;
            }
        }
    }
}