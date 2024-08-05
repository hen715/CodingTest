import java.io.*;
import java.math.BigInteger;


class Main {


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        BigInteger[] tile = new BigInteger[1001];
        tile[1] = BigInteger.valueOf(1);
        tile[2] = BigInteger.valueOf(3);
        tile[3] = BigInteger.valueOf(5);
        for(int i = 4 ; i < n+1 ; i++){
            tile[i] = tile[i-2].multiply(BigInteger.TWO);
            tile[i] = tile[i].add(tile[i-1]);
        }
        System.out.println(tile[n].mod(BigInteger.valueOf(10007)));
    }
}