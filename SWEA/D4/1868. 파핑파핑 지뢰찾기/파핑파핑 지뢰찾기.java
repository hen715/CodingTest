import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

class Solution
{
    static class Node{
        int x;
        int y;
        Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static int N;
    static char[][] list;
    static boolean[][] visit;
    static int[][] count;
    static int[] dx = {1,-1,0,0,1,1,-1,-1};
    static int[] dy = {0,0,1,-1,1,-1,1,-1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int tc = 1 ; tc <= T ; tc++){
            N = Integer.parseInt(br.readLine());
            list = new char[N][N];
            visit = new boolean[N][N];
            count = new int[N][N];
            String str;
            for(int i = 0 ; i < N ; i++){
                str = br.readLine();
                for(int j = 0 ; j < N ; j++){
                    list[i][j] = str.charAt(j);
                }
            }
            init();
            int c = 0;
            for(int i = 0 ; i < N ; i++){
                for(int j = 0 ; j < N ; j++){
                    if(count[i][j]==0&&!visit[i][j]){
                        c++;
                        search(i,j);
                    }
                }
            }
            for(int i = 0 ; i < N ; i++){
                for(int j = 0 ; j < N ; j++){
                    if(count[i][j]!=0&&count[i][j]!=-1&&!visit[i][j]){
                        c++;
                    }
                }
            }
            sb.append('#').append(tc).append(' ').append(c).append('\n');
        }
        System.out.print(sb);
    }

    static void search(int x, int y){
        Queue<Node> q = new ArrayDeque<>();
        q.add(new Node(x,y));
        visit[x][y] = true;
        while (!q.isEmpty()){
            Node now = q.poll();
            for(int a = 0 ; a < 8 ; a++){
                int ddx = now.x + dx[a];
                int ddy = now.y + dy[a];
                if(ddx>=0&&ddx<N&&ddy>=0&&ddy<N&&count[ddx][ddy]==0&&!visit[ddx][ddy]){
                    visit[ddx][ddy] = true;
                    q.add(new Node(ddx,ddy));
                }
                else if(ddx>=0&&ddx<N&&ddy>=0&&ddy<N&&count[ddx][ddy]!=0&&!visit[ddx][ddy]){
                    visit[ddx][ddy] = true;
                }
            }
        }
    }

    static void init(){
        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < N ; j++){
                if(list[i][j]=='*'){
                    count[i][j] = -1;
                    for(int a = 0 ; a < 8 ; a++){
                        int ddx = i + dx[a];
                        int ddy = j + dy[a];
                        if(ddx>=0&&ddx<N&&ddy>=0&&ddy<N&&list[ddx][ddy]=='.'){
                            count[ddx][ddy]++;
                        }
                    }
                }
            }
        }
    }
}