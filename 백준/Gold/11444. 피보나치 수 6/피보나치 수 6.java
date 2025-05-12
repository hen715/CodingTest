import java.io.*;

class Main {
    static int mod = 1000000007;



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        int[][] matrix = {{1,1},{1,0}};
        matrix = fibo(matrix,n);
        System.out.print(matrix[0][1] % mod);
    }

    public static int[][] fibo(int[][] matrix, long n){
        if(n==1){
            return matrix;
        }
        int[][] temp = fibo(matrix,n/2);
        if(n%2==1){
            return pow(pow(temp,temp),matrix);
        }
        else{
            return pow(temp,temp);
        }
    }

    public static int[][] pow(int[][] m1, int[][] m2){
        int[][] m = new int[2][2];
        for(int i = 0 ; i < 2 ; i++){
            for(int j = 0 ; j < 2 ; j++){
                long sum = 0;
                for(int k = 0 ; k < 2 ; k++){
                    long temp  = (long) (m1[i][k] % mod) * (m2[k][j] % mod);
                    sum += temp;
                }
                sum = sum % mod;
                m[i][j] = (int)sum;
            }
        }
        return m;
    }
}