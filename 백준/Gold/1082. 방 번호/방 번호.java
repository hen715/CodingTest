import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] list = new int[N];
        String[] s = br.readLine().split(" ");
        StringBuilder sb = new StringBuilder();
        int min1 = 0;
        for(int i = 0 ; i < N ; i++){
           list[i] = Integer.parseInt(s[i]);
           if(list[min1]>=list[i]){
               min1 = i;
           }
        }
        int M = Integer.parseInt(br.readLine());
        int min2 = 1;
        for(int i = 1 ; i < N ; i++){
            if(list[min2]>=list[i]){
                min2 = i;
            }
        }
        if(min1==0){
            if(N==1||list[min2]>M){
                System.out.print(0);
                System.exit(0);
            }
            M -= list[min2];
            sb.append(min2);
        }
        while (M-list[min1]>=0){
            M -= list[min1];
            sb.append(min1);
        }
        int index = 0;
        while (M>0&&index<sb.length()){
            for(int i = N-1 ; i > sb.charAt(index) - '0'; i--) {
                if (list[i] - list[sb.charAt(index) - '0']  <= M) {
                    M -= list[i] - list[sb.charAt(index) - '0'];
                    sb.setCharAt(index, (char) (i+'0'));
                    break;
                }
            }
            index++;
        }
        System.out.print(sb);

    }


}