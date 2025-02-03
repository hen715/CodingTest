import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;


class Main {
    static boolean[] visited;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int K = Integer.parseInt(s[1]);
        visited = new boolean[100001];
        System.out.println(bfs(N,K));
    }

    static int bfs(int n, int k){
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(n,0));
        while (!q.isEmpty()){
            Node node = q.poll();
            if(node.now == k){
                return node.time;
            }
            if(!visited[node.now]){
                visited[node.now] = true;
                if(node.now * 2 <=100000){
                    q.add(new Node(node.now * 2, node.time));   
                }
                if(node.now>0){
                    q.add(new Node(node.now - 1, node.time + 1));
                }
                if(node.now<100000){
                    q.add(new Node(node.now + 1, node.time + 1));
                }
            }
        }
        return -1;
    }

    static class Node{
        int now;
        int time;
        public Node(int now, int time){
            this.now = now;
            this.time = time;
        }
    }
}