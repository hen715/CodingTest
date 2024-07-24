import java.io.*;

class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int k = Integer.parseInt(s[0]);
        int n = Integer.parseInt(s[1]);
        long sum = 0;
        int[] line = new int[k];
        for (int i = 0 ; i < k ; i++){
            line[i] = Integer.parseInt(br.readLine());
            sum += line[i];
        }
        long start = 1;
        long end = sum/n;
        long mid = (start + end)/2;
        int lane;
        while (start<=end) {

            lane = 0;
            for (int i = 0; i < k; i++) {
                lane += line[i] / mid;
            }
            if (lane < n) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
            mid = (start + end) / 2 ;
        }
        System.out.println(mid);

    }

}