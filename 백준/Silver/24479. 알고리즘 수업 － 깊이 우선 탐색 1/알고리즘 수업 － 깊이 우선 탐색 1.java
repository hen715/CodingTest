import java.io.*;
import java.util.ArrayList;
import java.util.Stack;


class Main {
    static int N;
    static int M;
    static boolean[] visit;
    static ArrayList<ArrayList<Integer>> list;
    static int count;
    static int[] num;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        int R = Integer.parseInt(s[2]);
        StringBuilder sb = new StringBuilder();
        num = new int[N+1];
        count = 0;
        visit = new boolean[N+1];
        list = new ArrayList<>();
        for(int i = 0 ; i < N + 1 ; i++){
            list.add(new ArrayList<>());
        }
        for(int i = 0 ; i < M ; i++){
            s = br.readLine().split(" ");
            int u = Integer.parseInt(s[0]);
            int v = Integer.parseInt(s[1]);
            list.get(u).add(v);
            list.get(v).add(u);
        }
        for(int i = 0 ; i < N +1 ; i++){
            list.get(i).sort((o1, o2) -> o2 - o1);
        }
        dfs(R);
        for(int i =1 ; i < N+1 ; i++){
            sb.append(num[i]).append("\n");
        }
        System.out.println(sb);

    }

    public static void dfs(int start){
        Stack<Integer> stack = new Stack<>();
        stack.push(start);
        while (!stack.isEmpty()) {
            int now = stack.pop();
            if (!visit[now]) {
                visit[now] = true;
                num[now] = ++count;
                ArrayList<Integer> arr = list.get(now);
                for (int next : arr) {
                    if (!visit[next]) {
                        stack.push(next);
                    }
                }
            }
        }
    }
}