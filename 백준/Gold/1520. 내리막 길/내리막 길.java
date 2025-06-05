import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    static int N;
    static int M;
    static int[][] list;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        list = new int[N][M];
        visit = new int[N][M];
        for(int i = 0 ; i < N ; i++){
            s = br.readLine().split(" ");
            for(int j = 0 ; j < M ; j++){
                list[i][j] = Integer.parseInt(s[j]);
                visit[i][j] = -1;
            }
        }
        System.out.print(dfs(0,0));
    }

    public static int dfs(int x, int y){
        if(x == N-1 && y == M - 1){
            return 1;
        }
        if(visit[x][y]!=-1){
            return visit[x][y];
        }
        visit[x][y] = 0;
        for(int i = 0 ; i < 4 ; i++){
            int ddx = x + dx[i];
            int ddy = y + dy[i];
            if(ddx>=0&&ddx<N&&ddy>=0&&ddy<M){
                if(list[ddx][ddy]<list[x][y]){
                    visit[x][y] += dfs(ddx,ddy);
                }
            }
        }
        return visit[x][y];
    }
}