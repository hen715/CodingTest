import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


class Main {
    public static int[][] list;
    public static int N;
    public static int[][] visited;
    public static List<Integer> nums;
    public static int homes = 0;
    public static int[] dx = {1,-1,0,0};
    public static int[] dy = {0,0,1,-1};

    public static void dfs(int x, int y){
        Point point = new Point(x,y);
        Stack<Point> stack = new Stack<>();
        stack.push(point);
        while (!stack.empty()){
            point = stack.pop();
            if(visited[point.x][point.y]==0&&list[point.x][point.y]==1){
                homes++;
                visited[point.x][point.y]=1;
                for(int i = 0 ; i < 4 ; i++){
                    int nx = point.x + dx[i];
                    int ny = point.y + dy[i];
                    if(nx>=0&&nx<N&&ny>=0&&ny<N){
                        stack.push(new Point(nx,ny));
                    }
                }
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        list = new int[N][N];
        visited  = new int[N][N];
        nums = new ArrayList<>();
        for(int i = 0 ; i < N ; i++){
            String s = br.readLine();
            for(int j = 0 ; j < N ; j++){
                list[i][j] = s.charAt(j)-48;
            }
        }


        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < N ; j++){
                if(visited[i][j]==0&&list[i][j]==1){
                    dfs(i,j);
                    nums.add(homes);
                    homes = 0;
                }
            }
        }
        nums.sort((o1, o2) -> o1-o2);
        StringBuilder sb = new StringBuilder();
        sb.append(nums.size()+"\n");
        for(int i : nums){
            sb.append(i+"\n");
        }
        System.out.println(sb);



    }
}