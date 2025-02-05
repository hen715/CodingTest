import java.io.*;
import java.util.*;

class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int K = Integer.parseInt(s[1]);
        int[] list = new int[N];
        int[] num = new int[100001];
        s = br.readLine().split(" ");
        for(int i = 0 ; i < N ; i++){
            list[i] = Integer.parseInt(s[i]);
        }
        int i = 0;
        int j = 0;
        int max = 0;
        int length = 0;
        while (i < N && j < N){
            num[list[j]]++;
            if(num[list[j]]<=K){
                length++;
                if(length>max){
                    max = length;
                }
                j++;
            }
            else{
                num[list[i]]--;
                num[list[j]]--;
                i++;
                length--;
            }
        }
        System.out.println(max);
    }

}