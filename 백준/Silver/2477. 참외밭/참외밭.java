import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] list = new int[6][2];
        for(int i = 0 ; i < 6 ; i++){
            String[] s = br.readLine().split(" ");
            list[i][0] = Integer.parseInt(s[0]);
            list[i][1] = Integer.parseInt(s[1]);
        }
        int index = 0;
        for(int i = 0 ; i < 6 ; i++){
            if(list[i][0]==list[(i+2)%6][0]&&list[(i+1)%6][0]==list[(i+3)%6][0]){
                index = i;
                break;
            }
        }
        System.out.print((list[(index+4)%6][1] * list[(index+5)%6][1] - list[(index+1)%6][1] * list[(index+2)%6][1]) * N);
    }
}