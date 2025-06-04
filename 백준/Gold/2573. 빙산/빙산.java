import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;


public class Main {
    static int N;
    static int M;
    static int[][] list;
    static boolean[][] visit;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
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
        int year = 0;
        int count = count();
        while (count<2){
            iceBreak();
            count = count();
            year++;
        }
        System.out.print(year);
    }
    public static void iceBreak(){
        int total = 0;
        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < M ; j++){
                if(list[i][j]!=0) {
                    int count = 0;
                    for (int k = 0; k < 4; k++) {
                        int ddx = i + dx[k];
                        int ddy = j + dy[k];
                        if (ddx >= 0 && ddx < N && ddy >= 0 && ddy < M && list[ddx][ddy] == 0) {
                            count++;
                        }
                    }
                    if (list[i][j] - count <= 0) {
                        list[i][j] = -1;
                    } else {
                        list[i][j] -= count;
                    }
                }
                else{
                    total++;
                }
            }
        }
        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < M ; j++){
                if(list[i][j]==-1){
                    list[i][j] = 0;
                }
            }
        }
        if(total==N * M){
            System.out.print(0);
            System.exit(0);
        }
    }

    public static int count(){
        visit = new boolean[N][M];
        int count = 0;
        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < M ; j++){
                if(!visit[i][j]&&list[i][j]!=0){
                    count++;
                    bfs(i,j);
                }
            }
        }
        return count;
    }
    public static void bfs(int x, int y){
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x,y));
        visit[x][y] = true;
        while (!q.isEmpty()){
            Node now =  q.poll();
            for(int i = 0 ; i < 4 ; i++){
                int ddx = now.x + dx[i];
                int ddy = now.y + dy[i];
                if(ddx>=0&&ddx<N&&ddy>=0&&ddy<M&&!visit[ddx][ddy]&&list[ddx][ddy]!=0){
                    visit[ddx][ddy] = true;
                    q.add(new Node(ddx,ddy));
                }
            }
        }
    }
}