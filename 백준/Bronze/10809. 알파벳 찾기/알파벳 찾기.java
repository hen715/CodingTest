import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String a = scanner.nextLine();
        int[] alpha = new int[26];
        for(int i = 0 ; i<alpha.length; i++){
            alpha[i] = -1;
        }
        for(int i = 0 ; i< a.length();i++){
            int b = a.charAt(i)-'a';
            if(alpha[b]==-1)
                alpha[b] = i;
        }
        for(int i = 0; i< alpha.length;i++){
            System.out.print(alpha[i]);
            System.out.print(" ");
        }

    }
}