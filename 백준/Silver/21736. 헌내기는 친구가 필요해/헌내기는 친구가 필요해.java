import java.awt.*;
import java.io.*;
import java.util.*;

class Main {
    static int n;
    static int m;
    static char[][] list;
    static int count = 0;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int[][] visited;

    public static void search(int x , int y){
        Point p = new Point(x,y);
        Queue<Point> queue = new LinkedList<>();
        queue.add(p);
        while (!queue.isEmpty()){
            p = queue.poll();
            if(visited[p.x][p.y]==0) {
                visited[p.x][p.y] = 1;
                if (list[p.x][p.y] == 'P') {
                    count++;
                }
                for (int i = 0; i < 4; i++) {
                    int nx = p.x + dx[i];
                    int ny = p.y + dy[i];
                    if (nx >= 0 && nx < n && ny >= 0 && ny < m && list[nx][ny] != 'X' && visited[nx][ny] == 0) {
                        queue.add(new Point(nx, ny));
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
        list = new char[n][m];
        visited = new int[n][m];
        int x=0;
        int y=0;
        for(int i = 0 ; i < n ; i++){
            String str =br.readLine();
            for(int j = 0 ; j < m ; j++){
                char c = str.charAt(j);
                list[i][j] = c;
                if(c=='I'){
                    x = i;
                    y = j;
                }
            }
        }
        search(x,y);
        if(count==0){
            System.out.println("TT");
        }
        else {
            System.out.println(count);
        }
    }
}