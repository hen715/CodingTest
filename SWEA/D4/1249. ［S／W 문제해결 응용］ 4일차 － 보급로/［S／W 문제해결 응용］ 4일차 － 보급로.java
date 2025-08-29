import java.io.*;
import java.util.*;


public class Solution {

    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int tc = 1 ; tc <= T ; tc++){
            int N = Integer.parseInt(br.readLine());
            int[][] list = new int[N][N];
            int[][] dis = new int[N][N];
            String str;
            for(int i = 0 ; i < N ; i++){
                str = br.readLine();
                for(int j = 0 ; j < N ; j++){
                    list[i][j] = str.charAt(j) - '0';
                    dis[i][j] = Integer.MAX_VALUE;
                }
            }
            boolean[][] visit = new boolean[N][N];
            dis[0][0] = 0;
            PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);
            pq.add(new int[]{0,0,0});
            while (!pq.isEmpty()||!visit[N-1][N-1]){
                int[] now = pq.poll();
                if(visit[now[0]][now[1]]) continue;
                visit[now[0]][now[1]] = true;
                for(int i = 0 ; i < 4 ; i++){
                    int ddx = now[0] + dx[i];
                    int ddy = now[1] + dy[i];
                    if(ddx>=0&&ddx<N&&ddy>=0&&ddy<N&&!visit[ddx][ddy] && dis[ddx][ddy] > list[ddx][ddy] + now[2]){
                        dis[ddx][ddy] = list[ddx][ddy] + now[2];
                        pq.add(new int[]{ddx,ddy,list[ddx][ddy]+now[2]});
                    }
                }
            }
            sb.append('#').append(tc).append(' ').append(dis[N-1][N-1]).append('\n');

        }
        System.out.print(sb);
    }



}