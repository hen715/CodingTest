
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        for(int i = 1; i <count + 1 ; i++){
            for(int j = 0 ; j<count  - i ; j++)
                System.out.print(" ");
            for(int k = i ; k>0;k--)
                System.out.print("*");
            System.out.println();
        }
    }

}