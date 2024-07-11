import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int[] list = new int[num];
        Map<Integer,Integer> map = new HashMap<>();
        int sum = 0;
        for(int i = 0 ; i < num ; i++){
            int temp = Integer.parseInt(br.readLine());
            sum += temp;
            list[i] = temp;
            if(map.containsKey(temp)){
                int count = map.get(temp);
                map.put(temp,count+1);
            }
            else{
                map.put(temp,1);
            }
        }
        Set<Integer> keySet = map.keySet();
        boolean isFirst = true;
        int max = -1;
        int maxNum = -1;
        for (int key : keySet) {
            int number = map.get(key);
            if(number>max){
                max = number;
                maxNum = key;
            }
        }
        List<Integer> maxs = new ArrayList<>();
        for (int key : keySet) {
            int number = map.get(key);
            if(number==max){
               maxs.add(key);
                }
        }
        maxs.sort((o1, o2) -> o1-o2);
        Arrays.sort(list);
        System.out.println(Math.round((double)sum/num));
        System.out.println(list[(num/2)]);
        if(maxs.size()>1){
            System.out.println(maxs.get(1));
        }
        else{
            System.out.println(maxNum);
        }
        System.out.println(list[num-1]-list[0]);

    }
    
}