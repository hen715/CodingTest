import java.io.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int list[] = new int[30];
        for(int i =0; i < 28;i++){
            int a = Integer.parseInt(bf.readLine());
            list[a-1]=1;
        }
        for(int i =0; i < 30;i++){
            if(list[i]!=1)
                System.out.println(i+1);
        }


    }
}