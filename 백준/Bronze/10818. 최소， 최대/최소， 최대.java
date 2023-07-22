import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int max = 0;
        int min = 0;
        for(int i = 0; i<a ; i++){
            int b = scanner.nextInt();
            if(i ==0){
                max = b;
                min = b;
            }
            else{
                if(b>max)
                    max =b;
                if(b<min)
                    min = b;
            }
        }
        System.out.printf("%d %d",min,max);
    }
}