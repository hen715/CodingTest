import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



public class Main {

    public static class Node{
        int min;
        int max;
        public Node(int min,int max){
            this.max = max;
            this.min = min;
        }
    }

    static int N,M;
    static int[] list;
    static Node[] tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        list = new int[N];
        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(br.readLine());
        }
        tree = new Node[N * 4];
        init(0, N - 1, 1);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            s = br.readLine().split(" ");
            Node node = get(0, N - 1, 1, Integer.parseInt(s[0]) - 1, Integer.parseInt(s[1]) - 1);
            sb.append(node.min).append(' ').append(node.max).append('\n');
        }
        System.out.print(sb);
    }

    public static Node init(int start, int end, int node){
        if(start==end){
            return tree[node] = new Node(list[start], list[start]);
        }
        int mid = (start + end)/2;
        Node node1 =  init(start,mid,node * 2);
        Node node2 = init(mid+1,end,node*2+1);
        return tree[node] = new Node(Math.min(node1.min,node2.min),Math.max(node1.max,node2.max));
    }

    public static Node get(int start, int end, int node ,int left, int right){
        if(start>right || end<left){
            return new Node(Integer.MAX_VALUE,Integer.MIN_VALUE);
        }
        if(start>=left&&end<=right){
            return tree[node];
        }
        int mid = (start+end)/2;
        Node node1 = get(start,mid,node * 2,left,right);
        Node node2 = get(mid+1,end,node*2+1,left,right);
        return new Node(Math.min(node1.min,node2.min),Math.max(node1.max,node2.max));
    }




}