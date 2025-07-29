import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int N;
    static int[][] like;
    static int[][] list;
    static int x = 0;
    static int y = 0;
    static int count = 0;
    static int em = 0;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        like = new int[N * N ][5];
        String[] s;
        for(int i = 0 ; i < N * N ; i++){
            s = br.readLine().split(" ");
            like[i][0] = Integer.parseInt(s[0]);
            for(int j = 1 ; j < s.length ; j++){
                like[i][j] = Integer.parseInt(s[j]);
            }
        }
        list = new int[N][N];

        for(int i = 0 ; i < N * N ; i++){
            x = -1;
            y = -1;
            count = -1;
            em = -1;
            for(int a = 0 ; a < N ; a++){
                for(int b = 0; b < N ; b++) {
                    if (list[a][b] == 0) {
                        int c = calc(i, a, b);
                        int empty = calcEmpty(a,b);
                        if(x==-1){
                            x = a;
                            y = b;
                            count = c;
                            em = empty;
                        }
                        else {
                            if (c == count) {
                                if (em == empty) {
                                    if (x == a) {
                                        if (y > b) {
                                            x = a;
                                            y = b;
                                        }
                                    } else if (x > a) {
                                        x = a;
                                        y = b;
                                    }
                                } else if (em < empty) {
                                    x = a;
                                    y = b;
                                    em = empty;
                                }
                            } else if (c > count) {
                                count = c;
                                x = a;
                                y = b;
                                em = empty;
                            }
                        }
                    }
                }
            }
            list[x][y] = like[i][0];
        }
        System.out.print(countPoint());

    }
    public static int calc(int num, int x, int y){
        int c = 0;
        for(int i = 0 ; i < 4 ; i++){
            int ddx = x + dx[i];
            int ddy = y + dy[i];
            if(ddx>=0&&ddx<N&&ddy>=0&&ddy<N&&list[ddx][ddy]!=0){
                for(int a = 1 ; a < 5 ; a++){
                    if(like[num][a]==list[ddx][ddy]){
                        c++;
                        break;
                    }
                }
            }
        }
        return c;
    }

    public static int calcEmpty(int x, int y){
        int c = 0;
        for(int i = 0 ; i < 4 ; i++){
            int ddx = x + dx[i];
            int ddy = y + dy[i];
            if(ddx>=0&&ddx<N&&ddy>=0&&ddy<N&&list[ddx][ddy]==0){
                c++;
            }
        }
        return c;
    }

    public static int countPoint(){
        int sum = 0;
        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < N ; j++){
                for(int a = 0 ; a < N * N ; a++){
                    if(like[a][0]==list[i][j]){
                        int point = calc(a, i, j);
                        if(point==1){
                            sum += 1;
                        }
                        else if(point==2){
                            sum += 10;
                        }
                        else if(point==3){
                            sum += 100;
                        }
                        else if(point==4){
                            sum += 1000;
                        }
                        break;
                    }
                }

            }
        }
        return sum;
    }
}