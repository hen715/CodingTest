import java.io.*;


class Main {
    static int maxDepth;
    static int N;
    static int[][] list;
    static boolean[] visit;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        list = new int[N][N];
        visit = new boolean[N];
        for(int i = 0 ; i < N ; i++){
            String[] s = br.readLine().split(" ");
            for(int j = 0 ; j < N ; j++){
                list[i][j] = Integer.parseInt(s[j]);
            }
        }
        maxDepth = N/2;
        trace(0,0);
        System.out.println(min);
    }


    public static void trace( int depth,int start){
        if(maxDepth==depth){
            calcPoint();
            return;
        }
        for(int i = start ; i < N ; i++){
            if(!visit[i]){
                visit[i] = true;
                trace(depth+1,i);
                visit[i] = false;
            }
        }
    }

    public static void calcPoint(){
        int[] team1 = new int[N/2];
        int[] team2 = new int[N/2];
        int t1 = 0;
        int t2 = 0;
        for(int i = 0 ; i < N ; i++){
            if(visit[i]){
                team1[t1++] = i;
            }
            else{
                team2[t2++] = i;
            }
        }
        int sum1 = 0;
        int sum2 = 0;
        for(int i = 0 ; i < N / 2 - 1 ; i++){
            for(int j = i + 1 ; j < N/2 ; j++){
                sum1 += list[team1[i]][team1[j]] + list[team1[j]][team1[i]];
                sum2 += list[team2[i]][team2[j]] + list[team2[j]][team2[i]];
            }
        }
        min = Math.min(min,Math.abs(sum1-sum2));
    }
}