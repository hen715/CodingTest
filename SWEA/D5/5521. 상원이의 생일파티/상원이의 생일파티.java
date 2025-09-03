import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    static class Node{
        int num;
        int count;
        public Node(int num, int count){
            this.num = num;
            this.count = count;
        }
    }
    static List<List<Integer>> list;
    static boolean[] visit;
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int t = 1 ; t <= T ; t++) {
            String[] s = br.readLine().split(" ");
            int N = Integer.parseInt(s[0]);
            int M = Integer.parseInt(s[1]);
            list = new ArrayList<>();
            count = 0;
            for(int i = 0 ; i <= N ; i++){
                list.add(new ArrayList<>());
            }
            for(int i = 0 ; i < M ; i++){
                s = br.readLine().split(" ");
                list.get(Integer.parseInt(s[0])).add(Integer.parseInt(s[1]));
                list.get(Integer.parseInt(s[1])).add(Integer.parseInt(s[0]));
            }
            visit = new boolean[N + 1];
            bfs(1);

            sb.append('#').append(t).append(' ').append(count);
            if(t!=T) {
                sb.append('\n');
            }
        }
        System.out.print(sb);

    }

    public static void bfs(int num){
        ArrayDeque<Node> q = new ArrayDeque<>();
        visit[num] = true;
        q.offer(new Node(num, 0));
        while (!q.isEmpty()){
            Node now = q.poll();
            if(now.count==1){
                count++;
            }
            else if(now.count==2){
                count++;
                continue;
            }
            for(int i : list.get(now.num)){
                if(!visit[i]){
                    visit[i] = true;
                    q.offer(new Node(i, now.count + 1));
                }
            }
        }
    }

}