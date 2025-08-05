import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for(int T = 1 ; T <= 10 ; T++){
            int d= Integer.parseInt(br.readLine());
            int[] list = new int[100];
            String[] s = br.readLine().split(" ");
            for(int i = 0 ; i < 100 ; i++){
                list[i] = Integer.parseInt(s[i]);
            }
            int max = 0;
            int min = 0;
            for(int a = 0 ; a < d ; a++) {
                for (int i = 0; i < 100; i++) {
                    if (list[i] > list[max]) {
                        max = i;
                    }
                    if (list[i] < list[min]) {
                        min = i;
                    }
                }
                if (list[max] == list[min]) {
                    break;
                }
                list[max]--;
                list[min]++;
            }
            for (int i = 0; i < 100; i++) {
                if (list[i] > list[max]) {
                    max = i;
                }
                if (list[i] < list[min]) {
                    min = i;
                }
            }
            sb.append('#').append(T).append(' ').append(list[max]-list[min]);
            if(T!=10){
                sb.append('\n');
            }
        }
        System.out.print(sb);
    }
}