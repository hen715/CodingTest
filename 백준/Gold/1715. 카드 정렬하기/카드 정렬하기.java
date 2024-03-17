import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for(int i = 0 ; i<n ; i++){
            q.add(Integer.parseInt(bf.readLine()));
        }
        int sum =0;
        while(q.size()!=1){
            int temp = q.poll();
            temp += q.poll();
            sum += temp;
            q.add(temp);

        }
        System.out.println(sum);
    }
}