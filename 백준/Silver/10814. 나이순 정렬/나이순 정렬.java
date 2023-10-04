import java.util.*;

public class Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int num = scanner.nextInt();
        Map<Integer, List<String>> map = new HashMap<>();
        for (int i = 0; i < num; i++) {
            List<String> l = new ArrayList<>();
            int key = scanner.nextInt();
            if(map.containsKey(key)){
                map.get(key).add(scanner.nextLine());
            }
            else{
                map.put(key, l);
                map.get(key).add(scanner.nextLine());
            }

        }
        List<Integer> keySet = new ArrayList<>(map.keySet());
        Collections.sort(keySet);


        for (int key: keySet) {
            for(int i = 0 ; i<map.get(key).size() ; i++) {
                sb.append(key);
                sb.append(map.get(key).get(i) + "\n");
            }
        }

        System.out.println(sb);
    }
}