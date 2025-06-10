import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    static String S;
    static String T;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = br.readLine();
        T = br.readLine();
        make(T);
        System.out.print(0);
    }

    public static void make(String s){
        if(s.length()==S.length()){
            if(S.equals(s)){
                System.out.print(1);
                System.exit(0);
            }
            return;
        }
        if(s.charAt(s.length()-1)=='A'){
            make(s.substring(0,s.length()-1));
        }
        if(s.charAt(0)=='B'){
            StringBuilder str = new StringBuilder(s);
            str.delete(0,1);
            make(str.reverse().toString());
        }
    }
}