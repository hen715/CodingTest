import java.io.*;
import java.util.Stack;


class Main {



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[][] list = new int[N + 1][N + 1];
        int[][] route = new int[N + 1][N + 1];
        String[] s;
        for(int i = 1; i < N + 1 ; i++){
            for(int j = 1 ; j < N + 1 ; j++){
                route[i][j] = -1;
                if(i!=j){
                    list[i][j] = 1000000000;
                }
            }
        }
        for(int i = 0 ; i < M ; i++){
            s = br.readLine().split(" ");
            int start = Integer.parseInt(s[0]);
            int end = Integer.parseInt(s[1]);
            list[start][end] = Math.min(Integer.parseInt(s[2]),list[start][end]);
            route[start][end] = start;
        }

        for(int k = 1 ; k < N+ 1 ; k++){
            for(int i = 1 ; i < N +1 ; i++){
                for(int j = 1 ; j < N + 1; j++){
                    if(list[i][j]>list[i][k]+list[k][j]){
                        list[i][j] = list[i][k]+list[k][j];
                        route[i][j] = route[k][j];
                    }
                }
            }
        }
        for(int i = 1 ; i < N + 1 ; i++){
            for(int j = 1 ; j < N + 1 ; j++){
                if(list[i][j] == 1000000000){
                    sb.append(0).append(" ");
                }
                else{
                    sb.append(list[i][j]).append(" ");
                }
            }
            sb.append("\n");
        }
        for(int i = 1 ; i < N +1 ; i++){
            for(int j = 1 ; j < N +1 ; j++){
                if(route[i][j]==-1){
                    sb.append(0).append("\n");
                }
                else {
                    Stack<Integer> stack = new Stack<>();
                    stack.push(j);
                    int pre = j;
                    while (i != route[i][pre]) {
                        pre = route[i][pre];
                        stack.push(pre);
                    }
                    sb.append(stack.size() + 1).append(" ").append(i).append(" ");
                    while (!stack.isEmpty()) {
                        sb.append(stack.pop()).append(" ");
                    }
                    sb.append("\n");
                }
            }
        }

        System.out.println(sb);


    }
}