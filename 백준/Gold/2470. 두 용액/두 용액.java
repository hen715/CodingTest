import java.io.*;
import java.util.Arrays;


class Main {



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");
        int[] list = new int[N];
        for(int i = 0 ; i < N ; i++){
            list[i] = Integer.parseInt(s[i]);
        }
        int start = 0;
        int end = N - 1;
        int min = Integer.MAX_VALUE;
        int min1 = start;
        int min2 = end;
        Arrays.sort(list);
        while (start < end){
            int abs = Math.abs(list[start] + list[end]);
            if(abs<min){
                min = abs;
                min1 = start;
                min2 = end;
            }

                if(Math.abs(list[start])>Math.abs(list[end])){
                    start++;
                }
                else{
                    end--;
                }
        }
        System.out.print(list[min1] + " "+ list[min2]);
    }
}