import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int K = Integer.parseInt(s[1]);
        Set<String> set = new HashSet<>();
        for(int i = 0 ; i < N ; i++){
           set.add(br.readLine());
        }
        String command = br.readLine();
        int x = 0;
        int y = 0;
        for(int i = 0 ; i < K ; i++){
            int xx = x;
            int yy = y;
            if(command.charAt(i)=='U'){
                yy++;
            }
            if(command.charAt(i)=='D'){
                yy--;
            }
            if(command.charAt(i)=='L'){
                xx--;
            }
            if(command.charAt(i)=='R'){
                xx++;
            }
            if(!set.contains(xx+" "+yy)){
                x = xx;
                y = yy;
            }
        }
        System.out.print(x+" "+y);

    }
}