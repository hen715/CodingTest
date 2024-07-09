import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();
        String s2 = br.readLine();
        int count = 0;
        int i = 0 ;
        while(i <= s1.length()-s2.length()){
            if(s2.matches(s1.substring(i,i+s2.length()))){
                count++;
                i += s2.length();
            }
            else{
                i++;
            }
        }
        System.out.println(count);
    }
}