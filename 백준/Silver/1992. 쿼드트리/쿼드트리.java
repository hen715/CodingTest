import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    static StringBuilder sb;
    static int[][] list;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        list = new int[N][N];
        sb = new StringBuilder();
        for(int i = 0 ; i < N ; i++){
            String s = br.readLine();
            for(int j = 0 ; j < N ; j++){
                list[i][j] = s.charAt(j) - 48;
            }
        }
        check(0,0, N);
        System.out.print(sb);
    }
    public static void check(int x, int y, int size){
        int value = list[x][y];
        boolean isSame = true;
        for(int i = x ; i < x + size; i++){
            for(int j = y ; j < y + size ; j++){
                if(list[i][j]!=value){
                    isSame = false;
                    break;
                }
            }
        }
        if(isSame){
            sb.append(value);
        }
        if(!isSame){
            sb.append('(');
            check(x, y, size/2);
            check(x, y + size/2, size/2);
            check(x + size/2, y, size/2);
            check(x + size/2, y + size/2, size/2);
            sb.append(')');
        }
    }
}