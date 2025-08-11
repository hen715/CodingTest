import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



public class Main {
    static int R;
    static int C;
    static char[][] list;
    static boolean able;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        R = Integer.parseInt(s[0]);
        C = Integer.parseInt(s[1]);
        list= new char[R][C];
        for(int i = 0 ; i < R ; i++){
            String str = br.readLine();
            for(int j = 0 ; j < C ; j++){
                list[i][j] = str.charAt(j);
            }
        }
        for(int i = 0 ; i < R ; i++){
            if(list[i][0]!='x') {
                list[i][0]='x';
                able = false;
                dfs(i,0);
            }
        }
        System.out.print(count);
    }

    public static void dfs(int x, int y){
        if(y == C-1){
            count++;
            able = true;
            return;
        }
        if(able) return;
        if(x>0&&list[x-1][y+1]=='.'){
            list[x-1][y+1] = 'x';
            dfs(x-1,y+1);
        }
        if(able) return;
        if(list[x][y+1]=='.'){
            list[x][y+1]='x';
            dfs(x,y+1);
        }
        if(able) return;
        if(x<R-1&&list[x+1][y+1]=='.'){
            list[x+1][y+1] = 'x';
            dfs(x+1,y+1);
        }
    }
}