import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(bf.readLine());

        for(int i = 0 ; i< n ;i++){
            int num = Integer.parseInt(bf.readLine());
            long[] dp = new long[num+1];
            for(int a = 1 ; a<num+1;a++){
                if(a == 1){
                    dp[a] = 1;
                }
                else if(a == 2){
                    dp[a] = 2;
                }
                else if(a == 3){
                    dp[a] = 4;
                }

                else{
                    /*for(int b = a-3 ; b<a ; b++){
                        dp[a] +=dp[b];
                    }*/
                    dp[a] = dp[a-1]+dp[a-2]+dp[a-3];
                    dp[a] %=1000000009;
                }
            }
            sb.append(dp[num]);
            if(i!=n-1)
                sb.append("\n");
        }
        System.out.print(sb);
    }
}