import java.io.*;
import java.util.*;

class Main {
    static List<List<Integer>> list;
    static boolean[] visit;
    static int[] count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int R = Integer.parseInt(s[1]);
        int Q = Integer.parseInt(s[2]);
        list = new ArrayList<>();
        for(int i = 0 ; i < N + 1 ; i++){
            list.add(new ArrayList<>());
        }
        for(int i = 0 ; i < N - 1 ; i++){
            s = br.readLine().split(" ");
            list.get(Integer.parseInt(s[0])).add(Integer.parseInt(s[1]));
            list.get(Integer.parseInt(s[1])).add(Integer.parseInt(s[0]));
        }
        visit = new boolean[N + 1];
        count = new int[N + 1];
        for(int i = 1 ; i < N +1 ; i++){
            count[i] = 1;
        }
        visit[R] = true;
        dfs(R);


        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < Q ; i++){
            int q = Integer.parseInt(br.readLine());
            sb.append(count[q]).append("\n");
        }
        System.out.print(sb);
    }


    public static void dfs(int now){
        for(int next : list.get(now)){
            if(!visit[next]){
                visit[next] = true;
                dfs(next);
                count[now] += count[next];
            }
        }
    }

}