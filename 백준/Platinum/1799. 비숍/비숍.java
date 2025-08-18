import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



public class Main {
    static int N;
    static int[][] list;
    static int max1 = 0;
    static int max2 = 0;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        list = new int[N][N];
        visit = new boolean[2 * N - 1];
        for(int i = 0 ; i < N ; i++){
            String[] s = br.readLine().split(" ");
            for(int j = 0 ; j < N ; j++){
                list[i][j] = Integer.parseInt(s[j]);
            }
        }
        dfs(0,0,0);
        dfs(0,0,1);
        System.out.print(max1+max2);

    }

    public static void dfs(int depth, int count, int mod){
        if(depth%2==mod){
            depth++;
        }
        if(depth >= 2 * N - 1){
            if(mod==1) {
                max1 = Math.max(max1, count);
            }
            else{
                max2 = Math.max(max2, count);
            }
            return;
        }
        if(depth==0){
            if(list[0][0]==1&&able(0,0)){
                    list[0][0] = 2;
                    visit[N-1] = true;
                    dfs(depth + 1, count + 1,mod);
                    visit[N-1] = false;
                    list[0][0] = 1;
                }
            else {
                dfs(depth + 1, count,mod);
            }

        }
        else if(depth == (2 * N) - 2){
            if(list[N-1][N-1]==1&&able(N-1,N-1)) {
                list[N - 1][N - 1] = 2;
                visit[N - 1] = true;
                dfs(depth + 1, count + 1,mod);
                visit[N - 1] = false;
                list[N - 1][N - 1] = 1;
            }
            else {
                dfs(depth + 1, count,mod);
            }
        }
        else if(depth<N){
            int x = depth;
            int y = 0;
            for(int i = 0 ; i <= depth ; i++){
                if(list[x-i][y+i]==1&&able(x - i, y + i)) {
                        list[x - i][y + i] = 2;
                        visit[N -1 -((x - i) - (y+i))] = true;
                        dfs(depth + 1, count + 1,mod);
                        visit[N -1 -((x - i) - (y+i))] = false;
                        list[x - i][y + i] = 1;
                }
            }
            dfs(depth + 1,count,mod);
        }
        else{
            int x = depth - N + 1;
            int y = N - 1;
            for(int i = 0 ; i < N - x ; i++){
                if(list[x+i][y-i]==1&&able(x+i,y-i)){
                        list[x + i][y - i] = 2;
                        visit[N -1 -((x + i) - (y - i))] = true;
                        dfs(depth + 1, count + 1,mod);
                        visit[N -1 -((x + i) - (y - i))] = false;
                        list[x + i][y - i] = 1;
                }
            }
            dfs(depth + 1,count,mod);
        }
    }

    public static boolean able(int x,int y){
        if(visit[N - 1 - (x - y)]){
            return false;
        }
        return true;
    }
}