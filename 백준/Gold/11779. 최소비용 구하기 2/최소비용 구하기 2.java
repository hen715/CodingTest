import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;


class Main {
    public static class Node{
        int cur;
        int cost;
        public Node(int cur,int cost){
            this.cur = cur;
            this.cost = cost;
        }
    }



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        List<List<Node>> list = new ArrayList<>();
        for(int i = 0 ; i < n +1 ; i++){
            list.add(new ArrayList<>());
        }
        String[] s;
        for(int i = 0 ; i < m ; i++){
            s = br.readLine().split(" ");
            list.get(Integer.parseInt(s[0])).add(new Node(Integer.parseInt(s[1]),Integer.parseInt(s[2])));
        }
        int[] pre = new int[n + 1];
        int[] dis = new int[n + 1];
        for(int i = 1 ; i < n + 1 ; i++){
            dis[i] = 1000000000;
        }
        s = br.readLine().split(" ");
        int start = Integer.parseInt(s[0]);
        int end = Integer.parseInt(s[1]);
        dis[start] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2)->{return o1.cost- o2.cost;});
        pq.add(new Node(start,0));
        while (!pq.isEmpty()){
            Node now = pq.poll();
            if(now.cur == end){
                break;
            }
            for(Node next : list.get(now.cur)){
                if(dis[next.cur] > dis[now.cur] + next.cost){
                    dis[next.cur] = dis[now.cur] + next.cost;
                    pre[next.cur] = now.cur;
                    pq.add(new Node(next.cur, dis[now.cur] + next.cost));
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(dis[end]).append("\n");
        List<Integer> route = new ArrayList<>();
        int index = end;
        while (index!=0){
            route.add(index);
            index = pre[index];
        }
        sb.append(route.size()).append("\n");
        for(int i = route.size() -1 ; i >=0 ; i--){
            sb.append(route.get(i)).append(" ");
        }
        System.out.print(sb);
    }

}