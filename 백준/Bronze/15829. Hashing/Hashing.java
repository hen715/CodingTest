import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        String s = br.readLine();
        BigInteger sum = BigInteger.ZERO;
        for(int i = 0 ; i < s.length();i++){
            BigInteger b = BigInteger.valueOf((s.charAt(i)-96));
            BigInteger c = BigInteger.valueOf(31);
            c = c.pow(i);
            b = b.multiply(c);
            sum = sum.add(b);
        }
        sum = sum.mod( BigInteger.valueOf(1234567891));
        System.out.println(sum);

    }
}