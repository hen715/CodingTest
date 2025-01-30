import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);
        int[][] list = new int[N][4];

        for(int i = 0 ; i < N ; i++){
            s = br.readLine().split(" ");
            for(int j = 0 ; j < 4 ; j++){
                list[i][j] = Integer.parseInt(s[j]);
            }
        }
        int number= 1;
        for(int i = 0 ; i < N ; i++){
            if(list[i][0]== M){
                int gold = list[i][1];
                int silver = list[i][2];
                int bronze = list[i][3];
                for(int a = 0 ; a < N ; a++){
                    if(list[a][1]>gold){
                        number++;
                    }
                    else if(list[a][1]==gold){
                        if(list[a][2]>silver){
                            number++;
                        }
                        else if(list[a][2]==silver){
                            if(list[a][3]>bronze){
                                number++;
                            }
                        }
                    }
                }
            }
        }
        System.out.println(number);
    }
}