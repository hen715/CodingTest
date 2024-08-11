import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Main {
    static int[][] graph;
    static int n;
    static int m;
    static int start;
    static int[] visited;
    static StringBuilder sb;
    public static void dfs(){
        Stack<Integer> stack = new Stack<>();
        stack.push(start);
        while(!stack.empty()){
            int node = stack.pop();
            if(visited[node]==0){
                visited[node] = 1;
                sb.append(node+" ");
                for(int i = n; i >0 ; i--){
                    if(graph[node][i]==1){
                        stack.push(i);
                    }
                }
            }
        }
        System.out.println(sb);
        sb.setLength(0);
    }

    public static void bfs(){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        while (!queue.isEmpty()){
            int node = queue.poll();
            if(visited[node]==0){
                visited[node] = 1;
                sb.append(node+" ");
                for(int i = 1 ; i < n+1;i++){
                    if(graph[node][i]==1){
                        queue.add(i);
                    }
                }
            }
        }
        System.out.println(sb);
    }


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        start = Integer.parseInt(s[2]);
        graph = new int[n+1][n+1];
        visited = new int[n+1];
        sb = new StringBuilder();
        for(int i = 0 ; i < m ; i++){
            s = br.readLine().split(" ");
            graph[Integer.parseInt(s[0])][Integer.parseInt(s[1])] = 1;
            graph[Integer.parseInt(s[1])][Integer.parseInt(s[0])] = 1;
        }
        dfs();
        visited = new int[n+1];
        bfs();
    }
}