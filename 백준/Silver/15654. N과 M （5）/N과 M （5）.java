import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class Main {

    static StringBuilder sb;
    static int N;
    static int M;
    static int[] list;
    static boolean[] check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        list = new int[N];
        check = new boolean[N];
        s = br.readLine().split(" ");
        for(int i = 0 ; i <  N ; i++){
            list[i] = Integer.parseInt(s[i]);
        }
        Arrays.sort(list);
        backTracking(0,"");
        System.out.println(sb);
    }

    public static void backTracking(int length, String str){
        if(length == M){
            sb.append(str).append("\n");
            return;
        }
        for(int i = 0 ; i < N ; i++){
            if(!check[i]) {
                String s = str + list[i] + " ";
                check[i] = true;
                backTracking( length + 1, s);
                check[i] = false;
            }
        }

    }
}