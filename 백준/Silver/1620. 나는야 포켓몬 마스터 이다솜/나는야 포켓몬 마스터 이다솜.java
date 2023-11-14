import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb =new StringBuilder();
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.nextLine();
        Map<String,String> pokemon = new HashMap<>();
        for(int i = 1 ; i<n+1;i++){
            String name = scanner.nextLine();
            pokemon.put(name,i+"");
            pokemon.put(i+"",name);
        }
        for(int i = 1 ; i < m+1 ; i++){
            sb.append(pokemon.get(scanner.nextLine()));
            sb.append("\n");
        }
        System.out.println(sb);



    }


}