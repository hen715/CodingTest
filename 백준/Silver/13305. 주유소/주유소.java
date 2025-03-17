import java.io.*;


class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dis = new int[N - 1];
        int[] oil = new int[N];
        String[] s =  br.readLine().split(" ");
        for (int i = 0; i < s.length; i++) {
            dis[i] = Integer.parseInt(s[i]);
        }
        s = br.readLine().split(" ");
        for (int i = 0; i < s.length; i++) {
            oil[i] = Integer.parseInt(s[i]);
        }

        for (int i = 1; i < N; i++) {
            if (oil[i] > oil[i - 1]) {
                oil[i] = oil[i - 1];
            }
        }
        long sum = 0;
        for(int i = 0 ; i < N -1 ; i++){
            sum += (long) oil[i] * dis[i];
        }
        System.out.println(sum);

    }


}