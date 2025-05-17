import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int a = 0 ; a < T ; a++){
            String[] s = br.readLine().split(" ");
            int N = Integer.parseInt(s[0]);
            int K = Integer.parseInt(s[1]);
            int[] time = new int[N + 1];
            s = br.readLine().split(" ");
            List<List<Integer>> list = new ArrayList<>();
            for(int i = 0 ; i < N + 1 ; i++){
                list.add(new ArrayList<>());
            }
            for(int i = 1 ; i < N + 1; i++){
                time[i] = Integer.parseInt(s[i-1]);
            }
            Queue<Integer> queue = new LinkedList<>();
            int[] indegree = new int[N + 1];
            for(int i = 0 ; i < K ; i++){
                s = br.readLine().split(" ");
                list.get(Integer.parseInt(s[0])).add(Integer.parseInt(s[1]));
                indegree[Integer.parseInt(s[1])]++;
            }
            int[] dp = new int[N + 1];
            int W = Integer.parseInt(br.readLine());
            for(int i = 1 ; i < N + 1 ; i++){
                dp[i] = time[i];
                if(indegree[i]==0){
                    queue.add(i);
                }
            }
            while (!queue.isEmpty()){
                int now = queue.poll();
                for(int next : list.get(now)){
                    dp[next] = Math.max(dp[next],dp[now] + time[next]);
                    indegree[next]--;
                    if(indegree[next]==0){
                        queue.add(next);
                    }
                }
            }
            sb.append(dp[W]).append('\n');
        }
        System.out.print(sb);
    }

}