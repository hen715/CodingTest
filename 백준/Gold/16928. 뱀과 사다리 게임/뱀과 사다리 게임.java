import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Main {

    public static int min = Integer.MAX_VALUE;
    public static int[] dice;
    public static int[] visited;

    public static void bfs(){
        int start = 1;
        int count = 0 ;
        Queue<Point> q = new LinkedList<>();
        Point p = new Point(start,count);
        q.add(p);
        while (!q.isEmpty()){
            p = q.poll();
            start = p.x;
            count = p.y;
            count++;
            visited[start] = 1;

            if(dice[start]!=0){
                start = dice[start];
            }

            if(start==100){
                if(min>count){
                    min = count;
                }
            }
            else {
                for (int i = 1; i <= 6; i++) {
                    if (start + i <= 100 && visited[start + i] == 0) {
                        q.add(new Point(start + i, count));
                    }
                }
            }


        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        dice = new int[101];
        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);
        visited = new int[101];
        for(int i = 0 ; i < N + M ; i++){
            s = br.readLine().split(" ");
            dice[Integer.parseInt(s[0])] = Integer.parseInt(s[1]);
        }

        bfs();
        System.out.println(min-1);

    }
}