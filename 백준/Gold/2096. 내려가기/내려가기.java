import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] dpMax = new int[N][3];
        int[][] dpMin = new int[N][3];
        String[] s = br.readLine().split(" ");
        dpMax[0][0] = Integer.parseInt(s[0]);
        dpMax[0][1] = Integer.parseInt(s[1]);
        dpMax[0][2] = Integer.parseInt(s[2]);
        dpMin[0][0] = Integer.parseInt(s[0]);
        dpMin[0][1] = Integer.parseInt(s[1]);
        dpMin[0][2] = Integer.parseInt(s[2]);
        for(int i = 1 ; i < N ; i++){
            s = br.readLine().split(" ");
            dpMax[i][0] = Math.max(dpMax[i-1][0],dpMax[i-1][1]) + Integer.parseInt(s[0]);
            dpMax[i][1] = Math.max(Math.max(dpMax[i-1][0],dpMax[i-1][1]),dpMax[i-1][2]) + Integer.parseInt(s[1]);
            dpMax[i][2] = Math.max(dpMax[i-1][1],dpMax[i-1][2]) + Integer.parseInt(s[2]);

            dpMin[i][0] = Math.min(dpMin[i-1][0],dpMin[i-1][1]) + Integer.parseInt(s[0]);
            dpMin[i][1] = Math.min(Math.min(dpMin[i-1][0],dpMin[i-1][1]),dpMin[i-1][2]) + Integer.parseInt(s[1]);
            dpMin[i][2] = Math.min(dpMin[i-1][1],dpMin[i-1][2]) + Integer.parseInt(s[2]);
        }
        int max = Math.max(Math.max(dpMax[N-1][0],dpMax[N-1][1]),dpMax[N-1][2]);
        int min = Math.min(Math.min(dpMin[N-1][0],dpMin[N-1][1]),dpMin[N-1][2]);
        System.out.println(max+" "+min);

    }
}