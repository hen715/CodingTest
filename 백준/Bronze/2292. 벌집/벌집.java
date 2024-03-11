import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int b = 1;
        int count = 1;
        if(n==1){
            System.out.println(1);
            return;
        }
        while (true){
            b +=6*count;
            count++;
            if(n<=b){
                break;
            }
        }
        System.out.println(count);

    }
}