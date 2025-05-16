import java.io.*;


class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int[] list = new int[N];
        String[] s = br.readLine().split(" ");
        for(int i = 0 ; i < N ; i++){
            list[i] = Integer.parseInt(s[i]);
        }
        int M = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < M ; i++){
            s = br.readLine().split(" ");
            int S = Integer.parseInt(s[0]) - 1;
            int E = Integer.parseInt(s[1]) - 1;
            boolean flag = true;
            while (S<E){
                if(list[S]==list[E]){
                    S++;
                    E--;
                }
                else{
                    flag = false;
                    break;
                }

            }
            if(flag){
                sb.append(1).append("\n");
            }
            else{
                sb.append(0).append("\n");
            }
        }
        System.out.print(sb);
    }
}