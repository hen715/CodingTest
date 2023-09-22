import java.util.Scanner;
import java.util.Vector;

public class Main {


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Vector<Integer> v = new Vector<Integer>();
        while(scanner.hasNextLine()){
            String a = scanner.nextLine();
            if(a=="")
                break;
            int num1 = a.charAt(0)-'0';
            int num2= a.charAt(2)-'0';
            v.add(num1 + num2);

        }
        for(int i = 0 ; i<v.size();i++){
            System.out.println(v.get(i));
        }



    }
}