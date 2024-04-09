class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int[][] dp = new int[500][500];
        dp[0][0] = triangle[0][0];
        for(int i = 1 ; i < triangle.length;i++){
            for(int j = 0 ; j < triangle[i].length; j++){
                if(j==0){
                    dp[i][j] = triangle[i][j] + dp[i-1][j];
                }
                else if (j==triangle[i].length-1){
                    dp[i][j] =triangle[i][j] + dp[i-1][triangle[i].length-2];
                }
                else{
                    dp[i][j] = triangle[i][j] + Math.max(dp[i-1][j-1],dp[i-1][j]);
                }
            }
        }
        for(int i = 0 ; i < triangle[triangle.length-1].length; i++){
            if(dp[triangle.length-1][i]>answer){
                answer = dp[triangle.length-1][i];
            }
        }
        return answer;
    }
}