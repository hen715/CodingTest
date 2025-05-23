import java.io.*;


class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);
        int[][] list = new int[N + 1][2];
        s = br.readLine().split(" ");

        int sum = 0;
        for(int i = 1 ; i < N + 1 ; i++){
            list[i][0] = Integer.parseInt(s[i-1]);
        }
        s = br.readLine().split(" ");
        for(int i = 1 ; i < N + 1 ; i++){
            list[i][1] = Integer.parseInt(s[i-1]);
            sum += Integer.parseInt(s[i-1]);
        }
        int[][] memory = new int[N+1][sum+1];
        for(int i = 1 ; i <N + 1 ; i++){
            for(int j = 0 ; j < sum + 1 ; j++){
                if(list[i][1]>j){
                    memory[i][j] = memory[i-1][j];
                }
                else{
                    memory[i][j] = Math.max(memory[i - 1][j], memory[i - 1][j - list[i][1]] + list[i][0]);
                }
            }
        }
        for(int i = 0; i < sum + 1; i++){
            if(memory[N][i]>=M){
                System.out.print(i);
                break;
            }
        }
    }

}