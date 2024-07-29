import java.io.*;
import java.util.HashSet;
import java.util.Set;

class Main {


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Set<Integer> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();

        for(int i = 0 ; i < n ; i++){
            String[] s = br.readLine().split(" ");
            if(s[0].equals("add")){
                set.add(Integer.parseInt(s[1]));
            }
            else if(s[0].equals("remove")){
                set.remove(Integer.parseInt(s[1]));
            }
            else if(s[0].equals("check")){
                if(set.contains(Integer.parseInt(s[1]))){
                 sb.append("1\n");
                }
                else{
                    sb.append("0\n");
                }
            }
            else if(s[0].equals("toggle")){
                if(set.contains(Integer.parseInt(s[1]))){
                    set.remove(Integer.parseInt(s[1]));
                }
                else{
                    set.add(Integer.parseInt(s[1]));
                }
            }
            else if(s[0].equals("all")){
                for(int j = 1; j <21 ; j++){
                    set.add(j);
                }
            }
            else if(s[0].equals("empty")){
                set.clear();
            }
        }
        System.out.println(sb);


    }

}