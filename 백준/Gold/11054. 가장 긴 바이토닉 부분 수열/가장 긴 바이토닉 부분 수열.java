import java.io.*;


class Main {



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] list = new int[N];
        String[] s = br.readLine().split(" ");
        for(int i = 0 ; i < s.length ; i++){
            list[i] = Integer.parseInt(s[i]);
        }
        int[] dp1 = new int[N];
        int[] dp2 = new int[N];
        dp1[0] = 1;
        dp2[0] = 1;
        for(int i = 0 ; i < N ;i++){
            int max = 0;
            for(int j = 0 ; j < i ; j++){
                if(dp1[j]>max&&list[j]<list[i]){
                    max = dp1[j];
                }
            }
            dp1[i] = max + 1;
        }
        for(int i = N-1 ; i >=0 ; i--){
            int max = 0;
            for(int j = N-1; j>i;j--){
                if(dp2[j]>max&&list[j]<list[i]){
                    max = dp2[j];
                }
            }
            dp2[i] = max + 1;
        }
        int max = 0;
        for(int i = 0 ; i < N ; i++){
            max = Math.max(max,dp1[i]+dp2[i] -1);
        }
        System.out.print(max);
    }
}