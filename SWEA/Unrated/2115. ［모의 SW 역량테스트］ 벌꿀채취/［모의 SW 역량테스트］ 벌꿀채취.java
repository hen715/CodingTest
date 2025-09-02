import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    static int[][] list;
    static int N;
    static int M;
    static int C;
    static class Tong{
        int start;
        int end;
        int sum;
        int y;
        Tong(int start,int end, int sum, int y){
            this.start = start;
            this.end = end;
            this.sum = sum;
            this.y = y;
        }
    }
    static List<Tong> tongs;
    static int max;
    static boolean[] visit;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int tc = 1 ; tc <= T ; tc++){
            String[] s = br.readLine().split(" ");
            N = Integer.parseInt(s[0]);
            M = Integer.parseInt(s[1]);
            C = Integer.parseInt(s[2]);
            list = new int[N][N];
            for(int i = 0 ; i < N ; i++){
                s = br.readLine().split(" ");
                for(int j = 0 ; j < N ; j++){
                    list[i][j] = Integer.parseInt(s[j]);
                }
            }
            tongs = new ArrayList<>();
            for(int i = 0 ; i < N ; i++){
                for(int j = 0 ; j < N ; j++){
                    if(j + M <= N){
                        visit = new boolean[N];
                        max = 0;
                        search(j, j + M, i,0,0,0);
                        tongs.add(new Tong(j,j+M,max,i));
                    }
                }
            }
            max = 0;
            find();
            sb.append('#').append(tc).append(' ').append(max).append('\n');
        }
        System.out.print(sb);
    }

    public static void search(int start, int end, int y,int sum, int sums,int depth){
        if(sum>C){
            return;
        }
        max = Math.max(max,sums);
        if(depth==end-start){
            return;
        }
        for(int i =  start ; i < end ; i++){
            if(!visit[i]) {
                visit[i] = true;
                search(start, end, y, sum + list[y][i], sums + (list[y][i] * list[y][i]), depth + 1);

                visit[i] = false;
                search(start, end, y, sum, sums, depth + 1);
            }
        }
    }

    public static void find(){
        for(int i = 0 ; i < tongs.size() - 1 ; i++){
            for(int j = i + 1 ; j < tongs.size() ; j++ ){
                Tong a = tongs.get(i);
                Tong b = tongs.get(j);
                if(a.y==b.y&&(a.end>=b.start)) continue;
                max = Math.max(max, a.sum+b.sum);
            }
        }
    }


}