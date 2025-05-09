import java.io.*;
import java.util.LinkedList;
import java.util.Queue;


class Main {
    public static class Node{
        int x;
        int y;
        int time;

        public Node(int x,int y, int time){
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }
    static int n;
    static int[][] list;
    static int size;
    static int stack;
    static int totalTime = 0;
    static boolean isFinished;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        list = new int[n][n];
        String[] s;
        int x = 0;
        int y = 0;
        for(int i = 0 ; i < n ; i++){
            s = br.readLine().split(" ");
            for(int j = 0 ; j < n ; j++){
                list[i][j] = Integer.parseInt(s[j]);
                if(list[i][j]==9){
                    x = i;
                    y = j;
                }
            }
        }
        size = 2;
        stack = 0;
        isFinished = false;
        list[x][y] = 0;
        while (!isFinished){
            Node now = searchFish(x,y);
            x = now.x;
            y = now.y;
        }
        System.out.print(totalTime);
    }

    public static Node searchFish(int x, int y){
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x,y,0));
        boolean[][] visit = new boolean[n][n];
        int min = Integer.MAX_VALUE;
        int xx = x;
        int yy = y;
        while (!q.isEmpty()){
            Node now = q.poll();
            if(list[now.x][now.y]>0&&list[now.x][now.y]<size) {
                if (now.time < min) {
                    xx = now.x;
                    yy = now.y;
                    min = now.time;
                } else if (now.time == min) {
                    if (xx > now.x) {
                        xx = now.x;
                        yy = now.y;
                    } else if (xx == now.x && yy > now.y) {
                        xx = now.x;
                        yy = now.y;
                    }
                }
            }
            for(int i = 0 ; i < 4 ; i++){
                int ddx = now.x + dx[i];
                int ddy = now.y + dy[i];
                if(ddx>=0&&ddx<n&&ddy>=0&&ddy<n&&list[ddx][ddy]<=size&&!visit[ddx][ddy]){
                    visit[ddx][ddy] = true;
                    q.add(new Node(ddx,ddy,now.time + 1));
                }
            }
        }
        if(xx == x && yy == y){
            isFinished = true;
            return new Node(0,0,0);
        }
        list[xx][yy] = 0;
        totalTime += min;
        stack++;
        if(size==stack){
            size++;
            stack = 0;
        }
        return new Node(xx,yy,0);
    }
}