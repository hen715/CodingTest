import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb= new StringBuilder();
        for(int i = 0 ; i < N ; i++){
            TreeSet<Long> treeSet = new TreeSet<>();
            Map<Long,Integer> map = new HashMap<>();
            int M = Integer.parseInt(br.readLine());
            for(int a = 0 ; a < M ; a++){
                String[] s = br.readLine().split(" ");
                long num = Long.parseLong(s[1]);
                if(s[0].equals("I")){
                    treeSet.add(num);
                    if(!map.containsKey(num)){
                        map.put(num,1);
                    }
                    else{
                        int c = map.get(num);
                        map.put(num,c+1);
                    }
                }
                else{
                    if(num==-1){
                        if(!treeSet.isEmpty()){
                            long temp = treeSet.first();
                            if(map.get(temp)==1){
                                treeSet.remove(temp);
                                map.remove(temp);
                            }
                            else{
                                int c = map.get(temp);
                                map.put(temp,c-1);
                            }
                        }
                    }
                    else{
                        if(!treeSet.isEmpty()){
                            long temp = treeSet.last();
                            if(map.get(temp)==1){
                                treeSet.remove(temp);
                                map.remove(temp);
                            }
                            else{
                                int c = map.get(temp);
                                map.put(temp,c-1);
                            }
                        }
                    }
                }
            }
            if(treeSet.isEmpty()){
                sb.append("EMPTY\n");
            }
            else{
                sb.append(treeSet.last()+" "+treeSet.first()+"\n");
            }

        }
        System.out.println(sb);

    }
}