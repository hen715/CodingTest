import java.io.*;
import java.util.LinkedList;
import java.util.Queue;


class Main {
    static int N;
    static int M;
    static boolean[][][] visit;
    static int[][] list;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int min = Integer.MAX_VALUE;



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        list = new int[N][M];
        visit = new boolean[N][M][2];
        for(int i = 0 ; i< N ; i++){
            String str = br.readLine();
            for(int j = 0 ; j < M ; j++){
                list[i][j] = str.charAt(j) - 48;
            }
        }
        bfs();
        if(min!=Integer.MAX_VALUE){
            System.out.print(min);
        }
        else {
            System.out.print(-1);
        }
    }

    public static void bfs(){
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0,0,1,false));
        while (!q.isEmpty()){
            Node node = q.poll();
                if(node.x == N - 1 && node.y == M - 1){
                    if(node.count<min){
                        min = node.count;
                        return;
                    }
                }
                for(int i = 0 ; i < 4 ; i++){
                    if(node.x+dx[i]>=0 &&node.x+dx[i] < N && node.y+dy[i]>=0 && node.y+dy[i]<M){
                            if(list[node.x+dx[i]][node.y+dy[i]]==1 && !node.isBreak){
                                q.add(new Node(node.x+dx[i],node.y+dy[i],node.count+1,true));
                            }
                            else if(list[node.x+dx[i]][node.y+dy[i]]==0){
                                if(node.isBreak){
                                    if(!visit[node.x+dx[i]][node.y+dy[i]][1]){
                                        visit[node.x+dx[i]][node.y+dy[i]][1] = true;
                                        q.add(new Node(node.x+dx[i],node.y+dy[i],node.count+1, true));
                                    }
                                }
                                else{
                                    if(!visit[node.x+dx[i]][node.y+dy[i]][0]){
                                        visit[node.x+dx[i]][node.y+dy[i]][0] = true;
                                        q.add(new Node(node.x+dx[i],node.y+dy[i],node.count+1, false));
                                    }
                                }

                            }
                        }
                    }
                }

    }
    public static class Node{
        int x;
        int y;
        int count;
        boolean isBreak;
        public Node(int x, int y,int count, boolean isBreak){
            this.x = x;
            this.y = y;
            this.count = count;
            this.isBreak = isBreak;
        }
    }

}