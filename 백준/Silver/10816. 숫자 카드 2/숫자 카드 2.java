import java.util.*;

public class Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int num1 = scanner.nextInt();
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i<num1;i++){
            int key = scanner.nextInt();
            if(map.containsKey(key)){
                int temp = map.get(key) + 1 ;
                map.remove(key);
                map.put(key,temp);
            }
            else{
                map.put(key,1);
            }

        }

        int num3 = scanner.nextInt();

        for(int i = 0; i<num3;i++){
            int num2 = scanner.nextInt();
            if(map.containsKey(num2)){
                sb.append(map.get(num2)+" ");
            }
            else {
                sb.append("0"+" ");
            }
        }
        scanner.nextLine();


        System.out.println(sb);
    }
}