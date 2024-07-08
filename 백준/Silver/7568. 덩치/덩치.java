import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        List<int[]> list = new ArrayList<>();
        for(int i =0 ; i < num ; i++){
            int[] temp = new int[3];
            String s[] = br.readLine().split(" ");
            int w = Integer.parseInt(s[0]);
            int h = Integer.parseInt(s[1]);
            temp[1] = w;
            temp[2] = h;
            list.add(temp);
        }

        for(int i = 0 ; i<list.size();i++){
            int count =0;
            int w = list.get(i)[1];
            int h = list.get(i)[2];
            for(int j = 0 ; j<list.size();j++){
                if(list.get(j)[1]>w&&list.get(j)[2]>h){
                    count++;
                }
            }
            list.get(i)[0] = count+1;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i<list.size();i++){
            sb.append(list.get(i)[0]+" ");
        }
        System.out.println(sb);
    }
}