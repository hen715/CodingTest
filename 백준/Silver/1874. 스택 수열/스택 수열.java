import java.io.*;
import java.util.Stack;

class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int num = Integer.parseInt(br.readLine());
        int[] list = new int[num];
        for(int i = 0 ; i < num ; i++){
            list[i] = Integer.parseInt(br.readLine());
        }

        Stack<Integer> stack = new Stack<>();
        int count = 1;
        int index = 0;
        while(index<num){
            if(list[index]>count){
                sb.append("+\n");
                stack.push(count);
                count++;
            }
            else if(list[index]<count){
                while (!stack.empty()){
                    int s = stack.pop();
                    sb.append("-\n");
                    if (s==list[index]){
                        index++;
                        break;
                    }
                    else if(s >list[index]){
                        System.out.println("NO");
                        return;
                    }
                }
            }
            else{
                stack.push(count);
                stack.pop();
                sb.append("+\n");
                sb.append("-\n");
                count++;
                index++;
            }
        }
        System.out.println(sb);


    }

}