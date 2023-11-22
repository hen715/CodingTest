import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] array = new int[k+3];
        if(k<n){
            System.out.println(n-k);
        }
        else{
            for(int i = 0 ; i<=n;i++ ){
               array[n-i] = i;
            }
            for(int i = 0 ; i<k-n+2;i++ ){
                array[n+i] = i;
            }
            int a;
            if(n!=0){
                a = k/n+1;
            }
            else a= k;
            for(int j = 0 ; j<2;j++){
            for(int i = n ; i<k+2;i++) {
                if (i % 2 != 0) {
                    array[i] = Math.min(array[i], array[i + 1] + 1);
                    array[i] = Math.min(array[i], array[i -1 ] + 1);
                } else {
                    array[i] = Math.min(array[i], array[i / 2] + 1);
                    if(i>0)
                        array[i] = Math.min(array[i], array[i -1] + 1);
                }
            }
             }
            System.out.println(array[k]);
        }
        /*for(int i = 0 ; i<k+2;i++){
            System.out.print(array[i]+" ");
        }
        System.out.println("\n"+array[k]);*/

    }
}