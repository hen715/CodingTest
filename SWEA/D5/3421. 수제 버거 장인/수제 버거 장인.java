import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Solution {
    public static int[][] list;
    public static boolean[] visit;
    public static int N;
    public static int M;
    public static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int t = 1 ; t <= T ; t++) {
            String[] s  = br.readLine().split(" ");
            N = Integer.parseInt(s[0]);
            M = Integer.parseInt(s[1]);
            list = new int[M][2];
            count = 0;
            for(int i = 0 ; i < M ; i++){
                s  = br.readLine().split(" ");
                list[i][0] = Integer.parseInt(s[0]);
                list[i][1] = Integer.parseInt(s[1]);
            }
            visit = new boolean[N + 1];
            search(1);
            sb.append('#').append(t).append(' ').append(count);
            if(t!=T) {
                sb.append('\n');
            }
        }
        System.out.print(sb);
    }

    public static void search(int depth){
        for(int i = 0 ; i  < M ; i++){
            int num1 = list[i][0];
            int num2 = list[i][1];
            if(visit[num1]&&visit[num2]){
                return;
            }
        }
        if(depth == N + 1){
            count++;
            return;
        }
        visit[depth] = true;
        search(depth + 1);
        visit[depth] = false;
        search(depth + 1);
    }
}