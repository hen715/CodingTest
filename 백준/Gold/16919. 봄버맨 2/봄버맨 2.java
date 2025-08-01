import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int R;
    static int C;
    static int N;
    static int[][] list;
    static class Node{
        int x;
        int y;
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        R = Integer.parseInt(s[0]);
        C = Integer.parseInt(s[1]);
        N = Integer.parseInt(s[2]);
        list = new int[R][C];
        String str;
        for(int i = 0 ; i < R ; i++){
            str = br.readLine();
            for(int j = 0 ; j < C ; j++){
                if(str.charAt(j)=='.'){
                    list[i][j] = 0;
                }
                else{
                    list[i][j] = 2;
                }
            }
        }

        if(N==2){
            boom();
        }
        else if (N>2) {
            boom();
            N -= 2;
            for (int i = 0; i < N % 4; i++) {
                boom();
            }
        }
        printList();
    }

    public static void boom(){
        Queue<Node> q = new LinkedList<>();
        for(int i = 0 ; i < R ; i++){
            for(int j = 0 ; j < C ; j++){
                list[i][j]++;
                if(list[i][j]==4){
                    q.add(new Node(i,j));
                }
            }
        }
        while (!q.isEmpty()){
            Node now = q.poll();
            list[now.x][now.y] = 0;
            for(int i = 0 ; i < 4 ; i++){
                int x = now.x + dx[i];
                int y = now.y + dy[i];
                if(x>=0&&x<R&&y>=0&&y<C){
                    list[x][y] = 0;
                }
            }
        }
    }

    public static void printList(){
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < R ; i++){
            for(int j = 0 ; j < C ; j++){
                if(list[i][j]==0){
                    sb.append('.');
                }
                else{
                    sb.append('O');
                }
                //sb.append(list[i][j]).append(' ');
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }
}