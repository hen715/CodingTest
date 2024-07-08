import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringBuilder sb = new StringBuilder();
        while (!s.equals(".")){
            Stack<Character> stack = new Stack<>();
            for(int i = 0 ; i<s.length();i++){
                if(s.charAt(i)=='('){
                    stack.push(s.charAt(i));
                } else if (s.charAt(i)=='[') {
                    stack.push(s.charAt(i));
                } else if (s.charAt(i)==']') {
                    if(!stack.empty()&&stack.peek()=='['){
                        stack.pop();
                    }
                    else{
                        stack.push(s.charAt(i));
                    }
                }
                else if (s.charAt(i)==')'){
                    if(!stack.empty()&&stack.peek()=='('){
                        stack.pop();
                    }
                    else{
                        stack.push(s.charAt(i));
                    }
                }
            }
            if(stack.empty()){
                sb.append("yes\n");
            }
            else{
                sb.append("no\n");
            }
            s = br.readLine();
        }
        System.out.println(sb);
    }
}