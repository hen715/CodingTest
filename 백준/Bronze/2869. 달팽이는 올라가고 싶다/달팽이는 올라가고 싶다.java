import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] s = bf.readLine().split(" ");
        double a = Integer.parseInt(s[0]);
        double b = Integer.parseInt(s[1]);
        double v = Integer.parseInt(s[2]);

        System.out.println((long)Math.ceil((v - a) / (a - b)) + 1);
    }
}