import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        int count2 = count(n,2) - count(n-m,2) - count(m,2);
        int count5 = count(n,5) - count(n-m,5) - count(m,5);
        System.out.print(Math.min(count2,count5));

    }
    public static int count(int num ,int divide){
        int c = 0;
        while (num>0){
            num = num/divide;
            c += num;
        }
        return c;
    }
}