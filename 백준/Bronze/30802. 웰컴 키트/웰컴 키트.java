import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        String[] s1 = br.readLine().split(" ");
        String[] s2 = br.readLine().split(" ");
        int t= Integer.parseInt(s2[0]);
        int p= Integer.parseInt(s2[1]);
        int sum = 0;
        for(int i = 0 ; i <s1.length;i++){
            if(Integer.parseInt(s1[i])%t!=0) {
                sum += Integer.parseInt(s1[i]) / t + 1;
            }
            else{
                sum += Integer.parseInt(s1[i]) / t;
            }
        }
        System.out.println(sum);
        System.out.println(num/p+" "+num%p);

    }
}