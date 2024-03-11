import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(bf.readLine());
        int[][] apart = new int[15][15];
        for(int i = 0; i <15;i++){
            apart[0][i] = i+1;
        }
        for(int i = 1 ; i<15 ; i++){
            for(int j = 0 ; j<15;j++){
                int sum = 0;
                for(int k = 0 ; k<=j;k++){
                    sum += apart[i-1][k];
                }
                apart[i][j] = sum;
            }
        }
        for(int i = 0 ; i<count;i++){
            int k = Integer.parseInt(bf.readLine());
            int n = Integer.parseInt(bf.readLine());
            System.out.println(apart[k][n-1]);
        }
    }



}