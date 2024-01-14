import java.util.*;

public class Main {
    public static int max = 0;

    public static void search2(int[][] dp, int day, int now, int money){
        for(int i = now ; i <day;i++){
            for(int j = now ; j<day ; j++) {
                if (dp[i][j] > 0) {
                    search2(dp, day, j+1, money+dp[i][j]);
                }
            }
        }
        if(money>max)
            max =money;


    }



    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);

       int n = scanner.nextInt();
       int[][] list = new int[n][2];
       int[][] dp = new int[n][n];

       for(int i = 0 ; i <  n ; i++){
           list[i][0] = scanner.nextInt();
           list[i][1] = scanner.nextInt();
       }

        for(int i = 0 ; i <  n ; i++){
            for(int j = 0 ; j < n ; j++){
                dp[i][j] = 0;
            }
        }
        for(int i = n-1 ; i>=0 ; i--){
            if(list[i][0]<=n-i){
                dp[i][i+list[i][0]-1] = list[i][1];
            }
        }
        search2(dp,n,0,0);


        /*for(int i = 0 ; i <  n ; i++){
            for(int j = 0 ; j < n ; j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }*/


       System.out.println(max);


       }

    }