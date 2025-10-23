import java.util.*;
import java.io.*;
public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] pibo = new int[46];
        pibo[0] = 1;
        pibo[1] = 1;
        for(int i = 2 ; i < 46 ; i++){
            pibo[i] = pibo[i-1] + pibo[i-2];
        }
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        for(int i = 0 ;  i < N ; i++){
            int num = Integer.parseInt(br.readLine());
            int index = 45;
            while (num > 0 && index >= 0){
                if(pibo[index] > num){
                    index--;
                }
                else{
                    num -= pibo[index];
                    stack.push(pibo[index]);
                    index--;
                }
            }
            while (!stack.isEmpty()){
                sb.append(stack.pop());
                if(!stack.isEmpty()){
                    sb.append(' ');
                }
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }

}