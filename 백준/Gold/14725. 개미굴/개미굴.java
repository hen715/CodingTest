import java.util.*;
import java.io.*;
public class Main {

    static StringBuilder sb;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Map<String,Map> map = new TreeMap<>();
        String[] s;
        for(int i = 0 ; i < N ; i++){
            s = br.readLine().split(" ");
            Map<String,Map> m = map;
            for(int j = 1 ; j < s.length ; j++){
                if(!m.containsKey(s[j])){
                    m.put(s[j],new TreeMap());
                }
                m = m.get(s[j]);
            }
        }
        sb = new StringBuilder();
        search(map,0);
        System.out.print(sb);
    }

    static void search(Map<String,Map> map,int depth){
        for(String key : map.keySet()){
            for(int i = 0 ; i < depth ; i++){
                sb.append("--");
            }
            sb.append(key).append('\n');
            search(map.get(key),depth+1);
        }
    }

}