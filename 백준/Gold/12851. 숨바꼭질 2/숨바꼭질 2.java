import java.io.*;
import java.util.LinkedList;
import java.util.Queue;


class Main {
    public static class Node{
        int now;
        int count;
        public Node(int now, int count){
            this.now = now;
            this.count = count;
        }
    }



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int K = Integer.parseInt(s[1]);

        Queue<Node> queue = new LinkedList<>();
        boolean[] visit = new boolean[100001];
        int min = Integer.MAX_VALUE;
        int way = 0;
        queue.add(new Node(N,0));
        while (!queue.isEmpty()){
            Node node = queue.poll();
            visit[node.now] = true;
            if(node.now==K){
                if(min==Integer.MAX_VALUE){
                    min = node.count;
                    way++;
                }
                else if(min == node.count){
                    way++;
                }
                continue;
            }
            if(node.now - 1 >=0 && !visit[node.now-1]){
                queue.add(new Node(node.now - 1, node.count + 1));
            }
            if(node.now + 1 <100001 && !visit[node.now+1]){
                queue.add(new Node(node.now + 1, node.count + 1));
            }
            if(node.now * 2 <100001 && !visit[node.now * 2]){
                queue.add(new Node(node.now * 2, node.count + 1));
            }
        }
        System.out.println(min);
        System.out.print(way);

    }
}