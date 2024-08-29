import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        String s = br.readLine();
        String p = "I";
        int count = 0;
        for(int i = 0 ; i < N ; i++){
            p += "OI";
        }
        int index = 0;
        while (s.length()-index>=p.length()){
            String temp = "";
            if(s.charAt(index)=='I'){
                for(int i = 0 ; i < p.length(); i++){
                    int now = i + index;
                    temp += s.charAt(now);
                    if(temp.charAt(i)!=p.charAt(i)){
                        break;
                    }
                }
                if(temp.equals(p)){
                    count++;
                    index += 2;
                    continue;
                }
            }
            index++;
        }
        System.out.println(count);



    }
}