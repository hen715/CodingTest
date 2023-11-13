import java.util.Scanner;

public class Main {

    public static int Z(double num,int r, int c,int sum){
        if (num == 1) {
            return sum;
        }

        if (r < num / 2 && c < num / 2) {
            return Z(num / 2, r, c, sum);
        } else if (r < num / 2 && c >= num / 2) {
            return Z(num / 2, r, c - (int) (num / 2), sum + ((int) (num / 2) * (int) (num / 2)) * 1);
        } else if (r >= num / 2 && c < num / 2) {
            return Z(num / 2, r - (int) (num / 2), c, sum + ((int) (num / 2) * (int) (num / 2)) * 2);
        } else {
            return Z(num / 2, r - (int) (num / 2), c - (int) (num / 2), sum + ((int) (num / 2) * (int) (num / 2)) * 3);
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int r = scanner.nextInt();
        int c = scanner.nextInt();

        double num = Math.pow(2,n);

        System.out.println(Z(num,r,c,0));
    }


}