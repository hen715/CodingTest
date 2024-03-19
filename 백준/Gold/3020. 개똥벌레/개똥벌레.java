import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] s = bf.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int h = Integer.parseInt(s[1]);
        int[] cave1 = new int[h];
        int[] cave2 = new int[h];
        int[] high = new int[h];
        for(int i = 0 ; i<n;i++){
            if(i%2==0){
                cave1[Integer.parseInt(bf.readLine())-1]++;
            }
            else{
                cave2[Integer.parseInt(bf.readLine())-1]++;
            }
        }

        for(int i = h-2 ; i>=0;i--){
            cave1[i] = cave1[i] +cave1[i+1];
            cave2[i] = cave2[i] +cave2[i+1];
            high[i] += cave1[i];
        }

        for(int i = 0 ; i<h;i++){
            high[h-i-1] += cave2[i];
        }
        int min = 999999999;
        int count = 0;
        for(int i = 0 ; i<h ; i++){
            if(high[i]<min){
                min = high[i];
                count = 1;
            }
            else if(high[i]==min){
                count++;
            }
        }
        System.out.println(min+" "+count);
    }
}