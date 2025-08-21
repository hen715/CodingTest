import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int t = 1 ; t <= T ; t++) {
            String[] s = br.readLine().split(" ");
            int N = Integer.parseInt(s[0]);
            int M = Integer.parseInt(s[1]);
            int num = M & ((1<<N)-1);
            sb.append('#').append(t).append(' ');
            if(num == (1<<N)-1){
              sb.append("ON");
            }
            else{
                sb.append("OFF");
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }

}