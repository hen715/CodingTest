import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int[] list = new int[n];
        String[] s = bf.readLine().split(" ");
        for(int i = 0 ; i<n ; i++){
            list[i] = Integer.parseInt(s[i]);
        }
        int start = 0;
        int end = n-1;
        int min1 = list[start];
        int min2 = list[end];
        int min = Math.abs(list[start] + list[end]);
        while (start<end){
            if(Math.abs(list[start]+list[end])<min){
                min1 = list[start];
                min2 = list[end];
                min = Math.abs(list[start] + list[end]);
            }
            if(Math.abs(list[start])<Math.abs(list[end])){
                end--;
            }
            else{
                start++;
            }
        }
        if(min1<min2){
            System.out.println(min1+" "+min2);
        }
        else{
            System.out.println(min2 +" " +min1);
        }

    }
}