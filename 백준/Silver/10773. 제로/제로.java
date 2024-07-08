import java.util.Scanner;
import java.util.Stack;

public class Main {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();
        int num = scanner.nextInt();
        for(int i = 0 ; i < num;i++ ){
            int a = scanner.nextInt();
            if(a!=0){
                stack.push(a);
            }
            else{
                stack.pop();
            }
        }
        int sum = 0;
        while (!stack.empty()){
            sum += stack.pop();
        }
        System.out.println(sum);
    }
}