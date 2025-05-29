import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int C = Integer.parseInt(s[1]);
        int[] list = new int[N];
        for(int i = 0 ; i < N ; i++){
            list[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(list);
        int start = 1;
        int end = list[N-1] - list[0];
        int answer = 0;
        while (start<=end){
            int mid = (start+end)/2;
            int count = 1;
            int now = list[0];
            for(int i = 1 ; i < N ; i++){
                if(list[i] - now >= mid){
                    count++;
                    now = list[i];
                }
            }
            if(count>=C){
                if(answer < mid){
                    answer = mid;
                }
                start = mid +1;
            }
            else{
                end = mid -1;
            }
        }
        System.out.print(answer);
    }

}