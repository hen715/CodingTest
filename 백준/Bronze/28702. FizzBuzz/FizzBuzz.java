import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();
        String s2 = br.readLine();
        String s3 = br.readLine();
        int num1 = -1;
        int num2 = -1;
        int num3 = -1;
        if(s1.charAt(0)>47&&s1.charAt(0)<58){
            num1 = Integer.parseInt(s1);
        }
        if(s2.charAt(0)>47&&s2.charAt(0)<58){
            num2 = Integer.parseInt(s2);
        }
        if(s3.charAt(0)>47&&s3.charAt(0)<58){
            num3 = Integer.parseInt(s3);
        }
        int num = -1;
        if(num1!=-1){
            num = num1+3;
        }
        if(num2!=-1){
            num = num2+2;
        }
        if(num3!=-1){
            num = num3+1;
        }
        String s="";
        if(num%5==0&&num%3==0){
            s = "FizzBuzz";
        }
        else if(num%3 ==0){
            s = "Fizz";
        }
        else if(num%5 ==0){
            s = "Buzz";
        }
        else{
            s = s+num;
        }
        System.out.println(s);



    }
}