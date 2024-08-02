import java.io.*;

class Main {


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] stair = new int[n];
        int[] point = new int[n];
        for(int i = 0 ; i < n ; i++){
            stair[i] = Integer.parseInt(br.readLine());
        }
        point[0] = stair[0];
        if(n>1) {
            point[1] = stair[1] + point[0];
            if(n>2) {
                point[2] = Math.max(stair[0], stair[1]) + stair[2];
                if (n > 3){
                    for (int i = 3; i < n; i++) {
                        point[i] = Math.max(point[i - 3] + stair[i - 1], point[i - 2]) + stair[i];
                    }
            }
            }
        }
        System.out.println(point[n-1]);
    }

}