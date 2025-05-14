import java.io.*;


class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int S = Integer.parseInt(s[1]);
        int[] list = new int[N];
        s = br.readLine().split(" ");
        for(int i = 0 ; i < N ; i++){
            list[i] = Integer.parseInt(s[i]);
        }
        int min = Integer.MAX_VALUE;
        int start = 0;
        int end = 0;
        int sum = list[start];
        while (start < N){
            if(sum >= S && end - start + 1 < min){
                min = end - start + 1;
            }
            if(end < N-1 && sum < S){
                end++;
                sum += list[end];
            }
            else {
                sum -= list[start];
                start++;
            }
        }
        if(min==Integer.MAX_VALUE){
            System.out.print(0);
        }
        else {
            System.out.println(min);
        }
    }
}