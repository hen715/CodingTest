import java.io.*;



class Main {



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[][] list = new int[N+1][N+1];
        for(int i = 1 ; i < N + 1 ;i++){
            for(int j = 1 ; j < N + 1 ; j++){
                if(i!=j){
                    list[i][j] = 1000000000;
                }
            }
        }
        String[] s;
        for(int i = 0 ; i < M ; i++){
            s = br.readLine().split(" ");
            int x = Integer.parseInt(s[0]);
            int y = Integer.parseInt(s[1]);
            list[x][y] = Math.min(Integer.parseInt(s[2]),list[x][y]);
        }

        for(int k = 1 ; k < N+1; k++){
            for(int i = 1 ; i < N +1 ; i++){
                for(int j = 1 ; j < N +1 ; j++){
                    list[i][j] = Math.min(list[i][j],list[i][k] + list[k][j]);
                }
            }
        }
        for(int i = 1 ; i < N+1 ;i++){
            for(int j = 1 ; j < N + 1 ; j++){
                if(list[i][j]==1000000000){
                    sb.append(0).append(" ");
                }else {
                    sb.append(list[i][j]).append(" ");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);




    }



}