import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    static int N;
    static int[] list;
    static int count;
    static int sum = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int t = 1 ; t <= T ; t++) {
            N = Integer.parseInt(br.readLine());
            String[] s = br.readLine().split(" ");
            list = new int[N];
            for(int i = 0 ; i < N ; i++){
                list[i] = Integer.parseInt(s[i]);
                sum += list[i];
            }
            count = 0;

            dfs(0,0,0,new boolean[N]);

            sb.append('#').append(t).append(' ').append(count);
            if(t!=T) {
                sb.append('\n');
            }
        }
        System.out.print(sb);
    }

    public static void dfs(int depth, int left, int right, boolean[] visit){
        if(depth==N){
            count++;
            return;
        }
        for(int i = 0 ; i <N ; i++){
            if(!visit[i]){
                visit[i] = true;
                dfs(depth + 1,left + list[i],right,visit);
                if(left >= right + list[i]){
                    dfs(depth + 1,left,right+list[i],visit);
                }
                visit[i] = false;
            }
        }

    }


}