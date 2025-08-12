import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;


public class Main {
    static int K;
    static int W;
    static int H;
    static int[][] list;
    static int[][][] dp;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int[] horseX = {-2,-1,1,2,2,1,-1,-2};
    static int[] horseY = {1,2,2,1,-1,-2,-2,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");
        W = Integer.parseInt(s[0]);
        H = Integer.parseInt(s[1]);
        list = new int[H][W];
        dp = new int[H][W][K + 1];
        for(int i = 0 ; i < H ; i++){
            s = br.readLine().split(" ");
            for(int j = 0 ; j < W ; j++){
                list[i][j] = Integer.parseInt(s[j]);
                for(int k = 0 ; k <= K ; k++) {
                    dp[i][j][k] =Integer.MAX_VALUE;
                }
            }
        }
        if(list[0][0]==0) {
            bfs(0, 0, K,0);
        }
        int min = Integer.MAX_VALUE;
        for(int i = 0 ; i <= K ; i++){
            min = Math.min(dp[H-1][W-1][i],min);
        }
        if(min==Integer.MAX_VALUE){
            System.out.print(-1);
        }
        else{
            System.out.print(min);
        }


        /*System.out.println();
        for(int i = 0 ; i < H ; i++){
            for(int j = 0 ; j < W ; j++){
                System.out.print(dp[i][j]+ " ");
            }
            System.out.println();
        }*/
    }

    public static class Node{
        int x;
        int y;
        int k;
        int time;
        Node(int x, int y, int k ,int time){
            this.x = x;
            this.y = y;
            this.k = k;
            this.time = time;
        }
    }

    public static void bfs(int x , int y,int K, int t) {
        ArrayDeque<Node> q = new ArrayDeque<>();
        dp[0][0][K] = 0;
        q.offerLast(new Node(x, y, K, t));
        while (!q.isEmpty()) {
            Node now = q.poll();
            if (now.x == H - 1 && now.y == W - 1) {
                return;
            }
            for (int i = 0; i < 4; i++) {
                int ddx = dx[i] + now.x;
                int ddy = dy[i] + now.y;
                if (ddx >= 0 && ddx < H && ddy >= 0 && ddy < W && list[ddx][ddy] != 1 && dp[ddx][ddy][now.k] > now.time + 1) {
                    dp[ddx][ddy][now.k] = now.time + 1;
                    q.offerLast(new Node(ddx, ddy, now.k, now.time + 1));
                }
            }
            if (now.k > 0) {
                for (int i = 0; i < 8; i++) {
                    int ddx = horseX[i] + now.x;
                    int ddy = horseY[i] + now.y;
                    if (ddx >= 0 && ddx < H && ddy >= 0 && ddy < W && list[ddx][ddy] != 1 && dp[ddx][ddy][now.k - 1] > now.time + 1) {
                        dp[ddx][ddy][now.k - 1] = now.time + 1;
                        q.offerLast(new Node(ddx, ddy, now.k - 1, now.time + 1));
                    }
                }
            }

        }
    }
}