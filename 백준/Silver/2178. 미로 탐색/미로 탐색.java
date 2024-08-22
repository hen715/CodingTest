import java.io.BufferedReader;
import java.awt.*;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static int n;
    public static int m;
    public static int[][] list;
    public static int[][] distance;
    public static int[][] visited;
    public static int[] dx = {1,-1,0,0};
    public static int[] dy = {0,0,1,-1};

    public static void dis(){
        Queue<Point> q = new LinkedList<>();
        Queue<Integer> disQ = new LinkedList<>();
        q.add(new Point(1, 1));
        disQ.add(1);
        while(!q.isEmpty()){
            Point p = q.poll();
            int dis = disQ.poll();
            if(visited[p.x][p.y] == 0){
                distance[p.x][p.y] = dis;
                visited[p.x][p.y] = 1;
                for(int i = 0 ; i < 4 ; i++){
                    int nx = p.x + dx[i];
                    int ny = p.y + dy[i];
                    if(nx>0&&nx<n+1&&ny>0&&ny<m+1&&visited[nx][ny] == 0&&list[nx][ny] == 1){
                        Point temp = new Point(nx, ny);
                        q.add(temp);
                        disQ.add(dis+1);
                    }
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        list = new int[n+1][m+1];
        distance = new int[n+1][m+1];
        visited = new int[n+1][m+1];
        for(int i = 1 ; i < n + 1 ; i++){
            String str = br.readLine();
            for(int j= 1 ; j < m + 1; j++){
                list[i][j] = str.charAt(j-1) - '0';
            }
        }
        dis();
        System.out.println(distance[n][m]);

    }
}