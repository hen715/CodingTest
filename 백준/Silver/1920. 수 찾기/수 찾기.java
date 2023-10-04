import java.util.*;

public class Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num1 = scanner.nextInt();
        int[] list1 = new int[num1];
        for(int i = 0 ; i < num1;i++){
            list1[i] = scanner.nextInt();
        }
        int num2 = scanner.nextInt();
        int[] list2 = new int[num2];
        for(int i = 0 ; i < num2;i++){
            list2[i] = scanner.nextInt();
        }

        Arrays.sort(list1);

        for(int i = 0 ; i < num2; i++){
            if(Arrays.binarySearch(list1,list2[i])>-1){
                System.out.println("1");
            }
            else
                System.out.println("0");
        }

    }


}