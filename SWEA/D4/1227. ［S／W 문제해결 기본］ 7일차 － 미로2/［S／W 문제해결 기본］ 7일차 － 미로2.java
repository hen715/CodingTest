import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static class Node{
        int x;
        int y;
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for(int T = 1 ; T <= 10 ; T++){
            br.readLine();
            int[][] list = new int[100][100];
            String s;
            int startX = 0;
            int startY = 0;
            int endX = 0;
            int endY = 0;
            for(int i = 0 ; i < 100 ; i++){
                s = br.readLine();
                for(int j = 0 ; j < 100 ; j++){
                    list[i][j] = s.charAt(j)-'0';
                    if(list[i][j]==2){
                        startX = i;
                        startY = j;
                    }
                    if(list[i][j]==3){
                        endX = i;
                        endY = j;
                    }
                }
            }
            Queue<Node> q = new LinkedList<>();
            boolean[][] visit = new boolean[100][100];
            q.add(new Node(startX, startY));
            while (!q.isEmpty()){
                Node now = q.poll();
                for(int i = 0 ; i < 4; i++){
                    int ddx = now.x + dx[i];
                    int ddy = now.y + dy[i];
                    if(ddx>=0&&ddx<100&&ddy>=0&&ddy<100&&!visit[ddx][ddy]&&list[ddx][ddy]!=1){
                        visit[ddx][ddy] = true;
                        q.add(new Node(ddx, ddy));
                    }
                }
            }
            sb.append('#').append(T).append(' ');
            if(visit[endX][endY]){
                sb.append(1);
            }
            else {
                sb.append(0);
            }
            if(T!=10){
                sb.append('\n');
            }
        }
        System.out.print(sb);
    }
}
