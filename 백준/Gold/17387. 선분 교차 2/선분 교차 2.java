import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int x1 = Integer.parseInt(s[0]);
        int y1 = Integer.parseInt(s[1]);
        int x2 = Integer.parseInt(s[2]);
        int y2 = Integer.parseInt(s[3]);

        s = br.readLine().split(" ");
        int x3 = Integer.parseInt(s[0]);
        int y3 = Integer.parseInt(s[1]);
        int x4 = Integer.parseInt(s[2]);
        int y4 = Integer.parseInt(s[3]);

        int a = ccw(x1, y1, x2, y2, x3, y3) * ccw(x1, y1, x2, y2, x4, y4);
        int b = ccw(x3, y3, x4, y4, x1, y1) * ccw(x3, y3, x4, y4, x2, y2);

        if (a == 0 && b == 0) {
            if (Math.min(x1, x2) <= Math.max(x3, x4) &&
                    Math.min(x3, x4) <= Math.max(x1, x2) &&
                    Math.min(y1, y2) <= Math.max(y3, y4) &&
                    Math.min(y3, y4) <= Math.max(y1, y2)) {
                System.out.print(1);
            } else {
                System.out.print(0);
            }
        } else if (a <= 0 && b <= 0) {
            System.out.print(1);
        } else {
            System.out.print(0);
        }
    }

    public static int ccw(int x1, int y1, int x2, int y2, int x3, int y3) {
        long ccw = (long)(x2 - x1) * (y3 - y1) - (long)(y2 - y1) * (x3 - x1);
        if(ccw>0){
            return 1;
        }
        else if(ccw==0){
            return 0;
        }
        else {
            return -1;
        }
    }

}