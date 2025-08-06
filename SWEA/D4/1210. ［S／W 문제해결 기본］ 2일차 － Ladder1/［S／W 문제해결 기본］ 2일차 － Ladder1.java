import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;


public class Solution {
    static class Node{
        int x;
        int y;
        public Node(int x,int y){
            this.x = x;
            this.y = y;
        }
    }
    static int[][] list;
    static boolean[][] visit;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = 10;
        for(int tc = 1 ; tc <= T ; tc++){
            br.readLine();
            list = new int[100][100];
            visit = new boolean[100][100];
            String[] s;
            for(int i = 0 ; i < 100 ; i++){
                s = br.readLine().split(" ");
                for(int j = 0 ; j < 100 ; j++){
                    list[i][j] = Integer.parseInt(s[j]);
                }
            }
            int index = -1;
            for(int i = 0 ; i < 100 ; i++){
                if(list[99][i]==2){
                    index = i;
                }
            }
            sb.append('#').append(tc).append(' ').append(search(index));
            if(tc!=T){
                sb.append('\n');
            }
        }
        System.out.print(sb);
    }

    public static int search(int y){
        ArrayDeque<Node> q = new ArrayDeque<>();
        q.offerFirst(new Node(99,y));
        visit[99][y] = true;
        while (!q.isEmpty()){
            Node now = q.poll();
            if(now.y - 1 >=0 && !visit[now.x][now.y-1]&&list[now.x][now.y-1]==1){
                visit[now.x][now.y - 1] = true;
                q.offerFirst(new Node(now.x, now.y - 1));
            }
            else if(now.y + 1 <100 && !visit[now.x][now.y + 1]&&list[now.x][now.y + 1]==1){
                visit[now.x][now.y + 1] = true;
                q.offerFirst(new Node(now.x, now.y + 1));
            }
            else if(now.x - 1 >=0 && !visit[now.x - 1][now.y] && list[now.x - 1][now.y]==1){
                visit[now.x - 1][now.y] = true;
                q.offerFirst(new Node(now.x - 1, now.y));
            }
        }
        for(int i = 0 ; i < 100 ; i++){
            if(visit[0][i]){
                return i;
            }
        }
        return 0;
    }

}