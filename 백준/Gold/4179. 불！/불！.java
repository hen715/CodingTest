import java.io.*;
import java.util.*;

public class Main {

    public static Deque<String[]> q;
    public static Character[][] list;
    public static int n;
    public static int m;
    public static int[] dx= {1,-1,0,0};
    public static int[] dy= {0,0,1,-1};
    public static boolean move;

    public static void fire(){
            String[] b = q.poll();
            for(int i = 0 ; i < 4; i++){
                int nx = Integer.parseInt(b[1]) + dx[i];
                int ny = Integer.parseInt(b[2]) + dy[i];
                if(nx>=0&&nx<n&&ny>=0&&ny<m&&list[nx][ny]=='.'&&b[0].equals("F")){
                    list[nx][ny]='F';
                    q.add(new String[]{"F",String.valueOf(nx),String.valueOf(ny)});
                }
                else if(nx>=0&&nx<n&&ny>=0&&ny<m&&list[nx][ny]=='.'&&b[0].equals("J")){
                    list[nx][ny]='J';
                    q.add(new String[]{"J",String.valueOf(nx),String.valueOf(ny)});
                    move =true;
                }
            }

        }


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] s = bf.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        q = new LinkedList<>();


        list = new Character[n][m];
        for(int i = 0 ; i < n;i++){
            String str = bf.readLine();
            for(int j = 0 ; j<m;j++){
                list[i][j] = str.charAt(j);
                if(str.charAt(j)=='J') {
                    String[] b = new String[3];
                    b[0] = "J";
                    b[1] = String.valueOf(i);
                    b[2] = String.valueOf(j);
                    q.addLast(b);
                    if(i==0||i==n-1||j==0||j==m-1){
                        System.out.println(1);
                        return;
                    }
                }
                else if(str.charAt(j)=='F')
                {
                    String[] b = new String[3];
                    b[0] = "F";
                    b[1] = String.valueOf(i);
                    b[2] = String.valueOf(j);
                    q.addFirst(b);
            }
            }
        }
        int day = 0;
        while (true){
            /*for(int i = 0 ; i<n ; i++){
                System.out.println();
                for (int j = 0 ; j <m ; j++){
                    System.out.print(list[i][j]);
                }
            }
            System.out.println();*/
            move =false;
            int tmp = q.size();
            for(int i = 0 ; i<tmp;i++ ){
                fire();
            }
            day++;
            for(int i = 0 ; i <n;i++){
                if(list[i][0]=='J'||list[i][m-1]=='J'){
                    System.out.println(day+1);
                    return;
                }
            }
            for(int i = 0 ; i < m ; i++){
                if(list[0][i]=='J'||list[n-1][i]=='J'){
                    System.out.println(day+1);
                    return;
                }
            }

            boolean possible =false;

            for(int i = 0 ; i < n ;i++){
                if(list[i][0]=='.'||list[i][m-1]=='.'){
                    possible = true;
                }
            }
            for(int i = 0 ; i < m ; i++){
                if(list[0][i]=='.'||list[n-1][i]=='.'){
                    possible = true;
                }
            }
            if(!possible||!move){
                System.out.println("IMPOSSIBLE");
                return;
            }
        }

    }
}