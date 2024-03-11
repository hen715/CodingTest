import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int i = 1;
        int count = 0;
        while (true){
            String str = String.valueOf(i);
            if(str.contains("666")){
                count++;
                if(count== n)
                    break;
            }
            i++;
        }
        System.out.println(i);

    }
}