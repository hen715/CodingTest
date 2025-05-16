import java.io.*;


class Main {
    static int[][] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        list = new int[9][9];
        for(int i = 0 ; i < 9 ; i++){
            String s = br.readLine();
            for(int j = 0 ; j < 9 ; j++){
                list[i][j] = s.charAt(j) - 48;
            }
        }
        dfs(0,0);

    }

    public static void dfs(int x, int y){
        if(y==9){
            dfs(x+1,0);
            return;
        }
        if(x==9){
            StringBuilder sb = new StringBuilder();
            for(int i = 0 ; i < 9 ; i++){
                for(int j = 0 ; j < 9 ; j++){
                    sb.append(list[i][j]);
                }
                sb.append("\n");
            }
            System.out.print(sb);
            System.exit(0);
        }
        if(list[x][y]==0){
            for(int i = 1 ; i < 10 ; i++){
                if(check(x,y,i)){
                    list[x][y] = i;
                    dfs(x,y+1);
                }
            }
            list[x][y] = 0;
            return;
        }
        dfs(x,y+1);
    }

    public static boolean check(int x, int y , int num){
        for(int i = 0 ; i < 9 ; i++){
            if(list[i][y]==num){
                return false;
            }
        }
        for(int i = 0 ; i < 9 ; i++){
            if(list[x][i]==num){
                return false;
            }
        }
        for(int i = (x / 3) * 3 ; i < (x / 3) * 3 + 3 ; i++){
            for(int j = (y / 3) * 3 ; j < (y / 3) * 3 + 3 ; j++){
                if(list[i][j]==num){
                    return false;
                }
            }
        }
        return true;
    }


}