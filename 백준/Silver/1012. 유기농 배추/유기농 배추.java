import java.util.Scanner;

public class Main {

    public static void dfs(int x, int y, int[][] g, int[][] visited,int m, int n){
        visited[x][y] = 1;
        if(x-1>=0&&g[x-1][y]==1&&visited[x-1][y]==0){
            dfs(x-1,y,g,visited,m,n);
        }
        if(y-1>=0&&g[x][y-1]==1&&visited[x][y-1]==0){
            dfs(x,y-1,g,visited,m,n);
        }
        if(x+1<m&&g[x+1][y]==1&&visited[x+1][y]==0){
            dfs(x+1,y,g,visited,m,n);
        }
        if(y+1<n&&g[x][y+1]==1&&visited[x][y+1]==0){
            dfs(x,y+1,g,visited,m,n);
        }
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int b = scanner.nextInt();
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i<b;i++){
            int m = scanner.nextInt();
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int[][] g = new int[m][n];
            int[][] visited = new int[m][n];
            for(int c = 0 ; c < m ; c++) {
                for (int d = 0; d < n; d++) {
                    g[c][d] = 0;
                    visited[c][d] = 0;
                }
            }
            for(int j = 0 ; j<k;j++){
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                g[x][y] = 1;
            }
            int count = 0;
            for(int x1 = 0 ; x1 < m;x1++){
                for(int y1 = 0 ; y1 < n ; y1++){
                    if(visited[x1][y1]==0&&g[x1][y1]==1){
                        visited[x1][y1]=1;
                        dfs(x1,y1,g,visited,m,n);
                        count++;
                    }
                }
            }
            sb.append(count);
            sb.append("\n");
        }
        System.out.println(sb);
    }


}