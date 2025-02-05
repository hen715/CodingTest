import java.io.*;
import java.util.*;

class Main {
    static int N;
    static int M;
    static StringBuilder sb;
    static int[] list;
    static int[] answer;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        list = new int[N];
        answer = new int[M];
        s = br.readLine().split(" ");
        for(int i = 0 ; i < N ; i++){
            list[i] = Integer.parseInt(s[i]);
        }
        sb = new StringBuilder();
        Arrays.sort(list);
        backTracking(0);
        System.out.print(sb);
    }

    public static void backTracking(int depth){
        if(depth==M){
            for(int i : answer){
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i = 0 ; i < N ; i++){
            answer[depth] = list[i];
            backTracking(depth+1);
        }
    }
}