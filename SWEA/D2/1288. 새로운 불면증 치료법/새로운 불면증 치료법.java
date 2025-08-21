import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int t = 1 ; t <= T ; t++) {
            int N = Integer.parseInt(br.readLine());
            int visit = 0;
            int count = 0;
            int now = N;
            while (visit!=(1<<10)-1) {
                int num = now;
                while (num > 0){
                    visit = visit | (1<<(num%10));
                    num /= 10;
                }
                now += N;
                count++;
            }

            sb.append('#').append(t).append(' ').append(count * N).append('\n');


        }
        System.out.print(sb);
    }

}