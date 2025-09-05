import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    static int D;
    static int W;
    static int K;
    static int[][] list;
    static int min;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int t = 1 ; t <= T ; t++) {
            String[] s = br.readLine().split(" ");
            D = Integer.parseInt(s[0]);
            W = Integer.parseInt(s[1]);
            K = Integer.parseInt(s[2]);
            list = new int[D][W];
            for(int i = 0 ; i < D ; i++){
                s = br.readLine().split(" ");
                for(int j = 0 ; j < W ; j++){
                    list[i][j] = Integer.parseInt(s[j]);
                }
            }
            if(K==1){
                min =0;
            }
            else {
                min = Integer.MAX_VALUE;
                dfs(0,0);
            }
            sb.append('#').append(t).append(' ').append(min);
            if(t!=T) {
                sb.append('\n');
            }
        }
        System.out.print(sb);
    }
    static void dfs(int depth,int count){
        if(count>=min){
            return;
        }
        if(depth==D){
            if(able()){
                min = Math.min(min,count);
            }
            return;
        }
        int[] temp = new int[W];
        dfs(depth+1,count);
        for(int a = 0 ; a < W ; a++){
            temp[a] = list[depth][a];
            list[depth][a] = 1;
        }
        dfs(depth+1,count+1);
        for(int a = 0 ; a < W ; a++){
            list[depth][a] = 0;
        }
        dfs(depth+1,count+1);
        for(int a = 0 ; a < W ; a++){
            list[depth][a] = temp[a];
        }
    }
    static boolean able(){
        for(int j = 0 ; j < W ; j++){
            int count = 1;
            boolean able = false;
            for(int i = 1 ; i < D ; i++){
                if(list[i][j]==list[i-1][j]){
                    count++;
                }
                else {
                    count = 1;
                }
                if(count==K){
                    able = true;
                    break;
                }
            }
            if(!able){
                return false;
            }
        }
        return true;
    }



}