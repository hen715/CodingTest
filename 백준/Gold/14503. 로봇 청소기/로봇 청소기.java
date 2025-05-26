import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static class Node{
        int x;
        int y;
        int head;
        public Node(int x , int y, int head){
            this.x = x;
            this.y = y;
            this.head = head;
        }
        public void turnHead(){
            head--;
            if(head==-1){
                head = 3;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);
        int[] dx = {1,-1,0,0};
        int[] dy = {0,0,1,-1};
        s = br.readLine().split(" ");
        Node now = new Node(Integer.parseInt(s[0]),Integer.parseInt(s[1]),Integer.parseInt(s[2]));
        int[][] list = new int[N][M];
        for(int i = 0 ; i < N ; i++){
            s = br.readLine().split(" ");
            for(int j = 0 ; j < M ; j++){
                list[i][j] = Integer.parseInt(s[j]);
            }
        }
        int count = 0;
        boolean existDust;
        while (true){
            if(list[now.x][now.y]==0){
                list[now.x][now.y]=2;
                count++;
            }
            existDust = false;
            for(int i = 0 ; i < 4 ; i++){
                int ddx = now.x + dx[i];
                int ddy = now.y + dy[i];
                if(ddx>=0&&ddx<N&&ddy>=0&&ddy<M&&list[ddx][ddy]==0){
                    existDust = true;
                }
            }
            if(!existDust){
                if(now.head==0){
                    if(now.x+1<N&&list[now.x+1][now.y]!=1){
                        now.x++;
                    }
                    else{
                        break;
                    }
                }
                else if(now.head==1){
                    if(now.y-1>=0&&list[now.x][now.y-1]!=1){
                        now.y--;
                    }
                    else{
                        break;
                    }
                }
                else if(now.head==2){
                    if(now.x-1>=0&&list[now.x-1][now.y]!=1){
                        now.x--;
                    }
                    else{
                        break;
                    }
                }
                else{
                    if(now.y+1<M&&list[now.x][now.y+1]!=1){
                        now.y++;
                    }
                    else{
                        break;
                    }
                }
            }
            else{
                now.turnHead();
                if(now.head==0&&now.x-1>=0&&list[now.x-1][now.y]==0){
                    now.x--;
                }
                else if(now.head==1&&now.y+1<M&&list[now.x][now.y+1]==0){
                    now.y++;
                }
                else if(now.head==2&&now.x+1<N&&list[now.x+1][now.y]==0){
                    now.x++;
                }
                else if(now.head==3&&now.y-1>=0&&list[now.x][now.y-1]==0)
                    now.y--;
                }
            }
        System.out.print(count);
    }
}