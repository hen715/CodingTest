import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int[] nums = new int[num];
        for(int i =0 ; i<num;i++)
            nums[i] = scanner.nextInt();
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i<num;i++){
            if(nums[i]==0){
                sb.append("1 0\n");
                continue;
            }
            if(nums[i]==1){
                sb.append("0 1\n");
                continue;
            }
            if(nums[i]==2){
                sb.append("1 1\n");
                continue;
            }
            int[][] array = new int[2][nums[i]];
            array[1][0] = 0;
            array[1][1] = 1;
            array[0][0] = 1;
            array[0][1] = 1;
            array[0][2] = 1;
            array[1][2] = 2;
            for(int j = 3 ; j <nums[i];j++){
                array[0][j]= array[0][j-1]+array[0][j-2];
                array[1][j] = array[1][j-1]+array[1][j-2];
            }
            sb.append(array[0][nums[i]-1]);
            sb.append(" ");
            sb.append(array[1][nums[i]-1]);
            sb.append('\n');
        }
        System.out.println(sb);
    }

}