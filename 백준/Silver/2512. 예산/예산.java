import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int[] money = new int[n];
        String[] s = bf.readLine().split(" ");
        int m = Integer.parseInt(bf.readLine());
        int sum = 0;
        for(int i = 0 ; i < n ; i++){
            money[i] = Integer.parseInt(s[i]);
            sum += money[i];
        }
        Arrays.sort(money);
        if(sum<m){
            System.out.println(money[n-1]);
            return;
        }

        int back_start;
        int front_start;
        int back_sum;
        int back_count;
        int front_sum;
        int remain;
        for(int i = n-1 ; i>0;i--){
            back_start = i;
            front_start = i-1;
            back_sum = 0;
            back_count = 0;
            front_sum = 0;
            for(int j = back_start; j<n;j++){
                back_sum += money[j];
                back_count++;
            }
            if(front_start>=0) {
                for (int j = front_start; j >= 0; j--) {
                    front_sum += money[j];
                }
            }
            remain = m-front_sum;
            if(remain/back_count>money[front_start]){

                System.out.println(remain/back_count);
                return;
            }

        }
        System.out.println(m/n);
    }
}