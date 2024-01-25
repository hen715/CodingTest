import java.io.*;
import java.math.BigInteger;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        BigInteger[][] big = new BigInteger[n][10];

        big[0][0] = BigInteger.valueOf(0);
        for(int i = 1 ; i< 10 ; i++){
            big[0][i] = BigInteger.valueOf(1);
        }


        if(n>1){

            for(int i = 1; i<n;i++){
                for(int j = 0 ; j<10;j++){
                    big[i][j] = BigInteger.valueOf(0);
                }
            }

            for(int i = 1 ;i<n;i++ ){
                big[i][0] = big[i][0].add(big[i-1][1]);
                big[i][9] = big[i][9].add(big[i-1][8]);
                for(int j = 1 ; j<9;j++){
                    big[i][j] = big[i][j].add(big[i-1][j-1]);
                    big[i][j] = big[i][j].add(big[i-1][j+1]);
                }
            }
        }
        BigInteger sum = BigInteger.valueOf(0);
        for(int i=0;i<10;i++){
            sum = sum.add(big[n-1][i]);
        }
        sum = sum.mod(BigInteger.valueOf(1000000000));
        System.out.println(sum);
    }
}