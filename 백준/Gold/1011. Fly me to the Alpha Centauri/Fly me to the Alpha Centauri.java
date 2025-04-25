import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            String[] s = br.readLine().split(" ");
            int x = Integer.parseInt(s[0]);
            int y = Integer.parseInt(s[1]);
            int d = y - x;

            int k = (int) Math.sqrt(d);
            if (k * k == d) {
                sb.append(2 * k - 1).append("\n");
            } else if (k * k < d && d <= k * k + k) {
                sb.append(2 * k).append("\n");
            } else {
                sb.append(2 * k + 1).append("\n");
            }
        }
        System.out.print(sb);
    }
}