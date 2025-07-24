import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;


public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        BigInteger b = new BigInteger("2");
        b = b.pow(N).subtract(BigInteger.ONE);
        sb.append(b).append('\n');
        if(N<=20){
            hanoi(1,3,2,N);
        }
        System.out.println(sb);
    }
    public static void hanoi(int start, int to, int sub,int m){
        if(m==1){
            sb.append(start).append(' ').append(to).append('\n');
        }
        else{
            hanoi(start,sub,to,m-1);
            sb.append(start).append(' ').append(to).append('\n');
            hanoi(sub,to,start,m-1);
        }
    }
}