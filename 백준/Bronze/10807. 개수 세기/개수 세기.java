import java.io.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(bf.readLine());
        int list[] = new int[a];
        String s[] = bf.readLine().split(" ");

        for(int i = 0 ; i<a;i++){
            list[i] = Integer.parseInt(s[i]);
        }
        int b= Integer.parseInt(bf.readLine());

        int count = 0;

        for(int i = 0 ; i<a;i++){
            if(list[i]==b)
                count++;
        }
        System.out.println(count);

    }
}