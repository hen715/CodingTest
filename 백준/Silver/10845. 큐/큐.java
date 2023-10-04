import java.util.*;

public class Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int num = scanner.nextInt();
        Deque<Integer> queue = new LinkedList<>();
        for(int i = 0 ; i <num ; i++){
            String order = scanner.next();
            if(order.equals("push")){
                int a = scanner.nextInt();
                queue.add(a);
            }
            else if(order.equals("front")){
                if(queue.isEmpty())
                    sb.append("-1\n");
                else
                    sb.append(queue.peek()+"\n");
            }
            else if(order.equals("back")){
                if(queue.isEmpty())
                    sb.append("-1\n");
                else
                    sb.append(queue.getLast()+"\n");
            }
            else if(order.equals("size")){
                sb.append(queue.size()+"\n");
            }
            else if(order.equals("empty")){
                if(queue.isEmpty()){
                    sb.append("1\n");
                }
                else
                    sb.append("0\n");
            }
            else if(order.equals("pop")) {
                if(queue.isEmpty())
                    sb.append("-1\n");
                else
                    sb.append(queue.poll()+"\n");
            }
        }
        System.out.println(sb);
    }
}