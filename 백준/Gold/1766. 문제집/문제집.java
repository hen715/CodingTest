import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);
        int[] indegree = new int[N + 1];
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0 ; i < N + 1 ; i++){
            list.add(new ArrayList<>());
        }
        for(int i = 0 ; i < M ; i++){
            s = br.readLine().split(" ");
            list.get(Integer.parseInt(s[0])).add(Integer.parseInt(s[1]));
            indegree[Integer.parseInt(s[1])]++;
        }
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for(int i = 1 ; i < N +1 ; i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()){
            int num = q.poll();
            sb.append(num).append(' ');
            for(int i : list.get(num)){
                indegree[i]--;
                if(indegree[i]==0){
                    q.add(i);
                }
            }
        }
        System.out.print(sb);
    }

}