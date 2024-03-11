import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        BigInteger num = BigInteger.valueOf(1);
        int count = 0;
        for(int i = 1 ; i<=n;i++){
            num = num.multiply(BigInteger.valueOf(i));
        }
        String str = String.valueOf(num);
        for(int i = str.length()-1 ; i >0;i--){
            if(str.charAt(i)=='0'){
                count++;
            }
            else{
                break;
            }
        }
        System.out.println(count);
    }
}