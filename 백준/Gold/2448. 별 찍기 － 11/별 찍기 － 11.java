import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        char[][] list = new char[N][2 * N -1];
        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < N * 2 - 1 ;j++){
                list[i][j] = ' ';
            }
        }
        make(list,0,N-1,N);
        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < N * 2 - 1 ;j++){
                sb.append(list[i][j]);
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    public static void make(char[][] list,int x, int y, int n){
        if(n==3) {
            draw(list,x, y);
            return;
        }
        make(list,x,y,n/2);
        make(list,x+n/2,y-n/2,n/2);
        make(list,x+n/2,y+n/2,n/2);
    }

    public static void draw(char[][] list, int x, int y){
        list[x][y] = '*';
        list[x+1][y-1] = '*';
        list[x+1][y+1] = '*';
        for(int i = -2 ; i <= 2 ; i++){
            list[x+2][y+i] = '*';
        }
    }
}