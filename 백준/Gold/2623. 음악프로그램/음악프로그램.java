import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0 ; i < N + 1; i++){
            list.add(new ArrayList<>());
        }
        int[] indegree = new int[N + 1];
        for(int i = 0 ; i < M ; i++){
            s = br.readLine().split(" ");
            for(int j = 1 ; j < s.length -1 ; j++){
                list.get(Integer.parseInt(s[j])).add(Integer.parseInt(s[j+1]));
                indegree[Integer.parseInt(s[j+1])]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 1 ; i < N +1; i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        StringBuilder sb = new StringBuilder();
        int count = 0;
        while (!q.isEmpty()){
            int now = q.poll();
            sb.append(now).append("\n");
            count++;
            for(int i : list.get(now)){
                indegree[i]--;
                if(indegree[i]==0){
                    q.add(i);
                }
            }
        }
        if(count!=N){
            System.out.print(0);
        }
        else {
            System.out.print(sb);
        }
    }

}