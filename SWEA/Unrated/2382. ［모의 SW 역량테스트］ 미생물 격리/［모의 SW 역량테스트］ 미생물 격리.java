import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Solution
{
    static class Bug{
        int x;
        int y;
        int num;
        int way;
        Bug(int x , int y, int num, int way){
            this.x = x;
            this.y = y;
            this.num = num;
            this.way = way;
        }
    }
    // 상:1 하:2 좌:3 우:4
    static int N,M,K;
    static List<Bug> list;
    static HashMap<Integer,List<Bug>> map;
    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int tc = 1 ; tc <= T ; tc++){
            String[] s = br.readLine().split(" ");
            N = Integer.parseInt(s[0]);
            M = Integer.parseInt(s[1]);
            K = Integer.parseInt(s[2]);
            list = new ArrayList<>();
            for(int i = 0 ; i  < K ; i++){
                s = br.readLine().split(" ");
                list.add(new Bug(Integer.parseInt(s[1]),Integer.parseInt(s[0]),Integer.parseInt(s[2]),Integer.parseInt(s[3])));
            }
            for(int i = 0 ; i < M ; i++){
                move();
            }
            int sum = 0;
            for(Bug bug : list){
                sum += bug.num;
            }

            sb.append('#').append(tc).append(' ').append(sum).append('\n');
        }
        System.out.print(sb);
    }
    static void move(){
        map = new HashMap<>();
        for(int i = 0 ; i < list.size() ; i++){
            Bug bug = list.get(i);
            if(bug.way==1){
                bug.y -= 1;
                if(bug.y==0){
                    bug.num /= 2;
                    bug.way = 2;
                }
            }
            else if(bug.way==2){
                bug.y += 1;
                if(bug.y==N-1){
                    bug.num /= 2;
                    bug.way = 1;
                }
            }
            else if(bug.way==3){
                bug.x -= 1;
                if(bug.x==0){
                    bug.num /= 2;
                    bug.way = 4;
                }
            }
            else{
                bug.x += 1;
                if(bug.x==N-1){
                    bug.num /= 2;
                    bug.way = 3;
                }
            }
            //System.out.println(bug.x +" "+ bug.y+ " "+ bug.num);
            map.putIfAbsent(bug.x + bug.y * 10000,new ArrayList<>());
            map.get(bug.x + bug.y * 10000).add(bug);
        }
        for(int key : map.keySet()){
            if(map.get(key).size()>1){
                int maxIndex = 0;
                int sum =0;
                List<Bug> bugs = map.get(key);
                for(int i = 0 ; i < bugs.size() ; i++){
                    sum += bugs.get(i).num;
                    if(bugs.get(i).num>bugs.get(maxIndex).num){
                        maxIndex = i;
                    }
                }
                bugs.get(maxIndex).num = sum;
                for(int i = 0 ; i < bugs.size() ; i++){
                    if(i==maxIndex){
                        continue;
                    }
                    list.remove(bugs.get(i));
                }
            }
        }
    }


}