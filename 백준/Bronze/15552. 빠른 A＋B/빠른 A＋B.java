import java.io.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int a = Integer.parseInt(bf.readLine());
        for(int i = 0 ; i<a;i++){
            String s[] = bf.readLine().split(" ");
            sb.append(Integer.parseInt(s[0])+Integer.parseInt(s[1])+"\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();

    }
}