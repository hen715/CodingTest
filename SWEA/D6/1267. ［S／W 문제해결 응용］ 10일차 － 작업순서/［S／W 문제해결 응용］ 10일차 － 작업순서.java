import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = 10;
        StringBuilder sb = new StringBuilder();
        for(int t = 1 ; t <= T ; t++) {
            String[] s = br.readLine().split(" ");
            int V = Integer.parseInt(s[0]);
            int E =Integer.parseInt(s[1]);
            List<List<Integer>> list = new ArrayList<>();
            for(int i = 0 ; i <= V ; i++){
                list.add(new ArrayList<>());
            }
            int[] indegree = new int[V + 1];
            s = br.readLine().split(" ");
            for(int i = 0 ; i < E * 2; i += 2){
                list.get(Integer.parseInt(s[i])).add(Integer.parseInt(s[i+1]));
                indegree[Integer.parseInt(s[i+1])]++;
            }
            sb.append('#').append(t).append(' ');
            Queue<Integer> q = new ArrayDeque<>();
            for(int i = 1 ; i <= V ; i++){
                if(indegree[i]==0){
                    q.add(i);
                    sb.append(i).append(' ');
                }
            }

            while (!q.isEmpty()){
                int now = q.poll();
                for(int next : list.get(now)){
                    indegree[next]--;
                    if(indegree[next]==0){
                        q.add(next);
                        sb.append(next).append(' ');
                    }
                }
            }
            sb.append('\n');


        }
        System.out.print(sb);
    }
    
}