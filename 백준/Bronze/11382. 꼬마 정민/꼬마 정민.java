import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;


public class Main {


    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        BigInteger a = scanner.nextBigInteger();
        BigInteger b = scanner.nextBigInteger();
        BigInteger c = scanner.nextBigInteger();
        b = a.add(b);
        b = b.add(c);
        System.out.println(b);
        }
    }