import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static Character[] list;

    public static void search(int start ,int length) {
        if (length>1) {
            for (int i = start + length / 3; i < start+ 2 * length / 3; i++) {
                list[i] = ' ';
            }
            search(start, length / 3);
            search(start + length / 3 * 2, length / 3);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb= new StringBuilder();
        String s;
        while ((s = bf.readLine()) != null && !s.equals("")){
            int num = Integer.parseInt(s);
            int length = (int)Math.pow(3,num);
            list = new Character[length];
            for(int i = 0 ; i<length; i++)
                list[i] = '-';
            search(0,length);
            for(int i = 0 ; i<length; i++)
                sb.append(list[i]);
            sb.append("\n");
        }
        System.out.println(sb);

    }
}