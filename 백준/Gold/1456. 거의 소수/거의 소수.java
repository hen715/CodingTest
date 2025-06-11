import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        long A = Long.parseLong(s[0]);
        long B = Long.parseLong(s[1]);
        int b = (int) Math.sqrt(B);
        boolean[] prime = new boolean[b+1];
        prime[0] = true;
        prime[1] = true;
        for(int i = 2 ; i * i <= b ; i++){
            if(!prime[i]){
                for(int j = i * i ;  j <= b ;j+=i){
                    prime[j] = true;
                }
            }
        }
        int count = 0;
        for(int i = 2  ; i <= b ; i++){
            if(!prime[i]){
                long temp = (long) i * i;
                while (temp <= B){
                    if(temp >= A){
                        count++;
                    }
                    if (temp> B / i){
                        break;
                    }
                    temp *= i;
                }
            }
        }
        System.out.print(count);

    }
}