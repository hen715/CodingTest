import java.util.*;
import java.io.*;
public class Main {

    static List<List<Integer>> list;
    static int N;
    static int company;
    static int D;
    static boolean[] visit;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        company = Integer.parseInt(s[1]);
        D = Integer.parseInt(s[2]);
        list = new ArrayList<>();
        for(int i = 0 ; i < N + 1; i++){
            list.add(new ArrayList<>());
        }
        for(int i = 0 ; i < N - 1 ; i++){
            s = br.readLine().split(" ");
            list.get(Integer.parseInt(s[0])).add(Integer.parseInt(s[1]));
            list.get(Integer.parseInt(s[1])).add(Integer.parseInt(s[0]));
        }
        visit = new boolean[N + 1];
        visit[company] = true;
        System.out.print(dfs(company));
    }

    static int dfs(int now){
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for(int i : list.get(now)){
            if(!visit[i]){
                visit[i] = true;
                int num = dfs(i);
                if(num <= 0){
                    if(num > max) {
                        max = num;
                    }
                }
                else {
                    sum += num;
                }
            }
        }
        if(now==company){
            return sum * 2;
        }
        if(list.get(now).size()==1) {
            return D * -1 + 1;
        }
        else if(sum==0 && max!=Integer.MIN_VALUE){
            return max + 1;
        }
        else{
            return sum + 1;
        }
    }

}