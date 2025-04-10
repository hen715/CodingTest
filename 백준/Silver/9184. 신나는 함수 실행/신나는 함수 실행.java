import java.io.*;



class Main {


    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       int[][][] dp = new int[21][21][21];
       for(int i = 0 ; i < 21 ; i++){
           for(int j = 0 ; j < 21 ; j++){
               for(int k = 0 ; k < 21 ; k++){
                   if(i==0||j==0||k==0){
                        dp[i][j][k] = 1;
                   }
                   else if(i < j && j < k){
                       dp[i][j][k] = dp[i][j][k-1] +dp[i][j-1][k-1] - dp[i][j-1][k];
                   }
                   else{
                       dp[i][j][k] = dp[i-1][j][k] + dp[i-1][j-1][k] + dp[i-1][j][k-1] - dp[i-1][j-1][k-1];
                   }
               }
           }
       }
       StringBuilder sb = new StringBuilder();
       while (true){
           String[] s = br.readLine().split(" ");
           int a = Integer.parseInt(s[0]);
           int b = Integer.parseInt(s[1]);
           int c = Integer.parseInt(s[2]);

           if(a==-1 && b==-1 && c==-1){
               break;
           }
           sb.append("w(").append(a).append(", ").append(b).append(", ").append(c).append(") = ");
           if(a<=0||b<=0||c<=0){
               sb.append(1).append("\n");
           }
           else if(a > 20 || b > 20 || c > 20){
               sb.append(dp[20][20][20]).append("\n");
           }
           else{
               sb.append(dp[a][b][c]).append("\n");
           }
       }
       System.out.print(sb);
    }

}