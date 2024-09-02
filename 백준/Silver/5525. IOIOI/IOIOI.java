import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[] pi = new int[1 + 2 * N];
        String S = br.readLine();
        StringBuilder sb = new StringBuilder();
        sb.append("I");
        sb.append("OI".repeat(N));
        String pattern = sb.toString();

        int index = 0;

        for(int i = 1 ;i < 1 + 2 *N ; i++ ){

            while(index > 0  && pattern.charAt(i) != pattern.charAt(index)){
                index = pi[index -1];
            }
            if(pattern.charAt(i)==pattern.charAt(index)){
                index++;
                pi[i] = index;
            }
        }

        index = 0;
        int count = 0;
        for(int i = 0 ; i < M ; i++){
            while (index > 0 && S.charAt(i)!=pattern.charAt(index)){
                index = pi[index - 1];
            }
            if(S.charAt(i)==pattern.charAt(index)){
                if(index == pattern.length() - 1){
                    count++;
                    index = pi[index];
                }else{
                    index++;
                }
            }
        }
        System.out.println(count);

    }
}