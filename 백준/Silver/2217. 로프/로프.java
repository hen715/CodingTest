import java.util.*;

public class Main {




    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);

       int n = scanner.nextInt();
       int[] w = new int[n];
       for (int i = 0 ; i< n ; i++)
           w[i] = scanner.nextInt();
       Arrays.sort(w);
       int max = -1;
       for (int i = 0 ; i< n ; i++){
           if(w[i]*(n-i)>max){
               max = w[i]*(n-i);
           }
       }
       System.out.println(max);
    }

}