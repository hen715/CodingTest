import java.io.*;
import java.math.BigInteger;


class Main {


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        BigInteger[] tile = new BigInteger[1001];
        tile[1] = BigInteger.valueOf(1);
        tile[2] = BigInteger.valueOf(2);;
        for(int i = 3 ; i < n+1 ; i++){
            tile[i] = tile[i-1].add(tile[i-2]);
        }
        System.out.println(tile[n].mod(BigInteger.valueOf(10007)));
    }
}