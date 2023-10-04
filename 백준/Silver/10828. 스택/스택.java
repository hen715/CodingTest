import java.util.*;

public class Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int num = scanner.nextInt();
        Stack<Integer> stack = new Stack<>();
        for(int i = 0 ; i <num ; i++){
            String order = scanner.next();
            if(order.equals("push")){
                int a = scanner.nextInt();
                stack.push(a);
            }
            else if(order.equals("top")){
                if(stack.empty())
                    sb.append("-1\n");
                else
                    sb.append(stack.peek()+"\n");
            }
            else if(order.equals("size")){
                sb.append(stack.size()+"\n");
            }
            else if(order.equals("empty")){
                if(stack.empty()){
                    sb.append("1\n");
                }
                else
                    sb.append("0\n");
            }
            else if(order.equals("pop")) {
                if(stack.empty())
                    sb.append("-1\n");
                else
                    sb.append(stack.pop()+"\n");
            }
        }
        System.out.println(sb);
    }
}