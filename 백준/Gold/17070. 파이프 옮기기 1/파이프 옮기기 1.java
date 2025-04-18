import java.io.*;
import java.util.Stack;


class Main {
    public static class Node{
        int x;
        int y;
        int status;
        public Node(int x,int y, int status){
            this.x = x;
            this.y = y;
            this.status = status;
        }
    }
    static int count = 0;
    static int N;
    static int[][] list;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        list = new int[N][N];
        String[] s;
        for(int i = 0 ; i < N ; i++){
            s = br.readLine().split(" ");
           for(int j = 0 ; j < N ; j++){
               list[i][j] = Integer.parseInt(s[j]);
           }
        }
        dfs();
        System.out.println(count);
    }
    public static void dfs(){
        Node node = new Node(0,1,1);
        Stack<Node> stack = new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()){
            Node now = stack.pop();
            if(now.x == N - 1 && now.y == N - 1){
                count++;
                continue;
            }
            if(now.status==1){
                if(now.y + 1 < N && list[now.x][now.y+1]==0){
                    stack.push(new Node(now.x, now.y +1,1));
                }
            }
            else if(now.status==2){
                if(now.y + 1 <N&&list[now.x][now.y+1]==0){
                    stack.push(new Node(now.x, now.y +1,1));
                }
                if(now.x + 1 <N&&list[now.x+1][now.y]==0){
                    stack.push(new Node(now.x+1, now.y,3));
                }
            }
            else if(now.status==3){
                if(now.x +1 < N &&  list[now.x+1][now.y]==0 ){
                    stack.push(new Node(now.x+1, now.y,3));
                }
            }
            if(now.x +1 < N && now.y + 1 <N && list[now.x+1][now.y]==0 && list[now.x][now.y+1]==0&&list[now.x+1][now.y+1]==0){
                stack.push(new Node(now.x+1, now.y +1,2));
            }
        }
    }
}