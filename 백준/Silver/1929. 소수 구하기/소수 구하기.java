import java.io.*;
import java.math.BigInteger;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] s = bf.readLine().split(" ");
        int a = Integer.parseInt(s[0]);
        int b = Integer.parseInt(s[1]);
        for(int i = a;i<b+1;i++){
            BigInteger x = BigInteger.valueOf(i);
            if(x.isProbablePrime(10)){
                sb.append(i+"\n");
            }
        }
        System.out.println(sb);
    }
}