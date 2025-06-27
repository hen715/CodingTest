import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] list = new int[N];
        String[] s = br.readLine().split(" ");
        for(int i = 0 ; i < N ; i++){
            list[i] = Integer.parseInt(s[i]);
        }
        int S = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < N && S>0 ;i++){
            int index = i;
            for(int j = i+1 ; j < N && j-i<=S ; j++){
                if(list[j]>list[index]){
                    index = j;
                }
            }
            if(index!=i){
                for(int j = index ; j > i ; j--){
                    int temp = list[j];
                    list[j] = list[j-1];
                    list[j-1] = temp;
                    S--;
                }
            }
        }
        for(int a = 0 ; a < N ; a++){
            sb.append(list[a]).append(' ');
        }
        System.out.print(sb);
    }

}