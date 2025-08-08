import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static int[][] list;
    public static int max;
    public static boolean[] visit;
    public static int N;
    public static int L;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int t = 1 ; t <= T ; t++) {
            String[] s  = br.readLine().split(" ");
            N = Integer.parseInt(s[0]);
            L = Integer.parseInt(s[1]);
            list = new int[N][2];
            for(int i = 0 ; i < N ; i++){
                s  = br.readLine().split(" ");
                list[i][0] = Integer.parseInt(s[0]);
                list[i][1] = Integer.parseInt(s[1]);
            }
            max = Integer.MIN_VALUE;
            visit = new boolean[N];
            search(0);

            sb.append('#').append(t).append(' ').append(max);
            if(t!=T) {
                sb.append('\n');
            }
        }
        System.out.print(sb);
    }

    public static void search(int depth){
        if(depth==N){
            int sum = 0;
            int kal = 0;
            for(int i = 0 ; i < N ; i++){
                if(visit[i]){
                    sum += list[i][0];
                    kal += list[i][1];
                }
            }
            if(kal<=L){
                max = Math.max(max, sum);
            }
            return;
        }
        visit[depth] = true;
        search(depth + 1);
        visit[depth] = false;
        search(depth + 1);
    }
}