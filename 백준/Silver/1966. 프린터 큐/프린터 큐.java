import java.awt.*;
import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int num = Integer.parseInt(br.readLine());
        for (int i = 0 ; i < num ; i++){
            String[] s = br.readLine().split(" ");
            int size = Integer.parseInt(s[0]);
            int where = Integer.parseInt(s[1]);
            int[][] list = new int[size][2];
            s = s = br.readLine().split(" ");
            Queue<Point> q = new LinkedList<>();
            Set<Integer> set = new HashSet<>();
            Map<Integer,Integer> map = new HashMap();
            for(int a = 0 ; a <size ; a++){
                int number = Integer.parseInt(s[a]);
                Point p = new Point(number,0);
                if(a == where){
                    p.y = 1;
                }
                if(map.containsKey(number)){
                    int c = map.get(number);
                    map.put(number,c+1);
                }
                else{
                    map.put(number,1);
                }
                set.add(number);
                q.add(p);
            }
            int count = 0;
            int y = -1;
            while(y!=1){
                Point p = q.poll();
                boolean isBig = false;
                for(int key : set){
                    if(p.x<key){
                        q.add(p);
                        isBig = true;
                        break;
                    }
                }
                if(!isBig){
                    int c = map.get(p.x);
                    c--;
                    if(c==0){
                        set.remove(p.x);
                        map.remove(p.x);
                    }
                    else{
                        map.put(p.x,c);
                    }
                    count++;
                    y = p.y;
                }
            }
            sb.append(count+"\n");

        }
        System.out.println(sb);

    }

}