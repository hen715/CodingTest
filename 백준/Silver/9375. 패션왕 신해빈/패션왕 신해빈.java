import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

class Main {


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < n ; i++){
            int m = Integer.parseInt(br.readLine());
            Map<String,Integer> map = new HashMap<>();
            for(int j = 0 ; j < m ; j++){
                String s = br.readLine();
                String[] wear = s.split(" ");
                if(map.containsKey(wear[1])){
                    int count = map.get(wear[1]);
                    map.put(wear[1],count+1);
                }
                else{
                    map.put(wear[1],1);
                }
            }
            int sum = 1;
            Set<String> keys = map.keySet();
            for (String key : keys){
                int value =map.get(key);
                sum *= (value+1);
            }
            sum--;
            sb.append(sum+"\n");
        }
        System.out.println(sb);
    }

}