import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;


class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
            if(Math.abs(o1)<Math.abs(o2)){
                return -1;
            }
            else if(Math.abs(o1)==Math.abs(o2)){
                return o1<o2?-1:1;
            }
            else{
                return 1;
            }
        });
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < N ; i++){
            int x = Integer.parseInt(br.readLine());
            if(x==0){
                if(pq.isEmpty()){
                    sb.append("0\n");
                }
                else{
                    sb.append(pq.poll()+"\n");
                }
            }
            else{
                pq.add(x);
            }
        }
        System.out.println(sb);

    }
}