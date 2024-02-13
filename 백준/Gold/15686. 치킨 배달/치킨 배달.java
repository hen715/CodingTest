import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int n;
    public static int m;
    public static int[][] list;
    public static Point[] arr;
    public static int count;
    public static int chickenDis;

    public static void combination(boolean[] visited,int start, int r) {
        if(r == 0) {
            calChicken(visited);
            return;
        }

        for(int i=start; i<count; i++) {
            visited[i] = true;
            combination(visited,i + 1,  r - 1);
            visited[i] = false;
        }
    }

    public static void calChicken(boolean[] visited){
        for(int i = 0 ; i<n;i++){
            for(int j = 0 ; j <n ; j++){
                if(list[i][j]==2){
                    list[i][j] = 0;
                }
            }
        }
        for(int i = 0 ; i<count ; i++){
            if(visited[i]){
                list[arr[i].x][arr[i].y]=2;
            }
        }
        int dis = 0;
        for(int i = 0 ; i<n;i++){
            for(int j = 0 ; j <n ; j++){
                if(list[i][j]==1){
                    int min = 999999999;
                    for(int a = 0 ; a<n;a++){
                        for(int b = 0 ; b <n ; b++){
                            if(list[a][b]==2){
                                min = Math.min(min,Math.abs(a-i)+Math.abs(b-j));
                            }
                        }
                    }
                    dis +=min;
                }
            }
        }
        chickenDis = Math.min(chickenDis,dis);

    }


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] s = bf.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);

        list= new int[n][n];
        arr = new Point[13];
        boolean[] visited = new boolean[13];
        count = 0;
        chickenDis = 999999999;

        for(int i = 0 ; i< n; i++){
            s= bf.readLine().split(" ");
            for(int j = 0 ; j< n ; j++){
                list[i][j] = Integer.parseInt(s[j]);
                if(Integer.parseInt(s[j])==2){
                    arr[count] = new Point(i,j);
                    count++;
                }
            }
        }

        combination(visited,0,m);
        System.out.println(chickenDis);




    }
}