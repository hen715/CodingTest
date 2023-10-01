import java.util.*;

public class Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int[] list = new int[num];
        for(int i= 0; i<num;i++){
            list[i] = scanner.nextInt();
        }
        int count = 0;
        for(int i = 0 ;i < num; i++){
            boolean a = true;
            if(list[i]==1) {
                a = false;
                continue;
            }
            if(list[i]==2){
                count++;
                continue;
            }
            for(int j = 2; j<list[i]/2+1;j++){
                if(list[i]%j==0)
                    a = false;
            }
            if(a)count++;
        }
        System.out.println(count);


    }


}