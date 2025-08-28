import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Solution
{
    static int N,W,H;
    static int[][] input;
    static int min;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int tc = 1 ; tc <= T ; tc++){
            String[] s = br.readLine().split(" ");
            N = Integer.parseInt(s[0]);
            W = Integer.parseInt(s[2]);
            H = Integer.parseInt(s[1]);
            input = new int[W][H];
            for(int i = 0 ; i < W ; i++){
                s = br.readLine().split(" ");
                for(int j = 0 ; j < H ; j++){
                    input[i][j] = Integer.parseInt(s[j]);
                }
            }
            min = Integer.MAX_VALUE;
            search(0,input.clone());
            sb.append('#').append(tc).append(' ').append(min).append('\n');
        }
        System.out.print(sb);
    }

    static void search(int depth, int[][] list){
        if(depth==N){
            min = Math.min(min,calc(list));
            return;
        }
        for(int i = 0 ; i < H ; i++){
            int[][] nList = new int[W][H];
            for(int a = 0 ; a < W ; a++){
                for(int b = 0 ; b < H ; b++){
                    nList[a][b] = list[a][b];
                }
            }
            drop(nList,i);
            //System.out.println(depth);
            //print(list);

            search(depth+1,nList);
        }
    }

    static int calc(int[][] list){
        int count = 0;
        for(int i = 0 ; i < W ; i++){
            for(int j = 0 ; j < H ; j++){
                if(list[i][j]!=0){
                    count++;
                }
            }
        }
        return count;
    }
    static void drop(int[][] list, int point){
        Queue<int[]> q = new ArrayDeque<>();
        for(int i = 0 ; i < W ; i++){
            if(list[i][point]!=0){
                q.add(new int[]{i,point,list[i][point]});
                list[i][point] = 0;
                break;
            }
        }
        while (!q.isEmpty()){
            int[] now = q.poll();
            for(int i = 1 ; i < now[2] ; i++){
                for(int j = 0 ; j < 4 ; j++){
                    int ddx = now[0] + (dx[j] * i);
                    int ddy = now[1] + (dy[j] * i);
                    if(ddx>=0&&ddx<W&&ddy>=0&&ddy<H&&list[ddx][ddy]!=0){
                        q.add(new int[]{ddx,ddy,list[ddx][ddy]});
                        list[ddx][ddy] = 0;
                    }
                }
            }
        }

        Queue<Integer> qq = new ArrayDeque<>();
        for(int i = 0 ; i < H  ;i++){
            for(int j = W - 1 ; j >= 0 ; j--){
                if(list[j][i]!=0){
                    qq.add(list[j][i]);
                    list[j][i] = 0;
                }
            }
            int index = W - 1;
            while (!qq.isEmpty()){
                list[index][i] = qq.poll();
                index--;
            }
        }
    }
    static void print(int[][] list){
        for(int i = 0 ; i < W ; i++){
            for(int j = 0 ; j < W ; j++){
                System.out.print(list[i][j]+ " ");
            }
            System.out.println();
        }
        System.out.println();
    }


}