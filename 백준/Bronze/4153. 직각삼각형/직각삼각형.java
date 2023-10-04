import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        double a,b,c,big;
        while(true){
            a = scanner.nextInt();
            b = scanner.nextInt();
            c = scanner.nextInt();
            
            if( b>c){
                big = b;
                b = c;
                c =big;
            }
            if( a>c){
                big = a;
                a = c;
                c =big;
            }
                
            if(a==0&&b==0&&c==0)
                break;
            if(Math.pow(a,2)+Math.pow(b,2)==Math.pow(c,2)){
                sb.append("right");
                sb.append("\n");
            }
            else {
                sb.append("wrong");
                sb.append("\n");
            }

        }
        System.out.println(sb);
    }

}