import java.io.*;
import java.util.Stack;


class Main {



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for(int i = 0 ; i < s.length() ; i++){
            if(s.charAt(i)=='('){
                stack.push(s.charAt(i));
            }
            else if(s.charAt(i)==')'){
                while (stack.peek()!='('){
                    sb.append(stack.pop());
                }
                stack.pop();
            }
            else if(s.charAt(i)=='*'||s.charAt(i)=='/'){
                while (!stack.isEmpty()&&(stack.peek()=='*'||stack.peek()=='/')){
                    sb.append(stack.pop());
                }
                stack.push(s.charAt(i));
            }
            else if(s.charAt(i)=='+'||s.charAt(i)=='-'){
                while (!stack.isEmpty()&&(stack.peek()=='+'||stack.peek()=='-'||stack.peek()=='*'||stack.peek()=='/')){
                    sb.append(stack.pop());
                }
                stack.push(s.charAt(i));
            }
            else{
                sb.append(s.charAt(i));
            }
        }
        while (!stack.isEmpty()){
            sb.append(stack.pop());
        }
        System.out.print(sb);
    }

}