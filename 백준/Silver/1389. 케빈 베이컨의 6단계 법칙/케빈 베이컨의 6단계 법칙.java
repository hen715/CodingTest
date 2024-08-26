import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


class Main {
    public static void init(int[][] distance,int N){
        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < N ; j++){
                if(i==j){
                    distance[i][j] = 0;
                }
                else{
                    distance[i][j] = Integer.MAX_VALUE;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);
        int[][] distance = new int[N][N];
        init(distance,N);
        for(int i = 0; i < M ; i++){
            s = br.readLine().split(" ");
            distance[Integer.parseInt(s[0])-1][Integer.parseInt(s[1])-1] = 1;
            distance[Integer.parseInt(s[1])-1][Integer.parseInt(s[0])-1] = 1;
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

        int min = Integer.MAX_VALUE;
        int index = 0;
        for(int i = N-1 ; i >=0 ; i--){
            int sum = 0;
            for(int j = N-1 ; j >=0 ; j--){
                sum += distance[i][j];
            }
            if(sum<=min){
                min = sum;
                index = i;
            }
        }
        System.out.println(index+1);

    }

}