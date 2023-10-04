import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int max = scanner.nextInt();
        int[] nums = new int[num];

        for(int i = 0 ; i<num;i++){
            nums[i] = scanner.nextInt();
        }

        Arrays.sort(nums);

        int sum1  = 0;
        int sum2 = 0;
        int sum3 = 0;
        int maxSum = 0;

        for(int a = 0; a<num-2;a++){
            sum1 =  nums[a];
            for(int b = a+1 ; b < num-1;b++){
                sum2 = sum1 + nums[b];
                for(int c = b+1 ; c < num ; c++){
                    sum3 = sum2 + nums[c];
                    if(sum3 <=max && maxSum<sum3){
                        maxSum = sum3;
                    }
                }
            }
        }
        System.out.println(maxSum);
    }

}