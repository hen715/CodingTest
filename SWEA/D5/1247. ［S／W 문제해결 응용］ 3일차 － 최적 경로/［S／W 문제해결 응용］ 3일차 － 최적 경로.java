import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Solution
{
    static int min;
    static List<HashMap<Integer,Integer>> list;
    static boolean[] visit;
    static int N;
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
            visit = new boolean[N + 2];
            int[] route = new int[N];
            min = Integer.MAX_VALUE;
            search(0,route);

            sb.append('#').append(tc).append(' ').append(min).append('\n');
        }
        System.out.print(sb);
    }

    static void search(int depth, int[] route){
        if(depth==N){
            calc(route);
            return;
        }
        for(int i = 2 ; i < 2 + N ; i++){
            if(!visit[i]){
                visit[i] = true;
                route[depth] = i;
                search(depth+1,route);
                visit[i] = false;
            }
        }
    }
    static void calc(int[] route){
        //System.out.println(Arrays.toString(route));
        int sum = 0;
        sum += list.get(0).get(route[0]);
        for(int i = 0 ; i < N - 1 ; i++){
            sum += list.get(route[i]).get(route[i+1]);
        }
        sum +=list.get(route[N-1]).get(1);
        min = Math.min(min,sum);
    }
}