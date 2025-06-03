import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");
        StringBuilder sb = new StringBuilder();
        int[] list = new int[N];
        for(int i = 0 ; i < N ; i++){
            list[i] = Integer.parseInt(s[i]);
        }
        int ring = list[0];
        for(int i = 1 ; i < N ; i++){
            int gcd = gcd(ring,list[i]);
            sb.append(ring/gcd).append('/').append(list[i]/gcd).append('\n');
        }
        System.out.println(sb);

    }
    public static int gcd(int num1, int num2){
        if(num1%num2==0){
            return num2;
        }
        return gcd(num2,num1%num2);
    }
}