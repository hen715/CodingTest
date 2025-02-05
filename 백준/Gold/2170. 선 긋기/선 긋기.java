import java.io.*;
import java.util.*;

class Main {
    static class Node{
        int x;
        int y;
        Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Node> q = new PriorityQueue<>((o1,o2)->o1.x!=o2.x?o1.x-o2.x:o1.y-o2.y);
        String[] s;
        for(int i = 0 ; i < N ; i++){
            s = br.readLine().split(" ");
            q.add(new Node(Integer.parseInt(s[0]),Integer.parseInt(s[1])));
        }
        Node node = q.poll();
        int sum = node.y - node.x;
        int last = node.y;
        while (!q.isEmpty()){
            node = q.poll();
            if(node.x<=last&&node.y>last){
                sum += node.y - last;
                last = node.y;
            }
            else if(node.x<=last){

            }
            else{
                sum += node.y - node.x;
                last = node.y;
            }
        }
        System.out.println(sum);
    }
}