import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class Main {
    static int N;
    static boolean[][] list = new boolean[101][101];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        String[] s;
        for(int i = 0 ; i < N ; i++){
            s = br.readLine().split(" ");
            int x = Integer.parseInt(s[0]);
            int y = Integer.parseInt(s[1]);
            int d = Integer.parseInt(s[2]);
            int g = Integer.parseInt(s[3]);
            draw(x,y,d,g);
        }
        System.out.print(count());

    }
    public static int count(){
        int sum = 0;
        for(int i = 0 ; i <100 ; i++){
            for(int j = 0 ; j < 100 ; j++){
                if(list[i][j]&&list[i+1][j]&&list[i][j+1]&&list[i+1][j+1]){
                    sum++;
                }
            }
        }
        return sum;
    }

    public static void draw(int y, int x, int d, int g){
        List<Integer> past = new ArrayList<>();
        list[x][y] = true;
        int xx = x;
        int yy= y;
        if(d==0){
            list[xx][yy+1] = true;
            yy++;
            past.add(0);
        }
        else if(d==1){
            list[xx-1][yy] = true;
            xx--;
            past.add(1);
        }
        else if(d==2){
            list[xx][yy-1] = true;
            yy--;
            past.add(2);
        }
        else if(d==3){
            list[xx+1][yy] = true;
            xx++;
            past.add(3);
        }
        int gen = 0;
        while (gen < g){
            int size = past.size();
            for(int i = size-1 ; i >=0 ; i--){
                int way= past.get(i);
                if(way==0){
                    list[xx-1][yy] = true;
                    xx--;
                    past.add(1);
                }
                else if(way==1){
                    list[xx][yy-1] = true;
                    yy--;
                    past.add(2);
                }
                else if(way==2){
                    list[xx+1][yy] = true;
                    xx++;
                    past.add(3);
                }
                else if(way==3){
                    list[xx][yy+1] = true;
                    yy++;
                    past.add(0);
                }
            }
            gen++;
        }

    }


}