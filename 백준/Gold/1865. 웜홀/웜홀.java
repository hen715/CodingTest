import java.io.*;
import java.util.ArrayList;
import java.util.List;

class Main {
    static int N;
    static int M;
    static int W;
    static final int MAX_VALUE = 1000000000;
    public static class Node{
        int start;
        int end;
        int cost;
        public Node(int start, int end ,int cost){
            this.start = start;
            this.end = end;
            this.cost = cost;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int t = 0 ; t < TC ; t++){
            String[] s = br.readLine().split(" ");
            N = Integer.parseInt(s[0]);
            M = Integer.parseInt(s[1]);
            W = Integer.parseInt(s[2]);
            List<Node> list = new ArrayList<>();
            for(int i = 0 ; i < M ; i++){
                s = br.readLine().split(" ");
                list.add(new Node(Integer.parseInt(s[0]),Integer.parseInt(s[1]),Integer.parseInt(s[2])));
                list.add(new Node(Integer.parseInt(s[1]),Integer.parseInt(s[0]),Integer.parseInt(s[2])));
            }
            for(int i = 0 ; i < W ; i++){
                s = br.readLine().split(" ");
                list.add(new Node(Integer.parseInt(s[0]),Integer.parseInt(s[1]),Integer.parseInt(s[2]) *-1));
            }
            int[]dis = new int[N+1];
            boolean able = false;
                dis[1] = 0;
                for(int a = 0 ; a < N ; a++){
                    for(int b = 0 ; b <  (2 * M) + W ; b++){
                        Node node = list.get(b);
                        if(dis[node.end] > dis[node.start] + node.cost){
                            dis[node.end] = dis[node.start] + node.cost;
                        }

                    }
                }
                for(int v = 0 ; v < (2 * M) + W ; v++){
                    Node node = list.get(v);
                    if (dis[node.end] > dis[node.start] + node.cost) {
                        able = true;
                        break;
                    }
                }
            if(able){
                sb.append("YES\n");
            }
            else{
                sb.append("NO\n");
            }
        }
        System.out.print(sb);
    }
}