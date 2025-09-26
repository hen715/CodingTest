import java.util.*;
import java.io.*;
public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] list = new int[4][N];
        String[] s;
        for (int i = 0 ; i < N ; i++){
            s = br.readLine().split(" ");
            for(int a =  0 ; a < 4 ; a++){
                list[a][i] = Integer.parseInt(s[a]);
            }
        }
        int[] ab = new int[N * N];
        int[] cd = new int[N * N];
        int index = 0;
        for(int i = 0 ;i < N ; i++){
            for(int j = 0 ; j < N ; j++){
                ab[index] = list[0][i] + list[1][j];
                cd[index] = list[2][i] + list[3][j];
                index++;
            }
        }
        Arrays.sort(ab);
        Arrays.sort(cd);
        int start = 0;
        int end = N * N - 1;
        long answer = 0;
        while (start<N*N&&end>=0){
            long sum = ab[start] + cd[end];
            if(sum == 0){
                int same = ab[start];
                int c1 = 0;
                while (start<N*N&&ab[start]==same){
                    c1++;
                    start++;
                }
                same = cd[end];
                int c2 = 0;
                while (end>=0&&cd[end]==same){
                    c2++;
                    end--;
                }
                answer += (long)c1 * c2;
            }
            if(sum>0){
                end--;
            }
            if(sum<0){
                start++;
            }
        }
        System.out.print(answer);
    }

}