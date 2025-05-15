import java.io.*;


class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();
        String s2 = br.readLine();
        StringBuilder sb = new StringBuilder();
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for(int i = 1 ; i < s1.length() + 1 ; i++){
            for(int j = 1 ; j < s2.length() + 1 ; j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] +1 ;
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        int len = dp[s1.length()][s2.length()];
        int i = s1.length();
        int j = s2.length();
        System.out.println(len);
        if(len!=0) {
            while (i >= 0 && j >= 0) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    sb.append(s1.charAt(i - 1));
                    i--;
                    j--;
                    if (sb.length() == len) {
                        break;
                    }
                } else if (dp[i - 1][j] > dp[i][j - 1]) {
                    i--;
                } else {
                    j--;
                }
            }
            System.out.print(sb.reverse());
        }
    }
}