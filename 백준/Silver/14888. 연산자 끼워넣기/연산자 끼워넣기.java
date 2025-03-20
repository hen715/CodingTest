import java.io.*;


class Main {

    static int min;
    static int max;
    static int[] operation;
    static int[] list;
    static int N;



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
        N = Integer.parseInt(br.readLine());
        list = new int[N];
        String[] s = br.readLine().split(" ");
        for(int i = 0 ; i < N ; i++){
            list[i] = Integer.parseInt(s[i]);
        }
        s = br.readLine().split(" ");
        operation = new int[4];
        for(int i = 0 ; i < 4 ; i++){
            operation[i] = Integer.parseInt(s[i]);
        }
        trace(0,list[0]);
        System.out.println(max);
        System.out.print(min);
    }
    public static void trace(int depth, int sum){
        if(depth==N-1){
            if(sum<min){
                min = sum;
            }
            if(sum>max){
                max = sum;
            }
            return;
        }
        for(int i = 0 ; i < 4 ; i++){
            if(operation[i]>0){
                operation[i]--;
                if (i == 0) {
                    trace(depth + 1, sum + list[depth + 1]);
                } else if (i == 1) {
                    trace(depth + 1, sum - list[depth + 1]);
                } else if (i == 2) {
                    trace(depth + 1, sum * list[depth + 1]);
                } else if (i == 3) {
                    if (sum < 0) {
                        sum = sum * -1;
                        trace(depth + 1, (sum / list[depth + 1]) * -1);
                    } else {
                        trace(depth + 1, sum / list[depth + 1]);
                    }
                }
                operation[i]++;
            }
        }
    }
}