import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Main {
    static int N;
    static int M;
    static List<List<Node>> route;

    public static class Node{
        int des;
        int cost;
        public Node(int des,int cost){
            this.des = des;
            this.cost = cost;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        int X = Integer.parseInt(s[2]);
        int max = 0;
        route = new ArrayList<>();
        for(int i = 0 ; i < N + 1 ; i++){
            route.add(new ArrayList<>());
        }
        for(int i = 0 ; i < M ; i++){
            s = br.readLine().split(" ");
            route.get(Integer.parseInt(s[0])).add(new Node(Integer.parseInt(s[1]),Integer.parseInt(s[2])));
        }
        for(int i = 1 ; i < N + 1 ; i++){
            int dis1 = getDis(i,X);
            int dis2 = getDis(X,i);
            max = Math.max(max,dis1+dis2);
        }
        System.out.print(max);
    }


    public static int getDis(int start, int end){
        PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2)->{return o1.cost-o2.cost;});
        int[] dis = new int[N + 1];
        for(int i = 1 ; i < N+1 ; i++){
            dis[i] = Integer.MAX_VALUE;
        }
        dis[start] = 0;
        boolean[] visit = new boolean[N + 1];
        pq.add(new Node(start,0));
        while (!pq.isEmpty()){
            Node now = pq.poll();
            visit[now.des] = true;
            for(Node node:route.get(now.des)){
                if(!visit[node.des] && dis[node.des] > dis[now.des] + node.cost) {
                    dis[node.des] = dis[now.des] + node.cost;
                    pq.add(new Node(node.des, node.cost + now.cost));
                }
            }
        }
        return dis[end];
    }
}