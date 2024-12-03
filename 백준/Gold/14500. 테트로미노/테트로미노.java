import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    static int[][] paper;
    static int n;
    static int m;
    static int max;


    static void check(int x, int y) {
        if (x + 3 < n) {
            max = Math.max(max, paper[x][y] + paper[x + 1][y] + paper[x + 2][y] + paper[x + 3][y]);
        }
        if (y + 3 < m) {
            max = Math.max(max, paper[x][y] + paper[x][y + 1] + paper[x][y + 2] + paper[x][y + 3]);
        }

        if (x + 1 < n && y + 1 < m) {
            max = Math.max(max, paper[x][y] + paper[x][y + 1] + paper[x + 1][y] + paper[x + 1][y + 1]);
        }

        if (x + 2 < n && y + 1 < m) {
            max = Math.max(max, paper[x][y] + paper[x + 1][y] + paper[x + 2][y] + paper[x + 2][y + 1]);
            max = Math.max(max, paper[x][y + 1] + paper[x + 1][y + 1] + paper[x + 2][y + 1] + paper[x + 2][y]);
            max = Math.max(max, paper[x][y] + paper[x + 1][y] + paper[x + 2][y] + paper[x][y + 1]);
            max = Math.max(max, paper[x][y + 1] + paper[x + 1][y + 1] + paper[x + 2][y + 1] + paper[x][y]);
        }
        if (x + 1 < n && y + 2 < m) {
            max = Math.max(max, paper[x][y] + paper[x][y + 1] + paper[x][y + 2] + paper[x + 1][y + 2]);
            max = Math.max(max, paper[x][y] + paper[x][y + 1] + paper[x][y + 2] + paper[x + 1][y]);
            max = Math.max(max, paper[x][y] + paper[x + 1][y] + paper[x + 1][y + 1] + paper[x + 1][y + 2]);
            max = Math.max(max, paper[x + 1][y] + paper[x + 1][y + 1] + paper[x + 1][y + 2] + paper[x][y + 2]);
        }

        if (x + 1 < n && y + 2 < m) {
            max = Math.max(max, paper[x][y] + paper[x][y + 1] + paper[x][y + 2] + paper[x + 1][y + 1]);
            max = Math.max(max, paper[x + 1][y] + paper[x + 1][y + 1] + paper[x + 1][y + 2] + paper[x][y + 1]);
        }
        if (x + 2 < n && y + 1 < m) {
            max = Math.max(max, paper[x][y] + paper[x + 1][y] + paper[x + 2][y] + paper[x + 1][y + 1]);
            max = Math.max(max, paper[x][y + 1] + paper[x + 1][y + 1] + paper[x + 2][y + 1] + paper[x + 1][y]);
        }

        if (x + 2 < n && y + 1 < m) {
            max = Math.max(max, paper[x][y] + paper[x + 1][y] + paper[x + 1][y + 1] + paper[x + 2][y + 1]);
            max = Math.max(max, paper[x][y + 1] + paper[x + 1][y + 1] + paper[x + 1][y] + paper[x + 2][y]);
        }
        if (x + 1 < n && y + 2 < m) {
            max = Math.max(max, paper[x][y] + paper[x][y + 1] + paper[x + 1][y + 1] + paper[x + 1][y + 2]);
            max = Math.max(max, paper[x + 1][y] + paper[x + 1][y + 1] + paper[x][y + 1] + paper[x][y + 2]);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        paper = new int[n][m];
        for(int i = 0 ; i < n ; i++){
            s = br.readLine().split(" ");
            for(int j = 0 ; j <m ; j++){
                paper[i][j] = Integer.parseInt(s[j]);
            }
        }
        max = -1;
        for(int i = 0 ; i < n;i++){
            for(int j = 0 ; j < m ; j++){
                check(i,j);
            }
        }
        System.out.println(max);



    }


}