import java.io.*;



class Main {



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);
        int[][] list = new int[N+1][N+1];
        for(int i = 1 ; i < N + 1 ;i++){
            for(int j = 1 ; j < N + 1 ; j++){
                list[i][j] = 1000000000;
            }
        }

        for(int i = 0 ; i < M ; i++){
            s = br.readLine().split(" ");
            int x = Integer.parseInt(s[0]);
            int y = Integer.parseInt(s[1]);
            int cost = Integer.parseInt(s[2]);
            list[x][y] = cost;
        }

        for(int k = 1 ; k < N+1; k++){
            for(int i = 1 ; i < N +1 ; i++){
                for(int j = 1 ; j < N +1 ; j++){
                    list[i][j] = Math.min(list[i][j],list[i][k] + list[k][j]);
                }
            }
        }
        int min = 1000000000;
        for(int i = 1 ; i < N+1 ;i++){
            if(list[i][i]<min){
                min = list[i][i];
            }
        }
        if(min==1000000000){
            System.out.println(-1);
        }
        else {
            System.out.println(min);
        }
    }
}