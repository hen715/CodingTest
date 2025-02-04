import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



class Main {
    static int N;
    static int[] chess;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        chess = new int[N];
        backTracking(0);
        System.out.println(count);

    }

    public static void backTracking(int depth) {
        if(depth == N){
            count++;
            return;
        }
        for(int i = 0 ; i < N ; i++){
            chess[depth] = i;
            if(check(depth)){
                backTracking(depth+1);
            }
        }
    }

    public static boolean check(int now){
        for(int i = 0 ; i < now ; i++){
            if(chess[i]==chess[now]){
                return false;
            }
            else if(Math.abs(i-now)==Math.abs(chess[i]-chess[now])){
                return false;
            }
        }
        return true;
    }
}