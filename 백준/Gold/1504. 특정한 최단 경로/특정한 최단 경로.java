import java.io.*;
import java.util.*;

class Main {

    static class Node{
        int v;
        int c;
        Node(int v, int c){
            this.v = v;
            this.c = c;
        }
    }

    static boolean[] visit;
    static int[] distance;
    static ArrayList<ArrayList<Node>> list;
    static int N;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        int E = Integer.parseInt(s[1]);
        list = new ArrayList<>();
        for(int i = 0 ; i < N +1 ; i++){
            list.add(new ArrayList<>());
        }
        for(int i = 0 ; i < E ; i++){
            s = br.readLine().split(" ");
            int v1 = Integer.parseInt(s[0]);
            int v2 = Integer.parseInt(s[1]);
            int c = Integer.parseInt(s[2]);
            list.get(v1).add(new Node(v2,c));
            list.get(v2).add(new Node(v1,c));
        }
        s = br.readLine().split(" ");
        int v1 = Integer.parseInt(s[0]);
        int v2 = Integer.parseInt(s[1]);
        long r1 = 0;
        long r2 = 0;
        r1 += shorten(1,v1);
        r1 += shorten(v1,v2);
        r1 += shorten(v2,N);

        r2 += shorten(1,v2);
        r2 += shorten(v2,v1);
        r2 += shorten(v1,N);

        System.out.println((r1>=Integer.MAX_VALUE&&r2>=Integer.MAX_VALUE)?-1: Math.min(r1, r2));



    }

    public static int shorten(int start, int end){
        visit = new boolean[N+1];
        distance = new int[N+1];
        for(int i = 1 ; i < N +1 ; i++){
            distance[i] = Integer.MAX_VALUE;
        }
        distance[start] = 0;
        PriorityQueue<Node> q = new PriorityQueue<>((o1, o2) -> o1.c - o2.c);
        q.add(new Node(start,0));
        while (!q.isEmpty()){
            Node node = q.poll();
            visit[node.v] = true;
            if(distance[node.v] < node.c){
                continue;
            }
            distance[node.v] = node.c;
            ArrayList<Node> l = list.get(node.v);
            for(Node n : l ){
                if(!visit[n.v]&&distance[n.v]>node.c + n.c) {
                    q.add(new Node(n.v, node.c + n.c));
                }
            }
        }

        return distance[end];

    }


}