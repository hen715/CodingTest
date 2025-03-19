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
        int M = Integer.parseInt(br.readLine());
        int start = 0;
        int end = N - 1;
        int count = 0;
        Arrays.sort(list);
        while (start < end){
            if(list[start]+list[end]>M){
                end--;
            }
            else if(list[start]+list[end] <M ){
                start++;
            }
            else{
                count++;
                end--;
            }
        }
        System.out.print(count);
    }
}