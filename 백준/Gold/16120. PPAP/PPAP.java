import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        List<Character> list = new ArrayList<>();
        for(int i = 0 ; i < str.length() ; i++){
            list.add(str.charAt(i));
            int size= list.size();
            if(list.get(size-1)=='P'&&list.size()>=4&&list.get(size-2)=='A'&&list.get(size-3)=='P'&&list.get(size-3)=='P'){
                for(int j = 0 ; j < 3; j++){
                    list.remove(list.size()-1);
                }
            }
        }
        if(list.size()==1&&list.get(0)=='P'){
            System.out.print("PPAP");
        }
        else{
            System.out.print("NP");
        }
    }
}