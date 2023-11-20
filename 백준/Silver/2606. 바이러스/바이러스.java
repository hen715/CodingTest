import java.util.*;

public class Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n  = scanner.nextInt();
        int m = scanner.nextInt();
        n++;
        int[] visited = new int[n];
        Stack<Integer> stack = new Stack<>();
        int[][] com = new int[n][n];
        for(int i = 0 ; i<n;i++){
            for(int j = 0 ; j < n; j++)
                com[i][j] =0;
        }
        for(int i = 0 ; i < m ; i++){
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            com[a][b] = 1;
            com[b][a] =1;
        }
        int count = -1;
        stack.push(1);
        while (!stack.empty()){
            int s = stack.pop();
            if(visited[s]!=1) {
                visited[s] = 1;
                count++;
                for (int i = 1; i < n; i++) {
                    if (com[s][i] == 1) {
                        stack.push(i);
                    }
                }
            }
        }
        System.out.println(count);


    }


}