import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int[][] list = new int[num][2];

        for(int i = 0 ; i < num; i++){
            String[] s = br.readLine().split(" ");
            list[i][0] = Integer.parseInt(s[0]);
            list[i][1] = Integer.parseInt(s[1]);
        }
        Arrays.sort(list,(o1, o2) -> o1[1]-o2[1]==0?o1[0]-o2[0]:o1[1]-o2[1]);
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < num ; i++){
            sb.append(list[i][0]+" "+list[i][1]+"\n");
        }
        System.out.println(sb);


    }
}