import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Solution {
    static int N;
    static int[][] list;
    static boolean[][] visit;
    static int count;
    static int min;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int t = 1 ; t <= T ; t++) {
            N = Integer.parseInt(br.readLine());
            String[] s;
            list = new int[N][N];
            visit = new boolean[N][N];
            for(int i = 0 ; i < N ; i++){
                s = br.readLine().split(" ");
                for(int j = 0 ; j < N ; j++){
                    list[i][j] = Integer.parseInt(s[j]);
                }
            }
            count = 0;
            min = Integer.MAX_VALUE;
            for(int i = 0 ; i < N ; i++){
                for(int j = 0 ; j < N ; j++){
                    if(!visit[i][j]){
                        bfs(i,j);
                    }
                }
            }

            sb.append('#').append(t).append(' ').append(min).append(' ').append(count);
            if(t!=T) {
                sb.append('\n');
            }
        }
        System.out.print(sb);
    }

    public static void bfs(int x, int y){
        ArrayDeque<int[]> q = new ArrayDeque<>();
        visit[x][y] = true;
        q.offerLast(new int[]{x,y});
        int m = list[x][y];
        int c = 0;
        while (!q.isEmpty()){
            int[] now = q.poll();
            c++;
            if(m > list[now[0]][now[1]]){
                m = list[now[0]][now[1]];
            }
            for(int i = 0 ; i < 4 ; i++){
                int ddx = now[0] + dx[i];
                int ddy = now[1] + dy[i];
                if(ddx>=0&&ddx<N&&ddy>=0&&ddy<N&&!visit[ddx][ddy]&&(list[ddx][ddy] -1 ==list[now[0]][now[1]]||list[ddx][ddy] + 1 ==list[now[0]][now[1]])){
                    visit[ddx][ddy] = true;
                    q.offerLast(new int[]{ddx,ddy});
                }
            }
        }
        if(c>count){
            count = c;
            min = m;
        }
        else if(c==count){
            min = Math.min(min,m);
        }
    }

    
}