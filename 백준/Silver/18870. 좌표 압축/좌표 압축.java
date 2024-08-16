import java.io.*;
import java.util.*;

class Main {


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[] list = new int[n];
        Set<Integer> set = new HashSet<>();
        String[] s = br.readLine().split(" ");
        for(int i = 0; i < n ; i++){
            int num = Integer.parseInt(s[i]);
            list[i] = num;
            set.add(num);
        }
        Object[] nums = set.toArray();
        Arrays.sort(nums);
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0 ; i < set.size() ; i++){
            map.put(Integer.parseInt(nums[i].toString()),i);
        }
        for(int i = 0 ; i < n ; i++){
            sb.append(map.get(list[i])+" ");
        }
        System.out.println(sb);
    }
}