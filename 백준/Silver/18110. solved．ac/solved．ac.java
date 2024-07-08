import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int[] list = new int[num];
        for(int i = 0 ; i < num ; i++){
            list[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(list);
        int man = (int)Math.round(num * 0.15);
        int sum = 0;
        for(int i = man ; i < num-man;i++){
            sum += list[i];
        }

        sum = (int)Math.round((double)sum/(num-(2*man)));
        System.out.println(sum);
    }
}