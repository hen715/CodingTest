import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int a = Integer.parseInt(s[0]);
        int b = Integer.parseInt(s[1]);
        s = br.readLine().split(" ");
        int c = Integer.parseInt(s[0]);
        int d = Integer.parseInt(s[1]);
        System.out.print(Math.min(a+d,b+c));
    }
}