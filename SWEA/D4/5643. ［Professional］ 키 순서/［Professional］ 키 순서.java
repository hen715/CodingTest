import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    static int N;
    static int M;
    static int count;
    static int c;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int t = 1 ; t <= T ; t++) {
            N = Integer.parseInt(br.readLine());
            M = Integer.parseInt(br.readLine());
            count = 0;
            int[][] list = new int[N+1][N+1];
            int[][] list2 = new int[N+1][N+1];
            String[] s;
            for(int i = 0 ; i < M  ;i++){
                s = br.readLine().split(" ");
                list[Integer.parseInt(s[0])][Integer.parseInt(s[1])] = 1;
                list2[Integer.parseInt(s[1])][Integer.parseInt(s[0])] = 1;
            }
            for(int i = 1 ; i <= N ; i++){
                c = 0;
                boolean[] visit = new boolean[N + 1];
                dfs(i,list,visit);
                visit = new boolean[N + 1];
                dfs(i,list2,visit);
                if(c==N-1){
                    count++;
                }
            }

            sb.append('#').append(t).append(' ').append(count);
            if(t!=T) {
                sb.append('\n');
            }
        }
        System.out.print(sb);
    }

    static void dfs(int num, int[][] list ,boolean[] visit){
        visit[num] = true;
        for(int i = 1 ; i <= N ; i++){
            if(list[num][i]==1&&!visit[i]){
                c++;
                dfs(i,list,visit);
            }
        }
    }

}