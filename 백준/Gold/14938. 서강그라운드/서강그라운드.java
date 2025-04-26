import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        int r = Integer.parseInt(s[2]);
        int[] item = new int[n + 1];
        s = br.readLine().split(" ");
        for(int i = 1 ; i < n +1 ; i++){
            item[i] = Integer.parseInt(s[i-1]);
        }
        int[][] dis = new int[n+1][n+1];
        for(int i = 1 ; i < n+1 ; i++){
            for(int j = 1 ; j < n+1 ; j++){
                if(i!=j){
                    dis[i][j] = 100000;
                }
            }
        }

        for(int i = 0 ; i < r ; i++){
            s = br.readLine().split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);
            int l = Integer.parseInt(s[2]);
            dis[a][b] = l;
            dis[b][a] = l;
        }
        for(int k = 1 ; k < n+1; k++){
            for(int i = 1; i < n+1 ; i++){
                for(int j = 1 ; j < n+1 ;j++){
                    dis[i][j] = Math.min(dis[i][j],dis[i][k] + dis[k][j]);
                }
            }
        }
        int max = 0;
        for(int i = 1 ; i < n + 1; i++){
            int sum = 0;
            for(int j = 1 ; j < n + 1 ; j++){
                if(dis[i][j]<=m){
                    sum += item[j];
                }
            }
            max = Math.max(max,sum);
        }
        System.out.print(max);

    }
}