import java.io.*;

public class Main {
    static int[] parent;
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        parent = new int[N];
        for(int i = 0 ; i < N ; i++){
            parent[i] = i;
        }
        String[] s;
        for(int i = 0 ; i < N ; i++){
            s = br.readLine().split(" ");
            for(int a = 0 ; a < s.length ; a++){
                if(s[a].equals("1")){
                    union(i,a);
                }
            }
        }
        if(N>1) {
            s = br.readLine().split(" ");
            int p = getParent(Integer.parseInt(s[0])-1);
            for (int i = 0; i < M; i++) {
                if (p != getParent(Integer.parseInt(s[i]) - 1)) {
                    System.out.print("NO");
                    System.exit(0);
                }
            }
            System.out.print("YES");
        }
        else{
            s = br.readLine().split(" ");
            System.out.print("YES");
        }
    }

    public static void union(int num1, int num2){
        int p1 = getParent(num1);
        int p2 = getParent(num2);
        if (p1 != p2) {
            parent[p2] = p1;
        }
    }

    public static int getParent(int num){
        if(parent[num]==num){
            return num;
        }
        return parent[num] = getParent(parent[num]);
    }

}