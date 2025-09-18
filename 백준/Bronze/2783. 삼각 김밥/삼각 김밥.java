import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        double a = Integer.parseInt(s[0]);
        double b = Integer.parseInt(s[1]);
        double min = Double.MAX_VALUE;
        min = Math.min(min,a/b * 1000);
        int N = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < N ; i++){
            s = br.readLine().split(" ");
            a = Integer.parseInt(s[0]);
            b = Integer.parseInt(s[1]);
            min = Math.min(min,a/b * 1000);
        }
        System.out.print(min);
    }
}