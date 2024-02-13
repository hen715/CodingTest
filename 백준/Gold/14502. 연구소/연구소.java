import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    public static int n,m;
    public static int[][] list;
    public static int[][] rawList;
    public static int[] dx = {1,-1,0,0};
    public static int[] dy = {0,0,1,-1};

    public static Point[] arr;
    public static int count;
    public static int safeCount;

    public static Queue<Point> q;
    public static List<Point> rawQ;

    public static void bfs(){
        while (!q.isEmpty()) {
            Point v = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = v.x + dx[i];
                int ny = v.y + dy[i];
                if(nx>=0&&ny>=0&&nx<n&&ny<m&&list[nx][ny]==0){
                    list[nx][ny] = 2;
                    q.add(new Point(nx,ny));
                }
            }
        }
    }

    public static void combination(boolean[] visited,int start, int r) {
        if(r == 0) {
            checkSafe(visited);
            return;
        }

        for(int i=start; i<count; i++) {
            visited[i] = true;
            combination(visited,i + 1,  r - 1);
            visited[i] = false;
        }
    }

    public static void checkSafe(boolean[] visited){
        for(int i = 0 ; i < count ; i++){
            if(visited[i]){
                list[arr[i].x][arr[i].y]=1;
            }
        }
        bfs();
        int zone = 0;
        for(int i = 0 ; i<n;i++){
            for(int j = 0 ; j <m ; j++){
                    if(list[i][j]==0){
                        zone++;
                    }
                }
            }
        safeCount = Math.max(safeCount,zone);
        for(int i = 0 ; i < n; i++){
            for(int j = 0 ; j <m ; j++){
                list[i][j] = rawList[i][j];
            }
        }
        for(int i  = 0 ; i<rawQ.size();i++){
            q.add(rawQ.get(i));
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] s = bf.readLine().split(" ");
        n  = Integer.parseInt(s[0]);
        m =  Integer.parseInt(s[1]);
        count = 0;
        safeCount = 0;
        q = new LinkedList<>();
        arr = new Point[64];
        rawQ = new ArrayList<>();

        list = new int[n][m];
        rawList = new int[n][m];
        for(int i = 0 ; i < n ; i++){
            s = bf.readLine().split(" ");
            for(int j = 0 ; j < m ; j++){
                int num = Integer.parseInt(s[j]);
                if(num==2){
                    q.add(new Point(i,j));
                    rawQ.add(new Point(i,j));
                }
                else if(num==0){
                    arr[count] = new Point(i,j);
                    count++;
                }
                list[i][j] = num;
            }
        }
        for(int i = 0 ; i < n; i++){
            for(int j = 0 ; j <m ; j++){
                rawList[i][j] = list[i][j];
            }
        }

        boolean[] visited = new boolean[count];
        combination(visited,0,3);
        System.out.println(safeCount);



    }
}