import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    static class Node{
        int now;
        int count;
        public Node(int now, int count){
            this.now = now;
            this.count = count;
        }
    }
    static HashMap<Integer, List<Integer>> map;
    static Set<Integer> set;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = 10;
        StringBuilder sb = new StringBuilder();
        map = new HashMap<>();
        set = new HashSet<>();
        for(int t = 1 ; t <= T ; t++) {
            map.clear();
            set.clear();
            String[] s = br.readLine().split(" ");
            int length = Integer.parseInt(s[0]);
            int start = Integer.parseInt(s[1]);
            s = br.readLine().split(" ");
            int to,from;
            for(int i = 0 ; i < length ; i += 2){
                to = Integer.parseInt(s[i]);
                from = Integer.parseInt(s[i+1]);
                if(map.containsKey(to)){
                    map.get(to).add(from);
                }
                else{
                    map.put(to,new ArrayList<>());
                    map.get(to).add(from);
                }
                if(!map.containsKey(from)){
                    map.put(from,new ArrayList<>());
                }
            }
            int max = 0;
            int mIndex = 0;
            ArrayDeque<Node> q = new ArrayDeque<>();
            q.offerLast(new Node(start,0));
            set.add(start);
            while (!q.isEmpty()){
                Node node = q.poll();
                if(node.count>max){
                    max = node.count;
                    mIndex = node.now;
                }
                else if(node.count==max){
                    mIndex = Math.max(mIndex, node.now);
                }
                for(int next : map.get(node.now)){
                    if(!set.contains(next)){
                        set .add(next);
                        q.offerLast(new Node(next, node.count + 1));
                    }
                }
            }

            sb.append('#').append(t).append(' ').append(mIndex).append('\n');

        }
        System.out.print(sb);
    }



}