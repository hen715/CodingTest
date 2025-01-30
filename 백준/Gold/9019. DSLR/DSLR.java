import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;


class Main {
    static int[] visited;

    static class Node{
        int num;
        String history;
        public Node(int num, String history){
            this.num = num;
            this.history = history;
        }
    }

    public static String bfs(int before, int after){
        Node firstNode = new Node(before,"");
        Queue<Node> q = new LinkedList<>();
        q.add(firstNode);
        while(!q.isEmpty()){
            Node node = q.poll();
            if(node.num==after){
                return node.history;
            }
            if(visited[node.num]==0) {
                visited[node.num] = 1;
                Node nodeD = new Node(node.num * 2 > 9999 ? (node.num * 2) % 10000 : node.num * 2, node.history + "D");
                q.add(nodeD);
                Node nodeS = new Node(node.num == 0 ? 9999 : node.num - 1, node.history + "S");
                q.add(nodeS);
                StringBuilder number = new StringBuilder(String.valueOf(node.num));
                while (number.length() < 4) {
                    number.insert(0, "0");
                }
                Node nodeL = new Node(Integer.parseInt(number.substring(1, 4) + number.charAt(0)), node.history + "L");
                q.add(nodeL);
                Node nodeR = new Node(Integer.parseInt(number.charAt(3) + number.substring(0, 3)), node.history + "R");
                q.add(nodeR);
            }
        }
        return "";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < N ; i++){
            String[] s = br.readLine().split(" ");
            visited = new int[10000];
            sb.append(bfs(Integer.parseInt(s[0]),Integer.parseInt(s[1]))).append("\n");
        }
        System.out.println(sb);
    }
}