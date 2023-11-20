import java.util.*;

public class Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = scanner.nextInt();
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i = 0 ; i<n;i++){
            int a = scanner.nextInt();
            if(a==0){
                if(queue.isEmpty()){
                    sb.append("0\n");
                }
                else{
                    sb.append(queue.remove()+"\n");
                }
            }
            else{
                queue.add(a);
            }
        }
        System.out.println(sb);

    }

}