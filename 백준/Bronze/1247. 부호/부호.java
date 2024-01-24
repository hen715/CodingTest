import java.io.*;
import java.math.BigInteger;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        for(int i = 0 ;i < 3; i++){
            int a = scanner.nextInt();
            BigInteger sum = BigInteger.valueOf(0L);
            BigInteger zero = BigInteger.valueOf(0L);
            for(int j = 0 ; j< a ; j++){
                BigInteger k = scanner.nextBigInteger();
                sum = sum.add(k);
            }
            if(sum.compareTo(zero)==0){
                System.out.println(0);
            }
            else if(sum.compareTo(zero)==-1){
                System.out.println("-");}
            else {
                System.out.println("+");
            }}


    }
}