import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static StringBuilder sb;
    public static int n;
    public static int m;
    public static int[] arr;

    public static void combination(int[] arr, boolean[] visited, int r) {
        if(r == m) {
            for(int i = 0 ; i<m;i++){
                sb.append(arr[i]+" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=0; i<n; i++) {
            if(visited[i])continue;
            visited[i] = true;
            arr[r]=i+1;
            combination(arr, visited,r + 1);
            visited[i] = false;
        }
    }



    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        String[] s = bf.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);

        arr = new int[n];
        boolean[] visited = new boolean[n];




        combination(arr,visited,0);
        System.out.println(sb);




    }
}