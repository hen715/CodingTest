import java.util.*;

public class Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int num = scanner.nextInt();
        Deque<Integer> queue = new LinkedList<>();
        for(int i = 0 ; i <num ; i++){
            String order = scanner.next();
            if(order.equals("push_back")){
                int a = scanner.nextInt();
                queue.addLast(a);
            }
            else if(order.equals("push_front")){
                int a = scanner.nextInt();
                queue.addFirst(a);
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
            else if(order.equals("pop_front")) {
                if(queue.isEmpty())
                    sb.append("-1\n");
                else
                    sb.append(queue.pollFirst()+"\n");
            }
            else if(order.equals("pop_back")) {
                if(queue.isEmpty())
                    sb.append("-1\n");
                else
                    sb.append(queue.pollLast()+"\n");
            }
        }
        System.out.println(sb);
    }
}