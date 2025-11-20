import java.util.*;
import java.io.*;
public class Main {
    static int N;
    static int M;
    static int[][] list;
    static Map<Integer,Integer> map;
    static int num;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static Set<Integer> set;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        list = new int[N][M];
        for(int i = 0 ; i < N ; i++){
            String str = br.readLine();
            for(int j = 0 ; j < M ; j++){
                list[i][j] = str.charAt(j) - '0';
            }
        }
        map = new HashMap<>();
        num = 2;
        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < M ; j++){
                if(list[i][j]==0){
                    setNum(i,j);
                }
            }
        }
        set = new HashSet<>();
        int[][] result = new int[N][M];
        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < M ; j++){
                if(list[i][j]==1){
                    setResult(i,j,result);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < M ; j++){
                sb.append(result[i][j]);
            }
            sb.append('\n');
        }
        System.out.print(sb);

    }

    static void setNum(int x, int y){
        Queue<int[]> q = new ArrayDeque<>();
        int count = 0;
        list[x][y] = num;
        q.add(new int[]{x,y});
        count++;
        while (!q.isEmpty()){
            int[] now = q.poll();
            for(int i = 0 ; i < 4 ; i++){
                int ddx = now[0] + dx[i];
                int ddy = now[1] + dy[i];
                if(ddx>=0&&ddx<N&&ddy>=0&&ddy<M&&list[ddx][ddy]==0){
                    q.add(new int[]{ddx,ddy});
                    list[ddx][ddy] = num;
                    count++;
                }
            }
        }
        map.put(num,count);;
        num++;

    }

    static void setResult(int x, int y, int[][] result){
        set.clear();
        for(int i = 0 ; i < 4 ; i++){
            int ddx = x + dx[i];
            int ddy = y + dy[i];
            if(ddx>=0&&ddx<N&&ddy>=0&&ddy<M&&list[ddx][ddy]!=1) {
                set.add(list[ddx][ddy]);
            }
        }
        int sum = 0;
        for(int key : set){
            sum += map.get(key);
        }
        result[x][y] = (sum + 1) %10;
    }

}