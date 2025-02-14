import java.io.*;
import java.util.*;

class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<String> list= new ArrayList<>();
        for(int i = 0 ; i < N ; i++){
            list.add(br.readLine());
        }
        Collections.sort(list,(o1, o2) -> {
            if(o1.length()==o2.length()){
                int count1 = 0;
                int count2 = 0;
                for(int i = 0 ; i < o1.length() ; i++){
                    if(o1.charAt(i)-48>0&&o1.charAt(i) - 48 < 10){
                        count1 +=o1.charAt(i)-48;
                    }
                    if(o2.charAt(i)-48>0&&o2.charAt(i) - 48 < 10){
                        count2 +=o2.charAt(i)-48;
                    }
                }
                if(count1>count2){
                    return 1;
                }
                else if (count1<count2){
                    return -1;
                }
                else{
                    return o1.compareTo(o2);
                }
            }
            else if(o1.length()>o2.length()){
                return 1;
            }
            else{
                return -1;
            }
        });
        for(int i = 0 ; i < N ; i++){
            System.out.println(list.get(i));
        }

    }
}