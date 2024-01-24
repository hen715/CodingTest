import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int sum;
    public static void fac(int n) {
        if (n > 0) {
            sum *= n;
            fac(n - 1);
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(bf.readLine());
        sum = 1;
        fac(a);
        System.out.println(sum);

    }
}