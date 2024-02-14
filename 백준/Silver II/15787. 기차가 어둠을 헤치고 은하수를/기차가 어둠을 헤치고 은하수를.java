import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] s = bf.readLine().split(" ");
        int n  = Integer.parseInt(s[0]);
        int m =  Integer.parseInt(s[1]);
        int[][] command = new int[m][3];
        boolean[][] train = new boolean[n][20];
        Set<Long> go = new HashSet<>();

        for(int i = 0; i<m;i++){
            s = bf.readLine().split(" ");
            for(int j = 0 ; j<s.length ;j++){
                if(j==1||j==2){
                    command[i][j] = Integer.parseInt(s[j])-1;
                }
                else {
                    command[i][j] = Integer.parseInt(s[j]);
                }
            }
        }

        for(int i = 0 ; i<m ; i++){
            if(command[i][0]==1){
                train[command[i][1]][command[i][2]] = true;
            }
            else if(command[i][0]==2){
                train[command[i][1]][command[i][2]] = false;
            }
            else if(command[i][0]==3){
                train[command[i][1]][19] = false;
                for(int a = 19; a>0;a--){
                    if(train[command[i][1]][a-1]) {
                        train[command[i][1]][a] = train[command[i][1]][a - 1];
                        train[command[i][1]][a - 1] = false;
                    }
                }
            }
            else if (command[i][0]==4){
                train[command[i][1]][0] = false;
                for(int a = 0; a<19;a++){
                    if(train[command[i][1]][a+1]) {
                        train[command[i][1]][a] = train[command[i][1]][a+1];
                        train[command[i][1]][a+1] = false;
                    }
                }
            }
        }
        long sum;
        int num;

        for(int i = 0 ; i<n ; i++){
            sum = 0;
            for(int a = 0;a<20;a++){
                if(train[i][a]){
                    num = 1;
                }
                else num = 0;
                sum+=num*Math.pow(2,a);
            }
            go.add(sum);
        }
        System.out.println(go.size());
    }
}