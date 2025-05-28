import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);
        parent = new int[N + 1];
        for(int i = 1; i < N + 1 ; i++){
            parent[i] = i;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < M ; i++){
            s = br.readLine().split(" ");
            int a = Integer.parseInt(s[1]);
            int b = Integer.parseInt(s[2]);
            if(Integer.parseInt(s[0])==0){
                union(a,b);
            }
            else {
                if(getParent(a)==getParent(b)){
                    sb.append("YES").append('\n');
                }
                else{
                    sb.append("NO").append('\n');
                }
            }
        }
        System.out.print(sb);
    }
    public static int getParent(int num){
        if(num==parent[num]){
            return num;
        }
        return parent[num] = getParent(parent[num]);
    }

    public static void union(int num1, int num2){
        int parent1 = getParent(num1);
        int parent2 = getParent(num2);
        if(parent1<parent2){
            parent[parent1] = parent2;
        }
        else{
            parent[parent2] = parent1;
        }

    }
}