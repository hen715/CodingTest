import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Node{
        String number;
        int v;
        public Node(String number, int v){
            this.number = number;
            this.v = v;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int K = Integer.parseInt(s[0]);
        int L = Integer.parseInt(s[1]);
       Map<String,Integer> map = new HashMap<>();
        for(int i = 0 ; i < L ; i++){
            map.put(br.readLine(),i);
        }
        List<Node> list = new ArrayList<>();
        for(String key : map.keySet()){
            list.add(new Node(key,map.get(key)));
        }
        list.sort((o1, o2) -> o1.v-o2.v);
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < Math.min(K,list.size()) ; i++){
            sb.append(list.get(i).number).append('\n');
        }
        System.out.print(sb);
    }
}