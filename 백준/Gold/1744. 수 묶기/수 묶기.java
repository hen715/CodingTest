import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] list = new int[N];
        for(int i = 0 ; i < N ; i++){
            list[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(list);
        int index = 0;
        int sum = 0;
        while (index<N&&list[index]<0){
            if(N > index + 1&&list[index+1]<=0){
                sum += list[index] * list[index+1];
                index +=2 ;
            }
            else{
                sum += list[index];
                index++;
            }

        }
        while (index<N&&list[index]<2){
            if(list[index]==1){
                sum++;
            }
            index++;
        }
        if((N-index)%2!=0){
            sum += list[index];
            index++;
        }
        for(int i = index ; i < N ; i+=2){
            sum += list[i] * list[i+1];
        }
        System.out.print(sum);
    }
}