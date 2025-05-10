import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


class Main {
    public static class Node{
        int point;
        int cost;

        public Node(int point, int cost){
            this.point = point;
            this.cost = cost;
        }
    }
    static int n;
    static List<List<Node>> list;
    static int max;
    static int point;



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        max = 0;
        list = new ArrayList<>();
        for(int i = 0 ; i < n + 1; i++){
            list.add(new ArrayList<>());
        }
        String[] s;
        for(int i = 0 ; i < n ; i++){
            s = br.readLine().split(" ");
            List<Node> l = list.get(Integer.parseInt(s[0]));
            for(int j = 1 ; j < s.length - 1 ; j+=2){
                l.add(new Node(Integer.parseInt(s[j]),Integer.parseInt(s[j+1])));
            }
        }
        point = 1;
        dfs(1);
        dfs(point);
        System.out.print(max);
    }

    public static void dfs(int start){
        Stack<Node> stack = new Stack<>();
        stack.push(new Node(start,0));
        boolean[] visit = new boolean[n+1];
        visit[start] = true;
        while (!stack.isEmpty()){
            Node now = stack.pop();
            if(max<now.cost){
                point = now.point;
                max = now.cost;
            }
            for(Node next : list.get(now.point)){
                if(!visit[next.point]){
                    visit[now.point] = true;
                    stack.add(new Node(next.point, now.cost + next.cost));
                }
            }
        }
    }
}