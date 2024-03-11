import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        String str;
        int num = 0;
        for(int i = 1 ; i<n;i++){
            int temp = i;
            str = String.valueOf(i);
            for(int j = 0 ; j<str.length();j++){
                temp+= str.charAt(j)-48;
            }
            if(n==temp){
                num = i;
                break;
            }
        }
        System.out.println(num);

    }
}