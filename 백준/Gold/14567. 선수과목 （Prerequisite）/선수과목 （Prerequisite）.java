import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static class Node{
        int prev;
        int now;
        public Node(int prev, int now){
            this.prev = prev;
            this.now = now;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);
        int[] indegree = new int[N + 1];
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0 ; i  <= N ; i++){
            list.add(new ArrayList<>());
        }
        for(int i = 0 ; i < M ; i++){
            s = br.readLine().split(" ");
            indegree[Integer.parseInt(s[1])]++;
            list.get(Integer.parseInt(s[0])).add(Integer.parseInt(s[1]));
        }
        Queue<Node> q = new LinkedList<>();
        for(int i = 1 ; i <= N ; i++){
            if(indegree[i]==0){
                q.add(new Node(0,i));
            }
        }
        int[] count = new int[N + 1];
        while (!q.isEmpty()){
            Node now = q.poll();
            count[now.now] = count[now.prev] + 1;
            for(int next : list.get(now.now)){
                indegree[next]--;
                if(indegree[next]==0){
                    q.add(new Node(now.now,next));
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 1 ; i <= N ; i++){
            sb.append(count[i]).append(' ');
        }
        System.out.print(sb);

    }
}