import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수

        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < T; t++) {
            String[] nm = br.readLine().split(" ");
            int N = Integer.parseInt(nm[0]); // 국가 수
            int M = Integer.parseInt(nm[1]); // 비행기 수

            // M개의 비행기 정보는 실제로 필요 없음
            for (int i = 0; i < M; i++) {
                br.readLine(); // 무시
            }

            sb.append(N - 1).append("\n");
        }

        System.out.print(sb);
    }
}
