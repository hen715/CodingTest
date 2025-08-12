import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
    public static int[][] list;
    public static int max;
    public static int[] selected;
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
            for(int i = 1 ; i <= N ; i++){
                selected = new int[N];
                for(int j = 0 ; j < i ; j++){
                    selected[j] =1;
                }
                Arrays.sort(selected);
                int sum = 0;
                int kal = 0;
                for(int j = 0 ; j < N ; j++){
                    if(selected[j]==1) {
                        sum += list[j][0];
                        kal += list[j][1];
                    }
                }
                if(kal<=L){
                    max = Math.max(max, sum);
                }
                while (nextPerm()){
                    sum = 0;
                    kal = 0;
                    for(int j = 0 ; j < N ; j++){
                        if(selected[j]==1) {
                            sum += list[j][0];
                            kal += list[j][1];
                        }
                    }
                    if(kal<=L){
                        max = Math.max(max, sum);
                    }
                }
            }

            sb.append('#').append(t).append(' ').append(max);
            if(t!=T) {
                sb.append('\n');
            }
        }
        System.out.print(sb);
    }

    public static boolean nextPerm(){
        int i = N - 2;
        while (i >= 0 && selected[i] >= selected[i + 1]) i--;
        if (i < 0) return false;
        int j = N - 1;
        while (selected[i] >= selected[j]) j--;
        swap(i, j);
        reverse( i + 1, N - 1);
        return true;
    }
    static void swap(int i, int j) {
        int tmp = selected[i];
        selected[i] = selected[j];
        selected[j] = tmp;
    }

    static void reverse(int s, int e) {
        while (s < e) swap(s++, e--);
    }
}