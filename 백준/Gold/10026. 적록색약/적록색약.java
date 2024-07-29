import java.awt.*;
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

class Main {
    public static int[] dx = {1,-1,0,0};
    public static int[] dy = {0,0,1,-1};
    public static int[][] visited;
    public static int[][] nVisited;
    public static char[][] picture;
    public static int n;
    public static Queue<Point> q;
    public static int pCount = 0;
    public static int nCount = 0;

    public static void dfs(int x, int y){
        q.add(new Point(x,y));
        pCount++;
        while(!q.isEmpty()) {
            Point p = q.poll();
            x = p.x;
            y = p.y;
            char color = picture[x][y];
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                    if (picture[nx][ny] == color) {
                        if (visited[nx][ny] != 1) {
                            q.add(new Point(nx, ny));
                            visited[nx][ny] = 1;
                        }

                    }
                }
            }
        }
    }

    public static void nDfs(int x, int y){
        q.add(new Point(x,y));
        nCount++;
        while(!q.isEmpty()) {
            Point p = q.poll();
            x = p.x;
            y = p.y;
            char color = picture[x][y];
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                    if(color=='B'){
                        if (picture[nx][ny] == color) {
                            if (nVisited[nx][ny] != 1) {
                                q.add(new Point(nx, ny));
                                nVisited[nx][ny] = 1;
                            }

                        }
                    }
                    else {
                        if (picture[nx][ny] == 'R'||picture[nx][ny] == 'G') {
                            if (nVisited[nx][ny] != 1) {
                                q.add(new Point(nx, ny));
                                nVisited[nx][ny] = 1;
                            }

                        }
                    }
                }
            }
        }
    }


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        picture = new char[n][n];
        visited = new int[n][n];
        nVisited = new int[n][n];
        q = new LinkedList<>();
        for(int i = 0 ; i < n ; i++){
            String s = br.readLine();
            for(int j = 0 ; j < n ; j++){
                picture[i][j] = s.charAt(j);
            }
        }
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                if(visited[i][j]==0){
                    dfs(i,j);
                }
                if(nVisited[i][j]==0){
                    nDfs(i,j);
                }
            }
        }
        System.out.println(pCount+" "+nCount);



    }

}