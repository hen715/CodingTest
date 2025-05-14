import java.io.*;
import java.util.*;

class Main {
    static class Node{
        int home;
        int cost;
        public Node(int home, int cost){
            this.home = home;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);
        List<List<Node>> list = new ArrayList<>();
        for(int i = 0 ; i < N + 1 ;i++){
            list.add(new ArrayList<>());
        }
        for(int i = 0 ; i < M ; i++){
            s = br.readLine().split(" ");
            list.get(Integer.parseInt(s[0])).add(new Node(Integer.parseInt(s[1]),Integer.parseInt(s[2])));
            list.get(Integer.parseInt(s[1])).add(new Node(Integer.parseInt(s[0]),Integer.parseInt(s[2])));
        }
        boolean[] visit = new boolean[N + 1];
        PriorityQueue<Node> q = new PriorityQueue<>((o1,o2)->{return o1.cost-o2.cost;});
        q.add(new Node(1,0));
        int max = 0;
        int sum = 0;
        while (!q.isEmpty()){
            Node now = q.poll();
            if(visit[now.home]){
                continue;
            }
            visit[now.home] = true;
            sum += now.cost;
            if(now.cost>max){
                max = now.cost;
            }
            for(Node next : list.get(now.home)){
                if(!visit[next.home]){
                    q.add(next);
                }
            }
        }
        System.out.println(sum - max);
    }
}