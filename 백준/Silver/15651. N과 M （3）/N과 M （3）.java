import java.io.*;


class Main {
    static int N;
    static int M;
    static StringBuilder sb;
    static int[] path;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        sb = new StringBuilder();
        path = new int[M];
        search(0);
        System.out.print(sb);
    }

    public static void search(int depth){
        if(depth==M){
            for(int i : path){
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i = 1 ; i <= N ; i++){
            path[depth] = i;
            search(depth + 1);
        }
    }
}