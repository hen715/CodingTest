import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    static int N;
    static int B;
    static int[] list;
    static int min;
    static boolean[] selected;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 1; t <= T; t++) {
            String[] s = br.readLine().split(" ");
            N = Integer.parseInt(s[0]);
            B = Integer.parseInt(s[1]);
            list = new int[N];
            selected = new boolean[N];
            min = Integer.MAX_VALUE;
            s = br.readLine().split(" ");
            for (int i = 0 ; i < N ; i++){
                list[i] = Integer.parseInt(s[i]);
            }

            search(0);


            sb.append('#').append(t).append(' ').append(min - B);
            if (t != T) {
                sb.append('\n');
            }
        }
        System.out.print(sb);
    }

    public static void search(int depth){
        int sum = 0;
        for(int i = 0 ; i < N ; i++){
            if(selected[i]){
                sum += list[i];
            }
        }
        if(sum>=B&&sum<min){
            min = sum;
        }
        if(depth==N){
            return;
        }
        selected[depth] = true;
        search(depth + 1);
        selected[depth] = false;
        search(depth + 1);
    }


}