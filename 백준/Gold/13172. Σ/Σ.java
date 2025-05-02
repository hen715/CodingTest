import java.io.*;
import java.math.BigInteger;

class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());
        int[][] dice = new int[M][2];
        String[] s;
        for(int i = 0 ; i < M ; i++){
            s = br.readLine().split(" ");
            dice[i][0] = Integer.parseInt(s[0]);
            dice[i][1] = Integer.parseInt(s[1]);
        }
        long sum = 0;
        for(int i = 0 ; i < M ; i++){
            sum = (sum + solution(dice[i][0],dice[i][1]))%1000000007;
        }
        System.out.print(sum);
    }
    public static long solution(int n, int s){
        BigInteger b = BigInteger.valueOf(n);
        BigInteger mod = BigInteger.valueOf(1000000007);
        BigInteger res = b.modPow(mod.subtract(BigInteger.valueOf(2)),mod);
        return s * res.longValue();
    }

}