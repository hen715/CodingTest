import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    public static int cal(int N, int M, int x, int y){
        if(N <M){
            int temp = N;
            int temp1 = x;
            N = M;
            M = temp;
            x = y;
            y = temp1;
        }
        int n=0;
        int b;
        while(n<=N){
            b = (x + (N * n))%M;
            if(b==0){
                b = (x + (N * n-1))%M +1;
            }
            if(b==y){
                return x + (N * n);
            }
            n++;
        }
        return -1;
    }



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < T ; i++){
            String[] s = br.readLine().split(" ");
            int N = Integer.parseInt(s[0]);
            int M = Integer.parseInt(s[1]);
            int x = Integer.parseInt(s[2]);
            int y = Integer.parseInt(s[3]);
            sb.append(cal(N,M,x,y)+"\n");
        }
        System.out.println(sb);
    }

}