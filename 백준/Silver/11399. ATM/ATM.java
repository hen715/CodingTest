import java.io.*;
import java.util.Arrays;


class Main {


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] man = new int[n];
        String[] s = br.readLine().split(" ");
        for(int i = 0 ; i < n ; i++){
            man[i] = Integer.parseInt(s[i]);
        }
        Arrays.sort(man);
        int count = 0;
        int sum = 0;
        for(int i = 0 ; i < n ; i++){
            count = count +man[i];
            sum = sum +count;
        }
        System.out.println(sum);
    }

}