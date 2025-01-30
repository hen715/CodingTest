import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        List<Character> list = new ArrayList<>();
        for(int i = 0 ; i < N ; i++){
            String s = br.readLine();
            boolean iskey = false;
            for(int a = 0 ; a < s.length() ; a++){
                if(a==0||s.charAt(a)==' '){
                    char c;
                    if(a==0){
                        c = s.charAt(a);
                    }
                    else{
                        c = s.charAt(a+1);
                    }

                    if(Character.isUpperCase(c)){
                        c = Character.toLowerCase(c);
                    }
                    if(!list.contains(c)){
                        list.add(c);
                        iskey = true;
                        if(a==0) {
                            sb.append('[').append(s.charAt(a)).append(']').append(s.substring(1)).append("\n");
                        }
                        else{
                            sb.append(s.substring(0,a+1)).append('[').append(s.charAt(a+1)).append(']').append(s.substring(a+2)).append("\n");
                        }
                        break;
                    }
                }
            }
            if(!iskey){
                for(int a = 0 ; a < s.length() ; a++){
                    if(s.charAt(a)!=' '){
                        char c = s.charAt(a);
                        if(Character.isUpperCase(c)){
                            c = Character.toLowerCase(c);
                        }
                        if(!list.contains(c)){
                            list.add(c);
                            iskey = true;
                            sb.append(s.substring(0,a)).append('[').append(s.charAt(a)).append(']').append(s.substring(a+1)).append("\n");
                            break;
                        }
                    }
                }
            }
            if(!iskey){
                sb.append(s).append("\n");
            }
        }
        System.out.println(sb);
    }
}