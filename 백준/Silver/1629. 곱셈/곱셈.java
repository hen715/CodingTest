import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;


class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        BigInteger A = BigInteger.valueOf(Long.parseLong(s[0]));
        BigInteger B = BigInteger.valueOf(Long.parseLong(s[1]));
        BigInteger C = BigInteger.valueOf(Long.parseLong(s[2]));
        A = A.modPow(B,C);
        System.out.println(A);

    }
}