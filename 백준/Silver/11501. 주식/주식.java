import java.io.*;
import java.util.*;

class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int a = 0 ; a < T ; a++){
            int N = Integer.parseInt(br.readLine());
            String[] s = br.readLine().split(" ");
            int[] list = new int[N];
            for(int i = 0 ; i < N ; i++){
                list[i] = Integer.parseInt(s[i]);
            }
            int max = list[N-1];
            long sum = 0;
            for(int i = N-2 ; i >=0 ; i--){
                if(list[i]>max){
                    max = list[i];
                }
                else{
                    sum += max - list[i];
                }
            }
            sb.append(sum).append("\n");
        }
        System.out.print(sb);
    }
}