import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");
        int max = 0;
        for(int i = 0 ; i < N ; i++){
            max = Math.max(max,Integer.parseInt(s[i])-(N-i));
        }
        System.out.print(max);
    }
}