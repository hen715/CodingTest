import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static int N;
    static int M;
    static int[][] list;
    static List<Node> chickenHouse;
    static int chickenDis;
    static boolean[] visit;

    public static class Node{
        int x;
        int y;
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void search(int depth, int start) {
        if(depth == M) {
            calChicken();
            return;
        }

        for(int i = start ; i < chickenHouse.size(); i++) {
            visit[i] = true;
            search(depth + 1,  i + 1);
            visit[i] = false;
        }
    }

    public static void calChicken(){
        int dis = 0;
        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < N ; j++){
                if(list[i][j]==1){
                    int min = Integer.MAX_VALUE;
                    for(int a = 0 ; a < chickenHouse.size() ; a++){
                        if(visit[a]) {
                            min = Math.min(min, Math.abs(chickenHouse.get(a).x - i) + Math.abs(chickenHouse.get(a).y - j));
                        }
                    }

                    dis += min;
                }
            }
        }
        chickenDis = Math.min(chickenDis,dis);
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);

        list= new int[N][N];
        chickenHouse = new ArrayList<>();
        chickenDis = Integer.MAX_VALUE;

        for(int i = 0 ; i < N; i++){
            s = br.readLine().split(" ");
            for(int j = 0 ; j < N ; j++){
                list[i][j] = Integer.parseInt(s[j]);
                if(Integer.parseInt(s[j])==2){
                    chickenHouse.add(new Node(i,j));
                }
            }
        }
        visit = new boolean[chickenHouse.size()];

        search(0,0);
        System.out.print(chickenDis);
    }
}