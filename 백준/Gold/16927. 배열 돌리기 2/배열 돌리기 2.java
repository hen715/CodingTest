import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int N;
    static int M;
    static int R;
    static int[][] list;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        R = Integer.parseInt(s[2]);
        list = new int[N][M];
        for(int i = 0 ; i < N ; i++) {
            s = br.readLine().split(" ");
            for(int j = 0 ; j < M ; j++) {
                list[i][j] = Integer.parseInt(s[j]);
            }
        }
        int numLayers = Math.min(N, M) / 2;

        for(int layer = 0; layer < numLayers; layer++) {
            ArrayList<Integer> layerList = new ArrayList<>();

            for (int j = layer; j < M - 1 - layer; j++) layerList.add(list[layer][j]);
            for (int i = layer; i < N - 1 - layer; i++) layerList.add(list[i][M - 1 - layer]);
            for (int j = M - 1 - layer; j > layer; j--) layerList.add(list[N - 1 - layer][j]);
            for (int i = N - 1 - layer; i > layer; i--) layerList.add(list[i][layer]);

            int r = R % layerList.size();
            Collections.rotate(layerList, -r);

            int index = 0;
            for (int j = layer; j < M - 1 - layer; j++) list[layer][j] = layerList.get(index++);
            for (int i = layer; i < N - 1 - layer; i++) list[i][M - 1 - layer] = layerList.get(index++);
            for (int j = M - 1 - layer; j > layer; j--) list[N - 1 - layer][j] = layerList.get(index++);
            for (int i = N - 1 - layer; i > layer; i--) list[i][layer] = layerList.get(index++);
        }

        StringBuilder sb= new StringBuilder();
        for(int i = 0 ; i < N ; i++) {
            for(int j = 0 ; j < M ; j++) {
                sb.append(list[i][j]).append(' ');
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }


}