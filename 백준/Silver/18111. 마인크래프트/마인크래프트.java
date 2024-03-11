import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] s = bf.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        int block = Integer.parseInt(s[2]);
        int[][] sand = new int[n][m];
        int time = 999999999;
        int last = 0;
        int up;
        int down;
        int minh = 600;
        int maxh = -1;
        for(int i = 0; i <n ; i++){
            s = bf.readLine().split(" ");
            for(int j = 0 ; j < m ; j++){
                sand[i][j] = Integer.parseInt(s[j]);
                if(maxh<Integer.parseInt(s[j])){
                    maxh = Integer.parseInt(s[j]);
                }
                if(minh>Integer.parseInt(s[j])){
                    minh = Integer.parseInt(s[j]);
                }
            }
        }
        for(int i = minh; i<=maxh;i++){
                up = 0;
                down = 0;
                for(int a=0;a<n;a++){
                    for(int b = 0 ; b < m ; b++){
                        if(sand[a][b]>i){
                            up += sand[a][b] - i;
                        }
                        else if(sand[a][b]<i){
                            down += i - sand[a][b];
                        }
                    }
                }
                if(block+up>=down){
                    if(time > down  + up * 2){
                        time = down  + up * 2;
                        last = i;
                    }
                    else if(time == down + up * 2){
                        last = i;
                    }
                }

            }

        System.out.println(time+" "+last);
    }
}