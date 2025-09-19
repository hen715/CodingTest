import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i =0 ; i < N ; i++){
            long num = Long.parseLong(br.readLine());
            boolean able = true;
            for(int a = 2 ; a <= 1000000 ; a++){
                if(num%a==0){
                    able = false;
                    break;
                }
            }
            if(able){
                sb.append("YES").append('\n');
            }
            else{
                sb.append("NO").append('\n');
            }
        }
        System.out.print(sb);

    }
}