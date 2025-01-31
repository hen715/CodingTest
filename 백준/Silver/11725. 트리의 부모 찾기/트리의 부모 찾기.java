import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class Main {
    static ArrayList<ArrayList<Integer>> tree;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        tree = new ArrayList<>();
        parent = new int[N+1];
        for(int i = 0 ; i < N+1 ; i++){
            tree.add(new ArrayList<Integer>());
        }
        for(int i = 0 ; i < N-1 ; i++){
            String[] s = br.readLine().split(" ");
            int node1 = Integer.parseInt(s[0]);
            int node2 = Integer.parseInt(s[1]);
            tree.get(node1).add(node2);
            tree.get(node2).add(node1);
        }
        dfs();

        for(int i = 2; i< N+1 ; i++){
            sb.append(parent[i]).append("\n");
        }

        System.out.print(sb);
    }

    public static void dfs(){
        Stack<Node> stack = new Stack<>();
        stack.push(new Node(1,1));
        while(!stack.isEmpty()){
            Node node = stack.pop();
            ArrayList<Integer> array = tree.get(node.now);
            parent[node.now] = node.before;
            for(int num : array){
                if(num == node.before) continue;
                stack.push(new Node(num, node.now));
            }
        }
    }

    static class Node{
        int now;
        int before;
        public Node(int now, int before){
            this.now = now;
            this.before = before;
        }
    }

}