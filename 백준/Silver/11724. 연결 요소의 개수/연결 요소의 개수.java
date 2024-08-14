import java.io.*;
import java.util.Stack;

class Main {
    static int n;
    static int m;
    static int[][] list;
    static int[] visited;
    static int count = 0;

    public static void dfs(int node){
        Stack<Integer> stack = new Stack<>();
        stack.push(node);
        while (!stack.empty()){
            node = stack.pop();
            visited[node] = 1;
            for(int i = 1 ; i < n+1 ; i++){
                if(visited[i]==0&&list[node][i]==1){
                    stack.push(i);
                }
            }
        }
        count++;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        list = new int[n+1][n+1];
        visited = new int[n+1];
        for(int i = 0 ; i < m ; i++){
            s = br.readLine().split(" ");
            list[Integer.parseInt(s[0])][Integer.parseInt(s[1])] =1;
            list[Integer.parseInt(s[1])][Integer.parseInt(s[0])] =1;
        }
        for(int i = 1 ; i < n+1 ; i++){
            if(visited[i]==0) {
                dfs(i);
            }
        }
        System.out.println(count);
    }
}