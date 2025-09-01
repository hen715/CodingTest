import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    static int[][] list;
    static int N = 4;
    static Set<String> set;
    public static class Node{
        int x;
        int y;
        int[] l;
        int count;
        Node(int x, int y,int[] l ,int count){
            this.x = x;
            this.y = y;
            this.l = l;
            this.l[count] = list[x][y];
            this.count = count;
        }
    }
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static StringBuilder innerSb;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        innerSb = new StringBuilder();
        for(int tc = 1 ; tc <= T ; tc++){
            list = new int[N][N];
            String[] s;
            set = new HashSet<>();
            for(int i = 0 ; i < N ; i++){
                s = br.readLine().split(" ");
                for(int j = 0 ; j < N ; j++){
                    list[i][j] = Integer.parseInt(s[j]);
                }
            }

            for(int i = 0 ; i < N ; i++){
                for(int j = 0 ; j < N ; j++){
                    search(i,j);
                }
            }
            sb.append('#').append(tc).append(' ').append(set.size()).append('\n');
        }
        System.out.print(sb);
    }

    public static void search(int x, int y){
        Queue<Node> q = new ArrayDeque<>();
        q.add(new Node(x,y,new int[1],0));
        while (!q.isEmpty()){
            Node now = q.poll();
            if(now.count==6){
                //System.out.println(now.str);
                //System.out.println(now.l.length);
                innerSb.setLength(0);
                for(int i : now.l){
                    innerSb.append(i);
                }
                set.add(innerSb.toString());
                continue;
            }

            for(int i = 0 ; i < 4 ; i++){
                int ddx = now.x + dx[i];
                int ddy = now.y + dy[i];
                if(ddx>=0&&ddx<N&&ddy>=0&&ddy<N){
                    int[] l = new int[now.l.length+1];
                    System.arraycopy(now.l,0,l,0,now.l.length);
                    q.add(new Node(ddx,ddy, l, now.count+1));
                }
            }
        }
    }
}