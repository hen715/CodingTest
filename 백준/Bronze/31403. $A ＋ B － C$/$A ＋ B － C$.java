import java.io.*;

class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String s1 = br.readLine();
        String s2 = br.readLine();
        String s3 = br.readLine();
        System.out.println(Integer.parseInt(s1)+Integer.parseInt(s2)-Integer.parseInt(s3));
        System.out.println(Integer.parseInt(s1+s2)-Integer.parseInt(s3));
        

    }

}