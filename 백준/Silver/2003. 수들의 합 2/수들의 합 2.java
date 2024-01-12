import java.util.*;

public class Main {




    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);

       int n = scanner.nextInt();
       int m = scanner.nextInt();
       int[] A = new int[n];
       for(int i = 0 ; i<n ; i++){
           A[i] = scanner.nextInt();
       }
       int count = 0;
       for(int i = 0; i<n ; i++){
           int sum = 0;
           for(int j = i ; j < n ; j++){
               sum += A[j];
               if(sum==m)
                   count++;
               if(sum>m)
                   break;

           }
       }
       System.out.println(count);

    }

}