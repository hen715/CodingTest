import java.io.*;
import java.util.ArrayList;
import java.util.List;


class Main {


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        List<Integer> list = new ArrayList<>();
        String num ="";
        int i  = 0;
        int sum = 0;
        int temp = 0;
        boolean isMinus = false;
        while ( i< s.length()){
            if(s.charAt(i)=='-'){
                if(!isMinus){
                    isMinus = true;
                    sum += Integer.parseInt(num);
                    num="";
                }
                else{
                    temp += Integer.parseInt(num);
                    num ="";
                    sum -= temp;
                    temp = 0;
                }
            }
            else if(s.charAt(i)=='+'){
                if(isMinus){
                    temp += Integer.parseInt(num);
                }
                else {
                    sum += Integer.parseInt(num);
                }
                num = "";
            }
            else{
                num = num + s.charAt(i);
            }
            i++;
        }
        temp += Integer.parseInt(num);
        if(isMinus){
            sum -= temp;
        }
        else{
            sum += temp;
        }
        System.out.println(sum);
    }
}