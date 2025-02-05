import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        long x = Long.parseLong(s[0]); // 총 게임 횟수
        long y = Long.parseLong(s[1]); // 이긴 게임 횟수

        int rate = (int) (y * 100 / x); // 현재 승률
        if (rate >= 99) { // 99% 이상이면 더 이상 승률을 올릴 수 없음
            System.out.println(-1);
            return;
        }

        long start = 1;
        long end = x; // 최대 x번까지 더 해볼 수 있음
        long result = -1;

        while (start <= end) {
            long mid = (start + end) / 2;
            long newRate = (y + mid) * 100 / (x + mid); // 새로운 승률

            if (newRate > rate) { // 승률이 변했을 때
                result = mid; // 최소 추가 게임 횟수 갱신
                end = mid - 1; // 더 작은 값이 있는지 확인
            } else {
                start = mid + 1;
            }
        }

        System.out.println(result);
    }
}
