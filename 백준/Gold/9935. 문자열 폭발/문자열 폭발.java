import java.io.*;
import java.util.ArrayList;
import java.util.List;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String bomb = br.readLine();
        StringBuilder sb = new StringBuilder();
        List<Character> list = new ArrayList<>();
        for(int i = 0 ; i < s.length() ; i++){
            list.add(s.charAt(i));
            if(list.size()>=bomb.length()&&list.get(list.size()-1)==bomb.charAt(bomb.length()-1)){
                boolean isSame = true;
                for(int a = 0 ; a < bomb.length() ; a++){
                    if(list.get(list.size()-a - 1)!=bomb.charAt(bomb.length()-a-1)){
                        isSame = false;
                        break;
                    }
                }
                if(isSame){
                    for(int a = 0 ; a < bomb.length() ; a++){
                        list.remove(list.size()-1);
                    }
                }
            }
        }
        for (Character character : list) {
            sb.append(character);
        }
        if(sb.length()==0){
            System.out.print("FRULA");
        }
        else {
            System.out.print(sb);
        }
    }
}