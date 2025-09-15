import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());
            String[] s = br.readLine().split(" ");
            int point;
            if(s.length%2==0){
                point = s.length/2;
            }
            else{
                point = s.length/2 + 1;
            }
            for(int i = 0 ; i < point ; i++){
                sb2.append(s[i]).append(' ');
                if(i + point < s.length){
                    sb2.append(s[i + point]).append(' ');
                }
            }

            sb.append('#').append(t).append(' ').append(sb2);
            if (t != T) sb.append('\n');
            sb2.setLength(0);
        }

        System.out.print(sb);
    }
    
}