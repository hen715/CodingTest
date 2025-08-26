import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Solution
{
    static int min;
    static List<HashMap<Integer,Integer>> list;
    static int visit;
    static int N;
    static int[][] dp;
    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int tc = 1 ; tc <= T ; tc++){
            N = Integer.parseInt(br.readLine());
            String[] s = br.readLine().split(" ");
            List<int[]> point = new ArrayList<>();
            for(int i = 0 ; i < (2+N) * 2 ; i += 2){
                point.add(new int[]{Integer.parseInt(s[i]), Integer.parseInt(s[i + 1])});
            }
            list = new ArrayList<>();
            for(int i = 0 ; i < N + 2; i++){
                list.add(new HashMap<>());
            }
            for(int i = 0 ; i < N + 2 ; i++){
                for(int j = i ; j < N +2 ; j++){
                    int dis = Math.abs(point.get(i)[0] - point.get(j)[0]) + Math.abs(point.get(i)[1] - point.get(j)[1]);
                    list.get(i).put(j,dis);
                    list.get(j).put(i,dis);
                }
            }
            dp = new int[1<<N+2][N+2];
            for(int i = 0 ; i < (1<<N+2) ; i++){
                for(int j = 0 ; j < N +2 ; j++)
                dp[i][j] = Integer.MAX_VALUE;
            }
            visit = 0;
            min = Integer.MAX_VALUE;
            search(0,0,0);

            sb.append('#').append(tc).append(' ').append(min).append('\n');
        }
        System.out.print(sb);
    }

    static void search(int depth, int sum,int past){
        if(dp[visit][past]<=sum){
            return;
        }
        dp[visit][past] = sum;
        if(depth==N){
            sum += list.get(past).get(1);
            min = Math.min(min,sum);
            return;
        }
        for(int i = 2 ; i < 2 + N ; i++){
            if((visit&(1<<i))!=(1<<i)){
                visit |= (1<<i);
                int s = list.get(past).get(i);
                search(depth+1,sum + s,i);
                visit &= ~(1<<i);
            }
        }
    }
}