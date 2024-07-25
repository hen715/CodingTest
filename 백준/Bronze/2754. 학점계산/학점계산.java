import java.io.*;

class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        if(s.equals("A+")){
            System.out.println("4.3");
        }
        else if(s.equals("A0")){
            System.out.println("4.0");
        }
        else if(s.equals("A-")){
            System.out.println("3.7");
        }
        else if(s.equals("B+")){
            System.out.println("3.3");
        }
        else if(s.equals("B0")){
            System.out.println("3.0");
        }
        else if(s.equals("B-")){
            System.out.println("2.7");
        }
        else if(s.equals("C+")){
            System.out.println("2.3");
        }
        else if(s.equals("C0")){
            System.out.println("2.0");
        }
        else if(s.equals("C-")){
            System.out.println("1.7");
        }
        else if(s.equals("D+")){
            System.out.println("1.3");
        }
        else if(s.equals("D0")){
            System.out.println("1.0");
        }
        else if(s.equals("D-")){
            System.out.println("0.7");
        }
        else{
            System.out.println("0.0");
        }

    }

}