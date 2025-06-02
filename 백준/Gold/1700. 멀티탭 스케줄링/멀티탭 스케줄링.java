import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int K = Integer.parseInt(s[1]);
        int[] list = new int[K];
        s = br.readLine().split(" ");
        for(int i = 0 ; i < K ; i++){
            int num = Integer.parseInt(s[i]);
            list[i] = num;
        }
        List<Integer> plug = new ArrayList<>();
        int count = 0;
        for(int i = 0 ; i < K ; i++){
            if(plug.size()<N){
                if(!plug.contains(list[i])) {
                    plug.add(list[i]);
                }
            }
            else{
                boolean isSame = false;
                for(int num : plug){
                    if(list[i]==num){
                        isSame = true;
                        break;
                    }
                }
                if(!isSame) {
                    int target = 0;
                    int dis = 0;
                    for (int a = 0; a < plug.size(); a++) {
                        int c = 0;
                        boolean isBreak =false;
                        for (int j = i; j < K; j++) {
                            c++;
                            if(list[j]==plug.get(a)){
                                isBreak = true;
                                break;
                            }
                        }
                        if(!isBreak){
                            c++;
                        }
                        if(dis<c){
                            dis = c;
                            target = a;
                        }
                    }
                    plug.remove(target);
                    plug.add(list[i]);
                    count++;
                }
            }
        }

        System.out.print(count);
    }
}