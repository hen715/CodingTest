import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    static int N;
    static int[][] list;
    static int result = 0;
    static int[] player = new int[9];
    static boolean[] visit = new boolean[9];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        list = new int[N][9];
        String[] s;
        for(int i = 0 ; i <  N ; i++){
            s = br.readLine().split(" ");
            for(int j = 0 ; j < 9 ; j++){
                list[i][j] = Integer.parseInt(s[j]);
            }
        }
        visit[0] = true;
        player[3] = 0;
        search(0);
        System.out.print(result);
    }

    public static void search(int depth){
        if(depth==9){
            result = Math.max(result, play());
            return;
        }
        if(depth==3){
            depth++;
        }
        for(int i = 1 ; i < 9 ; i++ ){
            if(!visit[i]){
                visit[i] = true;
                player[depth] = i;
                search(depth+1);
                visit[i] = false;
            }
        }
    }

    public static int play(){
        int point = 0;
        int out;
        boolean[] ground;
        int index = 0;
        int game = 0;
        while(game < N){
            ground = new boolean[3];
            out = 0;
            while (out < 3){
                if(list[game][player[index]]==0){
                    out++;
                }
                else if(list[game][player[index]]==1){
                    if(ground[2]){
                        ground[2] = false;
                        point++;
                    }
                    if(ground[1]){
                        ground[1] = false;
                        ground[2] = true;
                    }
                    if(ground[0]){
                        ground[0] = false;
                        ground[1] = true;
                    }
                    ground[0] = true;
                }
                else if(list[game][player[index]]==2){
                    if(ground[2]){
                        ground[2] = false;
                        point++;
                    }
                    if(ground[1]){
                        ground[1] = false;
                        point++;
                    }
                    if(ground[0]){
                        ground[2] = true;
                        ground[0] = false;
                    }
                    ground[1] = true;
                }
                else if(list[game][player[index]]==3){
                    if(ground[2]){
                        ground[2] = false;
                        point++;
                    }
                    if(ground[1]){
                        ground[1] = false;
                        point++;
                    }
                    if(ground[0]){
                        ground[0] = false;
                        point++;
                    }
                    ground[2] = true;
                }
                else if(list[game][player[index]]==4){
                    if(ground[2]){
                        ground[2] = false;
                        point++;
                    }
                    if(ground[1]){
                        ground[1] = false;
                        point++;
                    }
                    if(ground[0]){
                        ground[0] = false;
                        point++;
                    }
                    point++;
                }
                index = index + 1 == 9 ? 0 : index + 1;
            }
            game++;
        }

        return point;
    }


}