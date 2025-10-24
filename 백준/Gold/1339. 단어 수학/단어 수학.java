import java.util.*;
import java.io.*;
public class Main {
    static class Counter{
        char c;
        int count;
        Counter(char c , int count){
            this.c = c;
            this.count = count;
        }
    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Counter> list = new ArrayList<>();
        List<String> nums = new ArrayList<>();
        Map<Character,Integer> map = new HashMap<>();

        for(int i = 0 ; i < N ; i++){
            String s = br.readLine();
            nums.add(s);
            for(int a = 0 ; a < s.length() ; a++){
                char c = s.charAt(a);
                int exp = 1;
                for(int b = 1 ; b <= s.length() - a ; b++){
                    exp *= 10;
                }
                if(!map.containsKey(c)){
                    map.put(c, exp);
                }
                else {
                    map.put(c, map.get(c) + exp);
                }
            }
        }

        for(char key : map.keySet()){
            list.add(new Counter(key, map.get(key)));
        }
        list.sort((o1, o2) -> o2.count - o1.count);
        int num = 9;
        for(Counter counter : list){
            map.put(counter.c, num);
            num--;
        }
        StringBuilder sb = new StringBuilder();
        int sum = 0;
        for(String str : nums){
            sb.setLength(0);
            for(int i = 0 ; i < str.length() ; i++){
                sb.append(map.get(str.charAt(i)));
            }
            sum += Integer.parseInt(sb.toString());
        }
        /*for(char key : charToNum.keySet()){
            System.out.println(key + " " + charToNum.get(key));
        }*/
        System.out.print(sum);
    }

}