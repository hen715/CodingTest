import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");
        int[] list = new int[N];
        for(int i = 0 ; i < N ; i++){
            list[i] = Integer.parseInt(s[i]);
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(list[N-1]);
        list[N-1] = -1;
        if(N > 1){
            for(int i = N - 2 ; i >= 0 ; i --){
                while (!stack.isEmpty()&&list[i]>=stack.peek()){
                    stack.pop();
                }
                int temp = list[i];
                if(!stack.isEmpty()){
                    list[i] = stack.peek();
                }
                else{
                    list[i] = -1;
                }
                stack.push(temp);
            }
        }
        for(int i : list){
            sb.append(i).append(' ');
        }
        System.out.print(sb);
    }
}