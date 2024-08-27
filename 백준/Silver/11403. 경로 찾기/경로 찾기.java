import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


class Main {
    public static void init(int[][] distance,int N){
        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < N ; j++){
                distance[i][j] = Integer.MAX_VALUE;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] distance = new int[N][N];
        init(distance,N);
        String[] s;
        for(int i = 0; i < N ; i++){
            s =  br.readLine().split(" ");
            for(int j = 0; j < N ; j++) {
                if(Integer.parseInt(s[j])==1){
                    distance[i][j] = 1;
                }
            }
        }
        for(int k = 0 ; k < N ; k++){
            for(int i = 0 ; i < N ; i++){
                for(int j = 0 ; j < N ; j++){
                    if(distance[i][k] !=Integer.MAX_VALUE && distance[k][j]!=Integer.MAX_VALUE){
                        distance[i][j] = Math.min(distance[i][j],distance[i][k] + distance[k][j]);
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();


        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < N ; j++){
                if(distance[i][j]!=Integer.MAX_VALUE){
                    sb.append(1+" ");
                }
                else {
                    sb.append(0+" ");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);

    }

}