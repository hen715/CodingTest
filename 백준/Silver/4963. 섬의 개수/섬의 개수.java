import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;


class Main {

    static boolean[][] visited;
    static int[][] island;
    static int[] dx = {1,-1,0,0,1,1,-1,-1};
    static int[] dy = {0,0,1,-1,1,-1,1,-1};
    static int N;
    static int M;




    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        M = Integer.parseInt(s[0]);
        N = Integer.parseInt(s[1]);
        StringBuilder sb = new StringBuilder();
        while (N!=0&&M!=0){
            island = new int[N][M];
            visited = new boolean[N][M];
            int sum = 0 ;
            for(int i = 0 ; i < N ; i++){
                s = br.readLine().split(" ");
                for(int j = 0 ; j < M ; j++){
                    island[i][j] = Integer.parseInt(s[j]);
                }
            }
            for(int i = 0 ; i < N ; i++) {
                for (int j = 0; j < M ; j++) {
                    if (!visited[i][j]&&island[i][j] == 1) {
                        sum++;
                        dfs(i,j);
                    }
                }
            }
            s = br.readLine().split(" ");
            M = Integer.parseInt(s[0]);
            N = Integer.parseInt(s[1]);
            sb.append(sum).append("\n");
        }
        System.out.println(sb);
    }

    static void dfs(int i, int j){
        Stack<Node> stack = new Stack<>();
        stack.push(new Node(i,j));
        while(!stack.isEmpty()){
            Node node = stack.pop();
            visited[node.i][node.j] = true;
            for(int a = 0 ; a < 8 ; a++){
                if(node.i+dx[a]< N &&node.i + dx[a]>=0&&node.j+dy[a]>=0 && node.j+dy[a]<M){
                    if(!visited[node.i+dx[a]][node.j+dy[a]]&&island[node.i+dx[a]][node.j+dy[a]]==1){
                        stack.push(new Node(node.i+dx[a],node.j+dy[a]));
                    }
                }
            }
        }
    }

    static class Node{
        int i;
        int j;
        Node(int i, int j){
            this.i = i;
            this.j = j;
        }
    }
}