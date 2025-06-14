import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    static StringBuilder sb;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int num = (int) Math.pow(10,N);
        sb = new StringBuilder();
        for(int i = 2 ; i < 10 ; i++){
            bfs(i,1);
        }
        System.out.print(sb);
    }

    public static void bfs(int num, int depth){
        if(!check(num)){
            return;
        }
        if(depth==N){
            sb.append(num).append('\n');
            return;
        }
        for(int i = 1 ; i < 10 ; i++){
            bfs(num*10 + i,depth+1);
        }
    }

    static boolean check(int num) {
        for(int i=2 ; i*i<=num; i++) {
            if(num%i ==0) {
                return false;
            }
        }
        return true;
    }
}