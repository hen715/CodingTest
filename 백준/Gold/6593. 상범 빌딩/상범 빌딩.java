import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

class Main {
    static StringBuilder sb;
    static char[][][] building;
    static boolean[][][] visit;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int L;
    static int R;
    static int C;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        String[] s = br.readLine().split(" ");
        L = Integer.parseInt(s[0]);
        R = Integer.parseInt(s[1]);
        C = Integer.parseInt(s[2]);
        int s1 = 0;
        int s2 = 0;
        int s3 = 0;
        while(L!=0&&R!=0&&C!=0){
            building = new char[L][R][C];
            visit = new boolean[L][R][C];
            for(int i = 0 ; i < L ; i++){
                for(int j = 0 ; j < R ; j++){
                    String str = br.readLine();
                    for(int k = 0 ; k < C ; k++){
                        char c = str.charAt(k);
                        building[i][j][k] = c;
                        if(c=='S'){
                            s1 = i;
                            s2 = j;
                            s3 = k;
                        }
                    }
                }
                br.readLine();
            }
            int result = bfs(s1,s2,s3);
            if(result==0){
                sb.append("Trapped!\n");
            }
            else{
                sb.append("Escaped in ").append(result).append(" minute(s).\n");
            }
            s = br.readLine().split(" ");
            L = Integer.parseInt(s[0]);
            R = Integer.parseInt(s[1]);
            C = Integer.parseInt(s[2]);
        }
        System.out.print(sb);
    }

    public static int bfs(int s1, int s2, int s3){
        Node node = new Node(s2,s3,s1,0);
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        visit[s1][s2][s3] = true;
        while (!q.isEmpty()){
            Node now = q.poll();
            int x = now.x;
            int y = now.y;
            int h = now.h;
            if(building[h][x][y]=='E'){
                return now.count;
            }
            for(int i = 0 ; i < 4 ; i++){
                int ddx = dx[i] + x;
                int ddy = dy[i] + y;
                if(ddx >= 0 && ddx < R && ddy>=0 && ddy < C && !visit[h][ddx][ddy] && building[h][ddx][ddy]!='#'){
                    visit[h][ddx][ddy] = true;
                    q.add(new Node(ddx,ddy,h, now.count +1) );
                }
            }
            if(h + 1 < L && !visit[h+1][x][y] && building[h+1][x][y]!='#'){
                visit[h + 1][x][y] = true;
                q.add(new Node(x,y,h + 1, now.count + 1));
            }
            if(h - 1 >= 0 && !visit[h - 1][x][y]&& building[h-1][x][y]!='#'){
                visit[h - 1][x][y] = true;
                q.add(new Node(x,y,h - 1, now.count + 1));
            }
        }
        return 0;
    }

    static class Node{
        int x;
        int y;
        int h;
        int count;
        public Node(int x, int y, int h,int count){
            this.x = x;
            this.y = y;
            this.h = h;
            this.count = count;
        }
    }

}