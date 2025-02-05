import java.io.*;
import java.util.*;

class Main {
    static class Node {
        int now, count;

        Node(int now, int count) {
            this.now = now;
            this.count = count;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N + 1];
        int[] prev = new int[N + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        Arrays.fill(prev, -1);

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(N, 0));
        dp[N] = 0;

        while (!q.isEmpty()) {
            Node node = q.poll();
            int now = node.now;

            if (now == 1) break;

            if (now % 3 == 0 && dp[now / 3] > node.count + 1) {
                dp[now / 3] = node.count + 1;
                prev[now / 3] = now;
                q.add(new Node(now / 3, node.count + 1));
            }
            if (now % 2 == 0 && dp[now / 2] > node.count + 1) {
                dp[now / 2] = node.count + 1;
                prev[now / 2] = now;
                q.add(new Node(now / 2, node.count + 1));
            }
            if (now - 1 > 0 && dp[now - 1] > node.count + 1) {
                dp[now - 1] = node.count + 1;
                prev[now - 1] = now;
                q.add(new Node(now - 1, node.count + 1));
            }
        }

        System.out.println(dp[1]);

        List<Integer> path = new ArrayList<>();
        int i = 1;
        while (true){
            path.add(i);
            if(i==N){
                break;
            }
            else{
                i = prev[i];
            }
        }
        Collections.reverse(path);

        for (int num : path) {
            System.out.print(num + " ");
        }
    }
}