import java.io.*;
import java.util.ArrayList;
import java.util.List;

class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        String[] s = br.readLine().split(" ");
        for(int i = 0 ; i < N ; i++){
            A[i] = Integer.parseInt(s[i]);
        }
        int M = Integer.parseInt(br.readLine());
        s = br.readLine().split(" ");
        int[] B = new int[M];
        for(int i = 0 ; i < M ; i++){
            B[i] = Integer.parseInt(s[i]);
        }
        int aIndex = 0;
        int bIndex = 0;
        List<Integer> list = new ArrayList<>();
        while (aIndex<N&&bIndex<M) {
            int max = 0;
            int aTemp = 0;
            int bTemp = 0;
            for (int i = aIndex; i < N; i++) {
                for (int j = bIndex; j < M; j++) {
                    if (A[i] == B[j] && A[i] > max) {
                        aTemp = i;
                        bTemp = j;
                        max = A[i];
                    }
                }
            }
            if(max!=0){
                list.add(max);
                aIndex = aTemp + 1;
                bIndex = bTemp + 1;
            }
            else{
                break;
            }
        }
        sb.append(list.size()).append("\n");
        for(int i : list){
            sb.append(i).append(" ");
        }
        System.out.print(sb);
    }


}