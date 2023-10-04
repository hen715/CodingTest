import java.util.*;

public class Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int num = scanner.nextInt();
        scanner.nextLine();
        for(int i = 0 ; i<num; i++){
            boolean a = true;
            String str = scanner.nextLine();
            Stack<Character> stack = new Stack<>();
            for(int j = 0 ; j<str.length();j++){
                if(str.charAt(j)=='(')
                    stack.push('(');
                else{
                    if(!stack.empty()&&stack.peek()=='(')
                        stack.pop();
                    else{
                        a = false;
                        break;
                    }

                }
            }

            if(a&&stack.empty())
                sb.append("YES\n");
            else
                sb.append("NO\n");
        }
        System.out.println(sb);
    }
}