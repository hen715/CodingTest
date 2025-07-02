import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static class Node{
        int v;
        int index;
        public Node(int v, int index){
            this.v = v;
            this.index = index;
        }
    }



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");
        List<Node> list = new ArrayList<>();
        for(int i = 0 ; i < N ; i++){
            list.add(new Node(Integer.parseInt(s[i]),i));
        }
        list.sort((o1, o2) -> o1.v- o2.v);
        int max = 0;
        for(int i = 0 ; i < N ; i++){
            Node node = list.get(i);
            max = Math.max(max,node.index - i);
        }
        System.out.print(max);


    }

}