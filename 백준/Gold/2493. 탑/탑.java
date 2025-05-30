import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;


public class Main {
    public static class Node{
        int index;
        int value;
        public Node(int index,int value){
            this.index = index;
            this.value = value;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] list = new int[N];
        String[] s = br.readLine().split(" ");
        for(int i = 0 ; i < N ; i++){
            list[i] = Integer.parseInt(s[i]);
        }
        Stack<Node> stack = new Stack<>();
        int[] answer = new int[N];
        stack.push(new Node(0,list[0]));
        for(int i = 1 ; i < N ; i++){
            while (!stack.isEmpty()&&stack.peek().value<=list[i]){
                stack.pop();
            }
            if(!stack.isEmpty()) {
                answer[i] = stack.peek().index + 1;
            }
            stack.push(new Node(i,list[i]));
        }
        StringBuilder sb = new StringBuilder();
        for(int i : answer){
            sb.append(i).append(' ');
        }
        System.out.print(sb);
    }

}