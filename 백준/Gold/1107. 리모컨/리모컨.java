import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String ch = bf.readLine();
        int channel = Integer.parseInt(ch);
        int now = 100;
        int[] num = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        int a = Integer.parseInt(bf.readLine());
        if (a > 0) {
            String[] s = bf.readLine().split(" ");
            for (int i = 0; i < a; i++) {
                num[Integer.parseInt(s[i])] = 0;
            }
        }
        int min = Math.abs(channel - now);
        if(a==10){
            System.out.println(min);
            return;
        }
        if(a==0) {
            min = Math.min(min, ch.length());
            System.out.println(min);
            return;
        }


        int tmp = channel;
      String str1;
        while (true){
           str1 = String.valueOf(tmp);
            boolean f = true;
            for(int i = 0 ; i<str1.length();i++) {
                    if (num[str1.charAt(i) - 48] == 0) {
                        f = false;
                    }
            }
            if(f) break;
            else tmp--;
            if(tmp<0)
                break;
        }
        if (tmp==-1)
            tmp=-1000000;
        String str2;
        int tmp2 = channel;
        while (true){
            str2 = String.valueOf(tmp2);
            boolean f = true;
            for(int i=0;i<str2.length();i++){
                if(num[str2.charAt(i)-48]==0){
                    f = false;
                }
            }
            if(f) break;
            else tmp2++;
            if(tmp2>1000000)
                break;
        }
       
        min = Math.min(min, Math.abs(tmp - channel) + str1.length());
        min = Math.min(min, Math.abs(tmp2 - channel) + str2.length());
        
        System.out.println(min);
    }
}