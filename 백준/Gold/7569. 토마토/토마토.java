import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static int n;
    public static int m;
    public static int h;

    public static int[][] list;
    public static int[][] visited;
    public static int[] dy = {0,0,1,-1,0,0};
    public static int fcount = 0;
    public static int tcount = 0;
    public static int zcount = 0;
    public static Queue<Point> q;

    public static void tomato2(int x, int y){
        if (list[x][y] == 0) {
            list[x][y] = 1;
            if(visited[x][y]!=1){
                q.add(new Point(x,y));
                visited[x][y]= 1;
            }
            tcount++;
        }
    }

    public static void tomato(int x, int y,int[] dx){
        for(int i = 0 ; i <6 ; i++){
            int nx = x +dx[i];
            int ny = y + dy[i];
            int high = x/m;
            if(i==4&&nx<m*h){
                tomato2(nx,ny);
            }
            else if(i==5&&nx>=0){
                tomato2(nx,ny);
            }
            else if(nx>=m*high&&nx<m*high+m&&ny>=0&&ny<n) {
                tomato2(nx,ny);
        }
        }

    }



    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String [] s = bf.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        h = Integer.parseInt(s[2]);

        list = new int[m*h][n];
        visited = new int[m*h][n];
        q = new LinkedList<>();
        int[] dx = {1,-1,0,0,m,-m};


        for(int i = 0 ; i<m*h ; i++){
            s = bf.readLine().split(" ");
            for(int j = 0 ; j < n ; j++){
                int a = Integer.parseInt(s[j]);
                list[i][j] = a;
                if (a==1){
                    visited[i][j] = 1;
                    q.add(new Point(i,j));
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
                tomato(p.x,p.y,dx);
            }
            day++;
            if(tmp == tcount){
                if(day ==1){
                    int a =0;
                    for(int i = 0 ; i<m;i++){
                        for(int j = 0 ; j < n ; j++){
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