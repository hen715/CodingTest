import java.io.*;
import java.util.ArrayList;
import java.util.List;


class Main {
    public static class Node{
        int start;
        int end;
        int cost;
        public Node(int start, int end, int cost){
            this.start = start;
            this.end = end;
            this.cost = cost;
        }
    }
    static int[] union;

    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       int V = Integer.parseInt(br.readLine());
       int E = Integer.parseInt(br.readLine());
        List<Node> list = new ArrayList<>();
        String[] s;
        for(int i = 0 ; i < E ; i++){
            s = br.readLine().split(" ");
            int start = Integer.parseInt(s[0]);
            int end = Integer.parseInt(s[1]);
            int cost = Integer.parseInt(s[2]);
            list.add(new Node(start,end,cost));
        }
        list.sort((o1, o2) -> o1.cost- o2.cost);
        union = new int[V+1];
        int sum = 0;
        for(int i = 0 ; i < V + 1 ; i++){
            union[i] = i;
        }
        for(int i = 0 ; i < E ; i++){
            Node node = list.get(i);
            if(find(node.start)!=find(node.end)){
                sum += node.cost;
                union[find(node.start)] = union[find(node.end)];
            }
        }
        System.out.print(sum);
    }
    public static int find(int x){
        if(union[x]==x){
            return x;
        }
        return find(union[x]);
    }
}