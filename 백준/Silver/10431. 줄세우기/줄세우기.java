import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int P = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < P ; i++){
            String[] s = br.readLine().split(" ");
            int[] list = new int[20];
            int back = 0;
            for(int j = 1; j < 21 ; j++){
                list[j-1] = Integer.parseInt(s[j]);
                int k = j-1;
                while (k>0&&list[k-1]>list[k]){
                    int temp = list[k];
                    list[k] = list[k-1];
                    list[k-1] = temp;
                    back++;
                    k--;
                }
            }
            sb.append(s[0]).append(" ").append(back).append("\n");
        }
        System.out.print(sb);

    }


}