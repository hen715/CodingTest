import java.util.*;

public class Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int a = scanner.nextInt();
        int[] list = new int[a];
        for(int i= 0 ; i<a;i++){
            list[i] = scanner.nextInt();
        }
        Arrays.sort(list);
        for(int i = 0 ; i<a;i++) {
            sb.append(list[i]);
            sb.append("\n");
        }
        System.out.println(sb);
    }
}