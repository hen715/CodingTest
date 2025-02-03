import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;


class Main {
    static class Node{
        int index;
        int cost;
        public Node(int index, int cost){
            this.index = index;
            this.cost = cost;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<Node>> list = new ArrayList<>();
        int[] distant = new int[N + 1];
        PriorityQueue<Node> q = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        for(int i = 0 ; i < N +1 ; i++){
            distant[i] = Integer.MAX_VALUE;
            list.add(new ArrayList<>());
        }

        String[] s;
        for(int i = 0 ; i < M ; i++){
            s = br.readLine().split(" ");
            list.get(Integer.parseInt(s[0])).add(new Node(Integer.parseInt(s[1]),Integer.parseInt(s[2])));
        }
        s = br.readLine().split(" ");
        int start = Integer.parseInt(s[0]);
        int end = Integer.parseInt(s[1]);
        distant[start] = 0;
        boolean[] visited = new boolean[N + 1];
        q.add(new Node(start,0));
        while (!q.isEmpty()) {
            Node cur = q.poll();
            if(cur.index==end){
                break;
            }
            if (!visited[cur.index]) {
                visited[cur.index] = true;
                ArrayList<Node> nodes = list.get(cur.index);
                for (Node node : nodes) {
                    if (distant[node.index] > node.cost + cur.cost) {
                        distant[node.index] = node.cost + cur.cost;
                        q.add(new Node(node.index, distant[node.index]));
                    }
                }
            }
        }
        System.out.println(distant[end]);
    }
}