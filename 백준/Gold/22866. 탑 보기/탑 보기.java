import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    static class Node{
        int num;
        int h;
        public Node(int num, int h){
            this.num = num;
            this.h = h;
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
        int[][] result = new int[N][2];
        for(int i = 0 ; i < N ; i++){
            result[i][1] = Integer.MAX_VALUE;
        }
        for(int i = 0 ; i < N ; i++){
            while (!stack.isEmpty() && stack.peek().h <= list[i]){
                stack.pop();
            }
            if(!stack.isEmpty()){
                result[i][0] += stack.size();
                if(Math.abs(i-result[i][1])>Math.abs(i - stack.peek().num)){
                    result[i][1] = stack.peek().num;
                }
                else if(Math.abs(i-result[i][1]) == Math.abs(i - stack.peek().num)){
                    result[i][1] = Math.min(result[i][1], stack.peek().num);
                }
            }
            stack.push(new Node(i,list[i]));
        }
        stack.clear();
        for(int i = N - 1 ; i >=0 ; i--){
            while (!stack.isEmpty() && stack.peek().h <= list[i]){
                stack.pop();
            }
            if(!stack.isEmpty()){
                result[i][0] += stack.size();
                if(Math.abs(i-result[i][1])>Math.abs(i - stack.peek().num)){
                    result[i][1] = stack.peek().num;
                }
                else if(Math.abs(i-result[i][1]) == Math.abs(i - stack.peek().num)){
                    result[i][1] = Math.min(result[i][1], stack.peek().num);
                }
            }
            stack.push(new Node(i,list[i]));
        }
        StringBuilder sb= new StringBuilder();
        for(int i = 0 ; i < N ; i++){
            if(result[i][0]==0){
                sb.append(0);
            }
            else{
                sb.append(result[i][0]).append(' ').append(result[i][1] + 1);
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }
}