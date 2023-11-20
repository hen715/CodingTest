import java.util.*;

public class Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n  = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.nextLine();
        int count = 0;
        Set<String> set = new HashSet<String>();
        Set<String> set2 = new HashSet<String>();
        for(int i = 0 ; i<n;i++){
            set.add(scanner.nextLine());
        }
        for(int i = 0 ; i < m ; i++){
            String a = scanner.nextLine();
            if(set.contains(a)){
                count++;
                set2.add(a);
            }
        }
        List<String> list = new ArrayList<>(set2);
        Collections.sort(list);
        for(int i = 0 ; i <list.size();i++)
            sb.append(list.get(i)+"\n");
        System.out.println(count);
        System.out.println(sb);



    }


}