import java.awt.*;
import java.io.*;
import java.util.*;

class Main {
    static int n;
    static int m;
    static int[][] list;
    static int[][] distance;
    static int[][] visited;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};

    public static void bfs(int x, int y){
        Queue<Point> queue = new LinkedList<>();
        Queue<Integer> queue2 = new LinkedList<>();
        Point p  = new Point();
        p.x = x;
        p.y = y;
        int dis = 0;
        queue.add(p);
        queue2.add(dis);
        while (!queue.isEmpty()){
            p = queue.poll();
            dis = queue2.poll();
            if(visited[p.x][p.y]==0) {
                distance[p.x][p.y] = dis;
                visited[p.x][p.y] = 1;
                for (int i = 0; i < 4; i++) {
                    int nx = p.x + dx[i];
                    int ny = p.y + dy[i];
                    if (nx >= 0 && nx < n && ny >= 0 && ny < m && visited[nx][ny] == 0 && list[nx][ny] == 1) {
                        Point point = new Point();
                        point.x = nx;
                        point.y = ny;
                        queue.add(point);
                        queue2.add(dis+1);
                    }
                }
            }
        }
    }




    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        list =new int[n][m];
        distance = new int[n][m];
        visited = new int[n][m];
        int x = 0;
        int y = 0;
        for(int i = 0 ; i < n ; i++){
            s = br.readLine().split(" ");
            for(int j = 0 ; j < m ; j++){
                int num = Integer.parseInt(s[j]);
                list[i][j] = num;
                if(num==2){
                    x = i;
                    y = j;
                }
            }
        }
        for(int i = 0 ; i < n ; i++) {
            for (int j = 0; j < m; j++) {
                distance[i][j] = -1;
            }
        }
        bfs(x,y);
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(list[i][j]==0){
                    sb.append(0+" ");
                }
                else {
                    sb.append(distance[i][j] + " ");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);

    }
}