import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[][] list = new long[n][2];
        String[] s;
        for(int i = 0 ; i < n ; i++){
            s = br.readLine().split(" ");
            list[i][0] = Integer.parseInt(s[0]);
            list[i][1] = Integer.parseInt(s[1]);
        }
        long a = 0;
        long b = 0;
        for(int i = 0 ; i < n-1; i++){
            a += list[i][0] * list[i+1][1];
            b += list[i][1] * list[i+1][0];
        }
        a += list[n - 1][0] * list[0][1];
        b += list[n - 1][1] * list[0][0];
        double area = Math.abs(a - b) / 2.0;
        System.out.printf("%.1f", area);
    }
}