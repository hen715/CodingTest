import java.io.*;
import java.util.HashMap;
import java.util.Map;


class Main {


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        Map<String,String> map = new HashMap<>();
        for(int i = 0 ; i < n ; i++){
            s = br.readLine().split(" ");
            map.put(s[0],s[1]);
        }
        for(int i = 0 ; i < m ; i++){
            sb.append(map.get(br.readLine())+"\n");
        }
        System.out.println(sb);
    }

}