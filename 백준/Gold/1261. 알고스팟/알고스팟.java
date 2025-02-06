import java.io.*;
import java.util.*;

class Main {
    static class Node{
        int x;
        int y;
        int count;
        Node(int x, int y, int count){
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
    static int[][] list;
    static int N;
    static int M;
    static boolean[][] visited;
    static int min = Integer.MAX_VALUE;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        M = Integer.parseInt(s[0]);
        N = Integer.parseInt(s[1]);
        list = new int[N][M];
        visited = new boolean[N][M];
        for(int i = 0 ; i < N ; i++){
            String str= br.readLine();
            for(int j = 0 ; j < M ; j++){
                list[i][j] = str.charAt(j) - 48;
            }
        }
        PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2)->o1.count-o2.count);
        pq.add(new Node(0,0,0));
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            if (!visited[node.x][node.y]) {
                if (node.x == N - 1 && node.y == M - 1) {
                    min = node.count;
                    break;
                }
                visited[node.x][node.y] = true;
                for (int i = 0; i < 4; i++) {
                    if (node.x + dx[i] >= 0 && node.x + dx[i] < N && node.y + dy[i] >= 0 && node.y + dy[i] < M && !visited[node.x + dx[i]][node.y + dy[i]]) {
                        pq.add(new Node(node.x + dx[i], node.y + dy[i], list[node.x][node.y] == 1 ? node.count + 1 : node.count));
                    }
                }
            }
        }
        System.out.println(min);
    }
}