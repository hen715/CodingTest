import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static class Node{
        int des;
        int cost;
        public Node(int des, int cost){
            this.des = des;
            this.cost = cost;
        }
    }
    static List<List<Node>> list;
    static boolean[] visit;
    static int[] dis;
    static int[] parent;
    static int N;
    static int M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        list = new ArrayList<>();
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        for (int i = 0 ; i <= N ; i++){
            list.add(new ArrayList<>());
        }
        for(int i = 0 ; i < M ; i++){
            s = br.readLine().split(" ");
            list.get(Integer.parseInt(s[0])).add(new Node(Integer.parseInt(s[1]),Integer.parseInt(s[2])));
            list.get(Integer.parseInt(s[1])).add(new Node(Integer.parseInt(s[0]),Integer.parseInt(s[2])));
        }
        parent = new int[N + 1];
        search();
        int max = Integer.MIN_VALUE;
        int index = N;
        while (index!=1){
            int end = index;
            int start = parent[index];
            int cost = 0;
            for(int i = 0 ; i < list.get(end).size() ; i++){
                if(list.get(end).get(i).des==start){
                    cost = list.get(end).get(i).cost;
                    list.get(end).remove(i);
                    break;
                }
            }
            for(int i = 0 ; i < list.get(start).size() ; i++){
                if(list.get(start).get(i).des==end){
                    list.get(start).remove(i);
                    break;
                }
            }
            search2();
            if(dis[N]!=Integer.MAX_VALUE){
                max = Math.max(max,dis[N]);
            }
            list.get(end).add(new Node(start,cost));
            list.get(start).add(new Node(end,cost));
            index = parent[index];
        }
        System.out.print(max);

    }

    public static void search(){
        visit = new boolean[N + 1];
        dis = new int[N + 1];
        for(int i = 1 ; i < N + 1 ; i++){
            dis[i] = Integer.MAX_VALUE;
        }
        PriorityQueue<Node> q = new PriorityQueue<>((o1,o2)->o1.cost - o2.cost);
        q.add(new Node(1, 0));
        visit[1] = true;
        while (!q.isEmpty()){
            Node now = q.poll();
            visit[now.des] = true;
            for(Node next : list.get(now.des)){
                if(!visit[next.des] && next.cost + now.cost < dis[next.des]){
                    dis[next.des] = next.cost + now.cost;
                    q.add(new Node(next.des, dis[next.des]));
                    parent[next.des] = now.des;
                }
            }
        }
    }

    public static void search2(){
        visit = new boolean[N + 1];
        dis = new int[N + 1];
        for(int i = 1 ; i < N + 1 ; i++){
            dis[i] = Integer.MAX_VALUE;
        }
        PriorityQueue<Node> q = new PriorityQueue<>((o1,o2)->o1.cost - o2.cost);
        q.add(new Node(1, 0));
        visit[1] = true;
        while (!q.isEmpty()){
            Node now = q.poll();
            visit[now.des] = true;
            for(Node next : list.get(now.des)){
                if(!visit[next.des] && next.cost + now.cost < dis[next.des]){
                    dis[next.des] = next.cost + now.cost;
                    q.add(new Node(next.des, dis[next.des]));
                }
            }
        }
    }


}