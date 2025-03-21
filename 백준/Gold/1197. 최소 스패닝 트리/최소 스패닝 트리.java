import java.io.*;
import java.util.ArrayList;
import java.util.PriorityQueue;


class Main {
    public static class Node{
        int point;
        int cost;
        public Node(int point,int cost){
            this.point = point;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       String[] s = br.readLine().split(" ");
       int V = Integer.parseInt(s[0]);
       int E = Integer.parseInt(s[1]);
       StringBuilder sb = new StringBuilder();
        ArrayList<ArrayList<Node>> list = new ArrayList<>();
        for(int i = 0 ; i < V +1 ; i++){
            list.add(new ArrayList<>());
        }
        for(int i = 0 ; i < E ; i++){
            s = br.readLine().split(" ");
            int start = Integer.parseInt(s[0]);
            int end = Integer.parseInt(s[1]);
            int cost = Integer.parseInt(s[2]);
            list.get(start).add(new Node(end,cost));
            list.get(end).add(new Node(start,cost));
        }
        boolean[] visit = new boolean[V+1];
        PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2)->o1.cost-o2.cost);
        int sum = 0;
        pq.add(new Node(1,0));
        while(!pq.isEmpty()){
            Node node = pq.poll();
            if(visit[node.point]){
                continue;
            }
            visit[node.point] = true;
            sum += node.cost;
            for(Node next : list.get(node.point)){
                if(!visit[next.point]) {
                    pq.add(next);
                }
            }
        }
        System.out.print(sum);
    }
}



