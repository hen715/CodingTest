import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] list = new int[n];
        String[] s = br.readLine().split(" ");
        
        for (int i = 0; i < n; i++) {
            list[i] = Integer.parseInt(s[i]);
        }

        int maxLength = 0;
        int left = 0;
        HashMap<Integer, Integer> fruitCount = new HashMap<>();

        for (int right = 0; right < n; right++) {
            fruitCount.put(list[right], fruitCount.getOrDefault(list[right], 0) + 1);

            while (fruitCount.size() > 2) {
                fruitCount.put(list[left], fruitCount.get(list[left]) - 1);
                if (fruitCount.get(list[left]) == 0) {
                    fruitCount.remove(list[left]);
                }
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        System.out.println(maxLength);
    }
}
