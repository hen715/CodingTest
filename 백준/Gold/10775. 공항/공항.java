import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int G = Integer.parseInt(br.readLine());
        int P = Integer.parseInt(br.readLine());
        boolean[] list = new boolean[G+1];
        int[] port = new int[G+1];
        int gate;
        int count = 0;
        boolean able = true;
        for(int i = 0 ; i < P ; i++){
            int num = Integer.parseInt(br.readLine());
            if(port[num]!=0&&num>1){
                gate = port[num] - 1;
            }
            else{
                gate = num;
            }
            if(able) {
                while (gate>=1){
                    if(!list[gate]){
                        list[gate] = true;
                        break;
                    }
                    gate--;
                }
                if(gate==0){
                    able = false;
                }
                else{
                    port[num] = gate;
                    count++;
                }
            }
        }
        System.out.print(count);

    }

}