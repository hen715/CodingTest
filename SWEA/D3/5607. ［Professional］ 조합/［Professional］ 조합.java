import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 1; t <= T; t++) {
            String[] s = br.readLine().split(" ");
            int N = Integer.parseInt(s[0]);
            int R = Integer.parseInt(s[1]);
            long sum1 = 1;
            for(int i = N - R +1 ; i <= N ; i++){
                sum1 *= i;
                sum1 %= 1234567891;
            }
            long sum2 = 1;
            for(int i = 1 ; i <= R ; i++){
                sum2 *= i;
                sum2 %= 1234567891;
            }
            sum2 = pow(sum2,1234567891 - 2);
            sb.append('#').append(t).append(' ').append((sum1*sum2)%1234567891).append('\n');
        }

        System.out.print(sb);
    }

    public static long pow(long num, int p){
        if(p==0){
            return 1;
        }
        else if(p==1){
            return num;
        }
        if(p%2==0){
            long temp = pow(num,p/2);
            return (temp*temp) % 1234567891;
        }
        long temp = pow(num,p-1) % 1234567891;
        return (temp*num) % 1234567891;
    }

}