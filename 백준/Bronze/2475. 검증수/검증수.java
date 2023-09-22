import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a1 = scanner.nextInt();
        int a2 = scanner.nextInt();
        int a3 = scanner.nextInt();
        int a4 = scanner.nextInt();
        int a5 = scanner.nextInt();

        double sum = (Math.pow(a1,2)+Math.pow(a2,2)+Math.pow(a3,2)+Math.pow(a4,2)+Math.pow(a5,2))%10;
        int div = (int)sum;
        System.out.println(div);


    }
}