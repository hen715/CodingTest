import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        long N = Integer.parseInt(s[0]);
        long M = Integer.parseInt(s[1]);
        System.out.println(bfs(N,M));

    }

    public static long bfs(long n,long target){
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(n,0));
        while (!q.isEmpty()){
            Node node = q.poll();
            if(node.now == target){
                return node.cnt + 1;
            }
            if(node.now < target) {
                q.add(new Node(node.now * 2, node.cnt + 1));
                q.add(new Node(node.now * 10 + 1, node.cnt + 1));
            }
        }
        return -1;
    }

    static class Node{
        long now;
        long cnt;
        public Node (long now, long cnt){
            this.now = now;
            this.cnt = cnt;
        }
    }


}