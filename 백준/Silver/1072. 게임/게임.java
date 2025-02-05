import java.io.*;
import java.util.*;

class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        double x = Integer.parseInt(s[0]);
        double y = Integer.parseInt(s[1]);
        if(x==y){
            System.out.println(-1);
            return;
        }
        long rate = (long) ((y * 100) / x );
        long start = 0;
        long end = Integer.MAX_VALUE;
        long mid;
        while (start<=end){
            mid = (start+end)/2;
            if(((long)((((y + (double) mid)) * 100) / ((x + (double) mid))))>rate){
                end = mid - 1;
            }else{
                start = mid + 1 ;
            }
        }
        if(rate==(long)((y+start)*100/(x+start))){
            System.out.println(-1);
        }
        else {
            System.out.println(start);
        }
    }

}