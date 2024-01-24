import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static int n;
    public static int m;

    public static int[][] list;
    public static int[][] visited;
    public static int[] dx = {1,-1,0,0};
    public static int[] dy = {0,0,1,-1};
    public static int fcount = 0;
    public static int tcount = 0;
    public static int zcount = 0;
    public static Queue<Point> q;

    public static void tomato(int x, int y){
        for(int i = 0 ; i <4 ; i++){
            int nx = x +dx[i];
            int ny = y+dy[i];
            if(nx>=0&&nx<n&&ny>=0&&ny<m) {
                if (list[nx][ny] == 0) {
                    list[nx][ny] = 1;
                    if(visited[nx][ny]!=1){
                        q.add(new Point(nx,ny));
                        visited[nx][ny]= 1;
                    }
                    tcount++;
                }
        }
        }

    }



    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String [] s = bf.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);

        list = new int[n][m];
        visited = new int[n][m];
        q = new LinkedList<>();


        for(int i = 0 ; i<m ; i++){
            s = bf.readLine().split(" ");
            for(int j = 0 ; j < n ; j++){
                int a = Integer.parseInt(s[j]);
                list[j][i] = a;
                if (a==1){
                    visited[j][i] = 1;
                    q.add(new Point(j,i));
                    tcount++;
                    fcount++;
                }
                if(a==0)
                    zcount++;
            }
        }
        int day = 0;
        while(true){
            int tmp = tcount;
            int qSize = q.size();
            for(int i = 0 ; i< qSize;i++){
                Point p = q.poll();
                tomato(p.x,p.y);
            }
            day++;
            if(tmp == tcount){
                if(day ==1){
                    int a =0;
                    for(int i = 0 ; i<n;i++){
                        for(int j = 0 ; j < m ; j++){
                            if(list[i][j]==0){
                                a=1;
                            }
                        }
                    }
                    if(a==1||tcount==0)
                        System.out.println(-1);
                    else
                        System.out.println(0);
                    break;
                }
                else if(tcount == zcount+fcount){
                    day--;
                    System.out.println(day);
                    break;
                }
                else{
                    System.out.println(-1);
                    break;
                }
            }

        }
    }
}