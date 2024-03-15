import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(bf.readLine());
        if(n==1){
            System.out.println(1);
            return;
        }

        long temp = n;
        long count = 0;
        for(int i = 1 ; i<n;i++){
            if(temp<i){
                break;
            }
            temp -= i;
            count++;
        }
        System.out.println(count);
    }
}