import java.io.*;
import java.util.PriorityQueue;

class Main {



    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2-o1);
        for(int i = 0 ; i < n ; i++){
            int num = Integer.parseInt(br.readLine());
            if(num==0){
                if(queue.isEmpty()){
                    sb.append("0\n");
                }
                else{
                    sb.append(queue.poll()+"\n");
                }
            }
            else{
                queue.add(num);
            }
        }
        System.out.println(sb);

    }
}