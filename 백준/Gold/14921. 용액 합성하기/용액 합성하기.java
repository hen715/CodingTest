import java.io.*;
import java.util.*;

class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] list = new int[N];
        String[] s = br.readLine().split(" ");
        for(int i = 0 ; i < N ; i++){
            list[i] = Integer.parseInt(s[i]);
        }
        int start = 0;
        int end = N-1;
        int min = Integer.MAX_VALUE;
        int minValue = 0;
        while (start<end){
            int sum = Math.abs(list[start] + list[end]);
            if(sum < min){
                min = sum;
                minValue = list[start] + list[end];
            }
            if(Math.abs(list[start])>Math.abs(list[end])){
                start++;
            }
            else{
                end--;
            }
        }
        System.out.println(minValue);
    }
}