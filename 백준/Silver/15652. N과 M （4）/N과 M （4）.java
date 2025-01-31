import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


class Main {

    static StringBuilder sb;
    static int N;
    static int M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        backTracking(1,0,"");
        System.out.println(sb);
    }

    public static void backTracking(int start, int length, String str){
        if(length == M){
            sb.append(str).append("\n");
            return;
        }
        for(int i = start ; i <= N ; i++){
            String s = str + i +" ";
            backTracking(i,length+1,s);
        }

    }
}