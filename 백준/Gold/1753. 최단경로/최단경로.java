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
        String[] s = br.readLine().split(" ");
        int V = Integer.parseInt(s[0]);
        int E = Integer.parseInt(s[1]);
        int start = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<Node>> list = new ArrayList<>();
        int[] distant = new int[V + 1];
        PriorityQueue<Node> q = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        for(int i = 0 ; i < V +1 ; i++){
            distant[i] = Integer.MAX_VALUE;
            list.add(new ArrayList<>());
        }
        distant[start] = 0;
        for(int i = 0 ; i < E ; i++){
            s = br.readLine().split(" ");
            list.get(Integer.parseInt(s[0])).add(new Node(Integer.parseInt(s[1]),Integer.parseInt(s[2])));
        }
        q.add(new Node(start,0));

        while (!q.isEmpty()){
            Node cur = q.poll();
            if(distant[cur.index]< cur.cost){
                continue;
            }
            ArrayList<Node> nodes = list.get(cur.index);
            for(Node node : nodes){
                    if (distant[node.index] > node.cost + cur.cost) {
                        distant[node.index] = node.cost + cur.cost;
                        q.add(new Node(node.index, distant[node.index]));
                    }

            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 1 ; i < V + 1 ; i++){
            if(distant[i]==Integer.MAX_VALUE){
                sb.append("INF");
            }
            else {
                sb.append(distant[i]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}