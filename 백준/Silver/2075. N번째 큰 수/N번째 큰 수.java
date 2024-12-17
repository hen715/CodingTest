import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2-o1);
        int N = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < N ; i++){
            String[] s = br.readLine().split(" ");
            for(int j = 0 ; j < N ; j++){
                queue.add(Integer.parseInt(s[j]));
            }
        }
        for(int i = 0 ; i < N-1 ; i++){
            queue.poll();
        }
        System.out.println(queue.poll());



    }


}