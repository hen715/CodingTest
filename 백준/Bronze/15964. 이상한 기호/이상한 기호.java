import java.io.*;
import java.math.BigInteger;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] s=  bf.readLine().split(" ");
        int a = Integer.parseInt(s[0]);
        int b = Integer.parseInt(s[1]);
        BigInteger n = BigInteger.valueOf(a);
        BigInteger m = BigInteger.valueOf(b);
        BigInteger c = n.add(m);
        BigInteger d = n.subtract(m);

        System.out.println(c.multiply(d));


    }
}