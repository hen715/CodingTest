import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static char[][] list;
    static int[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);
        list = new char[N][M];
        visit = new int[N][M];
        String str;
        for(int i = 0 ; i < N ; i++){
            str = br.readLine();
            for(int j = 0 ; j < M ; j++){
                list[i][j] = str.charAt(j);
            }
        }
        int count = 0;
        int c = 0;
        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < M ; j++){
                if(visit[i][j]==0){
                    c++;
                    int x = i;
                    int y = j;
                    while (visit[x][y]==0){
                        visit[x][y] = c;
                        if(list[x][y]=='D'){
                            x++;
                        }
                        else if(list[x][y]=='U'){
                            x--;
                        }
                        else if(list[x][y]=='R'){
                            y++;
                        }
                        else{
                            y--;
                        }
                    }
                    if(visit[x][y]==c){
                        count++;
                    }
                }
            }
        }
        System.out.print(count);
    }

}