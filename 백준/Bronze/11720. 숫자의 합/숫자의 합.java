import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        scanner.nextLine();
        String str = scanner.nextLine();
        int sum = 0;
        for(int i = 0 ; i<a; i++){
            sum += str.charAt(i)-48;
        }
        System.out.println(sum);
    }
}