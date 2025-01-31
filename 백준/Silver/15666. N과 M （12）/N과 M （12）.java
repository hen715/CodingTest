import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class Main {
    static int[] list;
    static StringBuilder sb;
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        list = new int[N];
        s = br.readLine().split(" ");
        for(int i = 0 ; i < N ; i++){
            list[i] = Integer.parseInt(s[i]);
        }
        Arrays.sort(list);
        backTracking(0,0,"");
        System.out.print(sb);
    }

    public static void backTracking(int length,int before,String str){
        if(length==M){
            sb.append(str).append("\n");
            return;
        }
        int stop = 0;
        for(int i = 0 ; i < N ; i++){
            if(stop!=list[i]&&list[before]<=list[i]){
                stop = list[i];
                String s = str+list[i]+" ";
                backTracking(length+1,i,s);
            }
        }
    }
}