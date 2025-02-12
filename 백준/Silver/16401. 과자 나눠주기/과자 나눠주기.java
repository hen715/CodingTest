import java.io.*;
import java.util.*;

class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);
        int[] list = new int[M];
        s = br.readLine().split(" ");
        int max = 0;
        for(int i  = 0 ; i < M ; i++){
            int l = Integer.parseInt(s[i]);
            list[i] = l;
            if(l>max){
                max = l;
            }
        }
        int start = 1;
        int end = max;
        while (start<=end){
            int mid = (start+end)/2;
            int count = 0;
            for(int i = 0 ; i < M ; i++){
                count += list[i]/mid;
            }
            if(count>=N){
                start = mid +1;
            }
            else{
                end = mid - 1;
            }
        }
        System.out.println(end);

    }
}