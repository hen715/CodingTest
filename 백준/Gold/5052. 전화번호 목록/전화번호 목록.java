import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < T ; i++){
            int N = Integer.parseInt(br.readLine());
            List<String> list = new ArrayList<>();
            for(int j = 0 ; j < N ; j++){
                list.add(br.readLine());
            }
            list.sort((o1, o2) -> o1.compareTo(o2));
            Map<String,Integer> map = new HashMap<>();
            boolean isAble = true;
            for(String s : list){
                for(int index = 0 ; index < s.length() ; index++){
                    if(map.containsKey(s.substring(0,index))){
                        isAble = false;
                    }
                }
                if(!isAble){
                    break;
                }
                else{
                    map.put(s,0);
                }
            }
            if(isAble){
                sb.append("YES\n");
            }
            else{
                sb.append("NO\n");
            }
        }
        System.out.print(sb);
    }
}