import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



public class Main {

    static int N,M,K;
    static long[] list,tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        K = Integer.parseInt(s[2]);
        list = new long[N];
        for(int i = 0 ; i < N ; i++){
            list[i] = Long.parseLong(br.readLine());
        }
        tree = new long[N * 4];
        init(0,N-1,1);
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < M + K ; i++){
            s = br.readLine().split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);
            long c = Long.parseLong(s[2]);
            if(a==1){
                update(0,N-1,1,b-1, c - list[b-1]);
                list[b-1] = c;
            }
            else{
                sb.append(get(0,N-1,1,b-1,(int)c-1)).append('\n');
            }
        }
        System.out.print(sb);


    }

    public static long init(int start, int end, int node){
        if(start==end){
            return tree[node] = list[start];
        }
        int mid = (start + end)/2;
        return tree[node] = init(start,mid,node * 2) + init(mid+1,end,node*2+1);
    }

    public static void update(int start, int end,int node, int index,  long value){
        if(start<=index&&end>=index){
            tree[node] += value;
        }
        else{
            return;
        }
        if(start==end){
            return;
        }
        int mid = (start+end)/2;
        update(start,mid,node * 2, index, value);
        update(mid+1,end,node * 2 + 1,index,value);
    }

    public static long get(int start, int end, int node ,int left, int right){
        if(start>right || end<left){
            return 0;
        }
        if(start>=left&&end<=right){
            return tree[node];
        }
        int mid = (start+end)/2;
        return get(start,mid,node*2,left,right) + get(mid + 1,end , node * 2 + 1 , left, right);
    }




}