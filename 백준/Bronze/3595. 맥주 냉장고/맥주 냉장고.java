import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int min = Integer.MAX_VALUE;
        int N = Integer.parseInt(br.readLine());
        int[] answer = new int[3];
        for(int i = 1 ; i <= N ; i++){
            for(int j = 1 ; j <= N ; j++){
                if(i*j>N){
                    break;
                }
                for(int k = 1 ; k <= N ; k++){
                    if(i*j*k>N){
                        break;
                    }
                    if(i*j*k==N && min > 2*(i*j+j*k+i*k)){
                        min = 2*(i*j+j*k+i*k);
                        answer[0] = i;
                        answer[1] = j;
                        answer[2] = k;
                    }

                }
            }
        }
        for(int i : answer){
            System.out.print(i+" ");
        }
    }
}