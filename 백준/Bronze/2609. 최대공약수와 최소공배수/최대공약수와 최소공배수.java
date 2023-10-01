import java.math.BigInteger;
import java.util.*;

public class Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        BigInteger a1 = BigInteger.valueOf(a);
        BigInteger b1 = BigInteger.valueOf(b);
        BigInteger gcd = a1.gcd(b1);
        BigInteger lcm = a1.multiply(b1).divide(gcd);
        System.out.println(gcd);
        System.out.println(lcm);
    }
}