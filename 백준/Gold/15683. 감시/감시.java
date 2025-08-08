import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int N;
    static int M;
    static int[][] list;
    static List<Camera> cameras;
    static List<Camera> blocks;
    static int[][] room;

    public static class Camera{
        int num;
        int x;
        int y;
        int time;
        public Camera(int num, int x,int y, int time){
            this.num = num;
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        list = new int[N][M];
        cameras = new ArrayList<>();
        blocks = new ArrayList<>();
        for(int i = 0 ; i < N ;i++){
            s = br.readLine().split(" ");
            for(int j = 0 ; j < M ; j++){
                list[i][j] = Integer.parseInt(s[j]);
                if(list[i][j]>=1&&list[i][j]<=5){
                    cameras.add(new Camera(list[i][j],i,j,0));
                }
                if(list[i][j]==6){
                    blocks.add(new Camera(list[i][j],i,j,0));
                }
            }
        }
        search(0);
        System.out.print(min);
    }

    public static void search(int depth){
        countRoom();
        if(depth== cameras.size()){
            return;
        }
        for(int i = 0 ; i < 4 ; i++){
                cameras.get(depth).time = i;
                search(depth + 1);
        }
    }

    public static void countRoom(){
        room = new int[N][M];
        for(Camera b : blocks){
            room[b.x][b.y] = 6;
        }
        //System.out.println();
        for(Camera c : cameras){
            //System.out.print(c.time);
            room[c.x][c.y] = -1;
            if(c.num==1){
                if(c.time==0){
                    right(c.x, c.y);
                }
                if(c.time==1){
                    down(c.x, c.y);
                }
                if(c.time==2){
                    left(c.x, c.y);
                }
                if(c.time==3){
                    up(c.x, c.y);
                }
            }
            else if(c.num==2){
                if(c.time==0||c.time==2){
                    right(c.x,c.y);
                    left(c.x, c.y);
                }
                else if(c.time==1||c.time==3){
                    up(c.x, c.y);
                    down(c.x, c.y);
                }
            }
            else if(c.num==3){
                if(c.time==0){
                    up(c.x, c.y);
                    right(c.x, c.y);
                }
                if(c.time==1){
                    right(c.x, c.y);
                    down(c.x, c.y);
                }
                if(c.time==2){
                    left(c.x, c.y);
                    down(c.x, c.y);
                }
                if(c.time==3){
                    left(c.x, c.y);
                    up(c.x, c.y);
                }
            }
            else if(c.num==4){
                if(c.time==0){
                    left(c.x, c.y);
                    up(c.x, c.y);
                    right(c.x, c.y);
                }
                if(c.time==1){
                    up(c.x, c.y);
                    right(c.x, c.y);
                    down(c.x, c.y);
                }
                if(c.time==2){
                    left(c.x, c.y);
                    down(c.x, c.y);
                    right(c.x, c.y);
                }
                if(c.time==3){
                    down(c.x, c.y);
                    left(c.x, c.y);
                    up(c.x, c.y);
                }
            }
            else if(c.num==5){
                down(c.x, c.y);
                left(c.x, c.y);
                up(c.x, c.y);
                right(c.x,c.y);
            }
        }
        int count = 0;
        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < M ; j++){
                if(room[i][j]==0){
                    count++;
                }
            }
        }
        min = Math.min(count,min);

    }

    public static void right(int x ,int y){
        y++;
        while (y<M){
            if(room[x][y]==6){
                break;
            }
            room[x][y] = -1;
            y++;
        }
    }

    public static void down(int x, int y){
        x++;
        while (x<N){
            if(room[x][y]==6){
                break;
            }
            room[x][y] = -1;
            x++;
        }
    }

    public static void left(int x, int y){
        y--;
        while (y>=0){
            if(room[x][y]==6){
                break;
            }
            room[x][y] = -1;
            y--;
        }
    }

    public static void up(int x, int y){
        x--;
        while (x>=0){
            if(room[x][y]==6){
                break;
            }
            room[x][y] = -1;
            x--;
        }
    }

}