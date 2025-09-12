import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N =Integer.parseInt(br.readLine());
        int[] dp = new int[N+1];
        String[] s = br.readLine().split(" ");
        int point = 0;
        for(int i = 0 ; i < N ; i++){
            int num = Integer.parseInt(s[i]);
            if(dp[point]<num){
                dp[++point] = num;
            }
            else{
                int index = search(0,point,num,dp);
                dp[index] = num;
            }
        }
        System.out.print(point);
    }
    public static int search(int start, int end ,int num,int[] dp){
        while (start<end){
            int mid = (start + end)/2;
            if(dp[mid]<num){
                start =mid + 1;
            }
            else{
                end = mid;
            }
        }
        return end;
    }
}