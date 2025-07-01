import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;


public class Main {
    static class Item{
        int M;
        int V;
        public Item(int M, int V){
            this.M = M;
            this.V = V;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int K = Integer.parseInt(s[1]);
        PriorityQueue<Item> pq = new PriorityQueue<>(((o1, o2) -> o1.M- o2.M));
        for(int i = 0 ; i < N ; i++){
            s = br.readLine().split(" ");
            pq.add(new Item(Integer.parseInt(s[0]), Integer.parseInt(s[1])));
        }
        int[] back = new int[K];
        for(int i = 0 ; i < K ; i++){
            back[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(back);
        PriorityQueue<Item> q = new PriorityQueue<>((o1, o2) -> o2.V - o1.V);
        long sum = 0;
        for(int b : back){
            while (!pq.isEmpty()&&pq.peek().M<=b){
                q.add(pq.poll());
            }
            if(!q.isEmpty()){
                sum += q.poll().V;
            }
        }
        System.out.print(sum);
    }

}