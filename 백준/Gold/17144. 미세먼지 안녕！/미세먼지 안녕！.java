import java.io.*;

class Main {
    static int R;
    static int C;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        R = Integer.parseInt(s[0]);
        C = Integer.parseInt(s[1]);
        int T = Integer.parseInt(s[2]);
        int[][] list = new int[R][C];
        int machine = -1;
        for(int i = 0 ; i < R ; i++){
            s = br.readLine().split(" ");
            for(int j = 0 ; j < C ; j++){
                int temp = Integer.parseInt(s[j]);
                list[i][j] = temp;
                if(temp==-1){
                    machine = i;
                }
            }
        }

        for(int i = 0 ; i < T ; i++){
            list = spread(list);
            move(list, machine);
        }
        int sum = 2;
        for(int i = 0 ; i < R ; i++){
            for(int j = 0 ; j < C ; j++){
                sum += list[i][j];
            }
        }
        System.out.print(sum);
    }

    public static int[][] spread(int[][] list){
        int[][] next = new int[R][C];
        for(int i = 0 ; i < R ; i++){
            for(int j = 0 ; j < C ; j++){
                if(list[i][j]/5<1){
                    next[i][j] += list[i][j];
                }
                else {
                    int count = 0;
                    for (int k = 0; k < 4; k++) {
                        int ddx = i + dx[k];
                        int ddy = j + dy[k];
                        if(ddx>=0&&ddx<R&&ddy>=0&&ddy<C&&list[ddx][ddy]!=-1){
                            next[ddx][ddy] += list[i][j]/5;
                            count++;
                        }
                    }
                    next[i][j] += list[i][j] - count * (list[i][j]/5);
                }
            }
        }
        return next;
    }

    public static void move(int[][] list, int machine){
        int x = machine + 1;
        int y = 0;
        while (true){
            if(x<R-1&&y==0){
                if(x<R-1){
                    list[x][y] = list[x+1][y];
                    x++;
                }
                else{
                    list[x][y] = list[x][y+1];
                }
            }
            else if(x==R-1&&y<C-1){
                if(y<C-1){
                    list[x][y] = list[x][y+1];
                    y++;
                }
                else {
                    list[x][y] = list[x-1][y+1];
                }
            }
            else if(x>=machine && y==C-1){
                if(x>machine){
                    list[x][y] = list[x-1][y];
                    x--;
                }
                else{
                    list[x][y] = list[x][y-1];
                    y--;
                }
            }
            else if(x==machine&&y>0){
                if(y-1>0){
                    list[x][y] = list[x][y-1];
                    y--;
                }
                else {
                    list[x][y] = 0;
                    break;
                }
            }
        }
        machine--;
        x = machine - 1;
        y = 0;
        while (true){
            if(x>=0&&y==0){
                if(x>0){
                    list[x][y] = list[x-1][y];
                    x--;
                }
                else{
                    list[x][y] = list[x][y+1];
                    y++;
                }
            }
            else if(x==0&&y<C-1){
                if(y<C-1){
                    list[x][y] = list[x][y+1];
                    y++;
                }
                else {
                    list[x][y] = list[x+1][y];
                }
            }
            else if(x<=machine && y==C-1){
                if(x<machine){
                    list[x][y] = list[x+1][y];
                    x++;
                }
                else{
                    list[x][y] = list[x][y-1];
                    y--;
                }
            }
            else if(x==machine&&y>0){
                if(y-1>0){
                    list[x][y] = list[x][y-1];
                    y--;
                }
                else {
                    list[x][y] = 0;
                    break;
                }
            }
        }
    }
}