import java.io.*;

class Main {


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] list = new int[n];
        StringBuilder sb =new StringBuilder();
        int max = -1;
        for(int i = 0 ; i < n ; i++){
            int num = Integer.parseInt(br.readLine());
            list[i] = num;
            if(num>max){
                max = num;
            }
        }
        int[] dp = new int[max+1];
        dp[1] = 1;
        if(max>=2){
            dp[2] = 2;
            if(max>=3){
                dp[3] = 4;
            }
            if(max>=4){
                for(int i =4 ; i <max+1;i++){
                    dp[i] = dp[i-1]+dp[i-2]+dp[i-3];
                }
            }
        }
        for(int i :list){
            sb.append(dp[i]+"\n");
        }
        System.out.println(sb);
    }

}