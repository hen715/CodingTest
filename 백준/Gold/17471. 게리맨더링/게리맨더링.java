import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;


public class Main {
    static List<List<Integer>> list;
    static int min;
    static int[] people;
    static boolean[] select;
    static int N;
    static boolean[] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        people = new int[N + 1];
        String[] s = br.readLine().split(" ");
        for(int i = 1 ; i <= N ; i++){
            people[i] = Integer.parseInt(s[i-1]);
        }
        for(int i = 0 ; i <= N ; i++){
            list.add(new ArrayList<>());
        }
        for(int i = 1 ; i <= N ; i++){
            s = br.readLine().split(" ");
            for(int j = 1 ; j <= Integer.parseInt(s[0]); j++){
                list.get(i).add(Integer.parseInt(s[j]));
            }
        }
        min = Integer.MAX_VALUE;
        select = new boolean[N + 1];
        search(1);
        if(min==Integer.MAX_VALUE){
            System.out.print(-1);
        }
        else {
            System.out.println(min);
        }
    }
    public static void search(int depth){
        if(depth==N+1){
           make();
           return;
        }
        select[depth] = true;
        search(depth + 1);
        select[depth] = false;
        search(depth + 1);
    }

    public static void make(){
        visit = new boolean[N + 1];
        int c = 0;
        for(int i = 1 ; i < N + 1 ; i++){
            if(select[i]){
                c++;
            }
        }
        if(c==N||c==0){
            return;
        }
        ArrayDeque<Integer> q = new ArrayDeque<>();
        boolean first = select[1];
        int sec = 1;
        for(int i = 2 ; i < N + 1 ; i++){
            if(!first==select[i]){
                sec = i;
                break;
            }
        }
        q.offerLast(1);
        visit[1] = true;
        int sum1 = 0;
        while (!q.isEmpty()){
            int now = q.poll();
            sum1 += people[now];
            for(int next : list.get(now)){
                if(!visit[next]&&select[next]==first){
                    visit[next] = true;
                    q.offerLast(next);
                }
            }
        }
        visit[sec] = true;
        q.offerLast(sec);
        int sum2 = 0;
        while (!q.isEmpty()){
            int now = q.poll();
            sum2 += people[now];
            for(int next : list.get(now)){
                if(!visit[next]&&select[next]==!first){
                    visit[next] = true;
                    q.offerLast(next);
                }
            }
        }
        for(int i = 1 ; i< N +1 ; i++){
            if(!visit[i]){
                return;
            }
        }
        min = Math.min(min,Math.abs(sum1-sum2));

    }
}