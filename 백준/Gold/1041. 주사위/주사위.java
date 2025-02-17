import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");
        int[] dice = new int[6];
        int min = Integer.MAX_VALUE;
        int max = 0;
        for (int i = 0; i < 6; i++) {
            dice[i] = Integer.parseInt(s[i]);
            if (dice[i] < min) {
                min = dice[i];
            }
            if(dice[i] > max){
                max = dice[i];
            }
        }
        if(N==1){
            int sum = 0;
            for(int i : dice){
                sum += i;
            }
            System.out.println(sum-max);
            return;
        }
        int topMin = Integer.MAX_VALUE;
        topMin = Math.min(topMin, dice[1] + dice[2]);
        topMin = Math.min(topMin, dice[1] + dice[3]);
        topMin = Math.min(topMin, dice[2] + dice[4]);
        topMin = Math.min(topMin, dice[3] + dice[4]);
        topMin = Math.min(topMin + dice[0], topMin + dice[5]);

        int sideMin = Integer.MAX_VALUE;
        sideMin = Math.min(sideMin, dice[0] + dice[1]);
        sideMin = Math.min(sideMin, dice[0] + dice[2]);
        sideMin = Math.min(sideMin, dice[0] + dice[3]);
        sideMin = Math.min(sideMin, dice[0] + dice[4]);
        sideMin = Math.min(sideMin, dice[1] + dice[2]);
        sideMin = Math.min(sideMin, dice[1] + dice[3]);
        sideMin = Math.min(sideMin, dice[2] + dice[4]);
        sideMin = Math.min(sideMin, dice[3] + dice[4]);
        sideMin = Math.min(sideMin, dice[5] + dice[1]);
        sideMin = Math.min(sideMin, dice[5] + dice[2]);
        sideMin = Math.min(sideMin, dice[5] + dice[3]);
        sideMin = Math.min(sideMin, dice[5] + dice[4]);

        long sum = 0;
        sum += topMin * 4L;
        sum += sideMin * (N * 4L - 4) + sideMin * (N * 4L - 8);
        sum += min * ((long) N * N - (N * 4L - 4));
        sum += 4 * (min * ((long) N * N - (N * 3L - 2)));
        System.out.println(sum);

    }
}