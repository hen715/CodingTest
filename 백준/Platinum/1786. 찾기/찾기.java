import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String T = br.readLine();
        String P = br.readLine();
        int[] pi = new int[P.length()];
        int j = 0;
        for(int i = 1 ; i < P.length() ; i++){
               while (P.charAt(i)!=P.charAt(j) && j>0){
                   j = pi[j - 1];
               }
               if(P.charAt(i)==P.charAt(j)){
                   pi[i] = ++j;
               }
        }
        j = 0;
        int count = 0;
        StringBuilder sb= new StringBuilder();
        for(int i = 0 ; i < T.length() ; i++){
            while (T.charAt(i) != P.charAt(j) && j > 0){
                j = pi[j - 1];
            }
            if(T.charAt(i)==P.charAt(j)){
                if(j==P.length() - 1){
                    count++;
                    sb.append(i-j + 1).append(' ');
                    j = pi[j];
                }
                else {
                    j++;
                }
            }
        }
        System.out.println(count);
        System.out.print(sb);
    }
}