import java.io.*;



class Main {


    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       String[] s = br.readLine().split(" ");
       int N = Integer.parseInt(s[0]);
       int K = Integer.parseInt(s[1]);
       int[] list = new int[N];
       s = br.readLine().split(" ");
       for(int i = 0 ; i < N ; i++){
           list[i] = Integer.parseInt(s[i]);
       }
       int sum = 0;
       for(int i = 0 ; i < K ; i++){
           sum += list[i];
       }
       int max = sum;
       for(int i = K ; i < N ; i++){
           sum += list[i];
           sum -= list[i-K];
           if(sum>max){
               max = sum;
           }
       }
       System.out.print(max);
    }

}