import java.util.*;

public class Main {




    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int[] dp = new int[n + 1];

        for (int i = 1; i < n + 1; i++) {
            if (i == 1) {
                dp[i] = 1;
            } else if (i == 2) {
                dp[i] = 2;
            } else if (i == 3) {
                dp[i] = 1;
            } else if (i == 4) {
                dp[i] = 1;
            } else {
                boolean c = false;
                for (int j = 1; j < 5; j++) {
                    if (j != 2 && dp[i - j] == 2)
                        c = true;
                }
                if (c) {
                    dp[i] = 1;
                } else dp[i] = 2;
            }
        }
        if (dp[n] == 1)
            System.out.print("SK");
        else
            System.out.print("CY");
        }
    }