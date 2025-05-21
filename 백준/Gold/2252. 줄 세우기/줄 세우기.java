import java.io.*;
import java.util.*;


class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);
        int[] indegree = new int[N + 1];
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0 ; i < N +1 ; i++){
            list.add(new ArrayList<>());
        }
        for(int i = 0 ; i < M ; i++){
            s = br.readLine().split(" ");
            indegree[Integer.parseInt(s[1])]++;
            list.get(Integer.parseInt(s[0])).add(Integer.parseInt(s[1]));
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1 ; i < N + 1 ; i++){
            if(indegree[i]==0){
                queue.add(i);
            }
        }
        while (!queue.isEmpty()){
            int now = queue.poll();
            sb.append(now).append(" ");
            for(int i : list.get(now)){
                indegree[i]--;
                if(indegree[i]==0){
                    queue.add(i);
                }
            }
        }
        System.out.print(sb);
    }

}