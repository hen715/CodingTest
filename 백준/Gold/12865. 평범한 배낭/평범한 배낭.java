import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int K = Integer.parseInt(s[1]);
        int[][] back = new int[N + 1][K + 1];
        int[][] material = new int[N +1][2];
        for(int i = 1 ; i < N + 1 ; i++){
            s = br.readLine().split(" ");
            material[i][0] = Integer.parseInt(s[0]);
            material[i][1] = Integer.parseInt(s[1]);
        }
        for(int i = 1 ; i < N + 1 ; i++){
            for(int j = 1 ; j < K + 1 ; j++){
                if(material[i][0]>j){
                    back[i][j] = back[i-1][j];
                }
                else{
                    back[i][j] = Math.max(back[i-1][j],back[i-1][j - material[i][0]] + material[i][1]);
                }
            }
        }
        System.out.println(back[N][K]);
    }
}