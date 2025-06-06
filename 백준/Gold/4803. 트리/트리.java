import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class Main {
    static List<List<Integer>> tree;
    static boolean[] visit;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        int count;
        int c = 0;
        while (!(n==0&&m==0)){
            c++;
            tree = new ArrayList<>();
            for(int i = 0 ; i < n + 1 ; i++){
                tree.add(new ArrayList<>());
            }
            visit = new boolean[n + 1];
            for(int i = 0 ; i < m ; i++){
                s = br.readLine().split(" ");
                tree.get(Integer.parseInt(s[0])).add(Integer.parseInt(s[1]));
                tree.get(Integer.parseInt(s[1])).add(Integer.parseInt(s[0]));
            }
            count = 0;
            for(int i = 1 ; i < n + 1 ; i++){
                if(!visit[i]){
                    if(!searchTree(i)){
                        count++;
                    }
                }
            }
            sb.append("Case ").append(c).append(": ");
            if(count==0){
                sb.append("No trees.");
            }
            else if(count==1){
                sb.append("There is one tree.");
            }
            else{
                sb.append("A forest of ").append(count).append(" trees.");
            }
            sb.append('\n');
            s = br.readLine().split(" ");
            n = Integer.parseInt(s[0]);
            m = Integer.parseInt(s[1]);
        }
        System.out.print(sb);
    }
    static class Node{
        int now;
        int prev;
        public Node(int now, int prev){
            this.now = now;
            this.prev = prev;
        }
    }

    public static boolean searchTree(int index){
        Stack<Node> stack = new Stack<>();
        visit[index] = true;
        boolean isCycle = false;
        stack.add(new Node(index,0));
        while (!stack.isEmpty()){;
            Node now = stack.pop();
            for(int i : tree.get(now.now)){
                if(i==now.prev){
                    continue;
                }
                else if(visit[i]){
                    isCycle = true;
                }
                else {
                    visit[i] = true;
                    stack.push(new Node(i, now.now));
                }
            }
        }
        return isCycle;
    }
}