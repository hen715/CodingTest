import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<Integer> list= new ArrayList<>();
        for(int i = 0 ; i<9 ; i++){
            int a = scanner.nextInt();
            list.add(a);
        }
        int max = 0;
        int pos = 0;
        for(int i = 0 ; i < 9 ; i++){
            if(list.get(i)>max){
                max = list.get(i);
                pos = i;
            }
        }
        System.out.println(max);
        System.out.println(pos+1);
    }
}