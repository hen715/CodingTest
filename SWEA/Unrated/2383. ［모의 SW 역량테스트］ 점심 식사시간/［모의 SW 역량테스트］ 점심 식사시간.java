import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    static class Person{
        int x;
        int y;
        int dis;
        int endTime;
        Person(int x , int y){
            this.x = x;
            this.y = y;
        }
    }
    static class Stair{
        int x;
        int y;
        int depth;
        Stair(int x,int y, int depth){
            this.x = x;
            this.y = y;
            this.depth = depth;
        }
    }
    static int N;
    static int min;
    static List<Person> list;
    static List<Stair> stairs;
    static boolean[] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int t = 1 ; t <= T ; t++) {
            N = Integer.parseInt(br.readLine());
            String[] s;
            list = new ArrayList<>();
            stairs = new ArrayList<>();
            min = Integer.MAX_VALUE;
            for(int i = 0 ; i < N ; i++){
                s = br.readLine().split(" ");
                for(int j = 0 ; j < N  ;j++){
                    int num = Integer.parseInt(s[j]);
                    if(num == 1){
                        list.add(new Person(i,j));
                    }
                    if(num>=2){
                        stairs.add(new Stair(i,j,num));
                    }
                }
            }
            visit = new boolean[list.size()];
            search(0);
            sb.append('#').append(t).append(' ').append(min+1);
            if(t!=T) {
                sb.append('\n');
            }
        }
        System.out.print(sb);
    }

    public static void search(int depth){
        if(depth==list.size()){
            calc();
            return;
        }
        visit[depth] = true;
        search(depth+1);
        visit[depth] = false;
        search(depth+1);
    }

    public static void calc(){
        PriorityQueue<Person> p1 = new PriorityQueue<>((o1,o2)->o1.dis - o2.dis);
        PriorityQueue<Person> p2 = new PriorityQueue<>((o1,o2)->o1.dis - o2.dis);
        for(int i = 0 ; i < list.size() ; i++){
            Person p = list.get(i);
            if(visit[i]){
                p.dis = Math.abs(p.x - stairs.get(0).x) + Math.abs(p.y - stairs.get(0).y);
                p1.add(p);
            }
            else{
                p.dis = Math.abs(p.x - stairs.get(1).x) + Math.abs(p.y - stairs.get(1).y);
                p2.add(p);
            }
        }
        Queue<Person> waitQ = new ArrayDeque<>();
        while (!p1.isEmpty()){
            Person now = p1.poll();
            if(waitQ.size()>=3){
                Person pp = waitQ.poll();
                if(now.dis <= pp.endTime) {
                    now.endTime = pp.endTime + stairs.get(0).depth;
                }
                else{
                    now.endTime = now.dis + stairs.get(0).depth;
                }
            }
            else {
                now.endTime = now.dis + stairs.get(0).depth;
            }
            waitQ.add(now);
        }
        int t1 = 0;
        while (!waitQ.isEmpty()){
            Person pp = waitQ.poll();
            t1 = pp.endTime;
        }

        while (!p2.isEmpty()){
            Person now = p2.poll();
            if(waitQ.size()>=3){
                Person pp = waitQ.poll();
                if(now.dis <= pp.endTime) {
                    now.endTime = pp.endTime + stairs.get(1).depth;
                }
                else{
                    now.endTime = now.dis + stairs.get(1).depth;
                }
            }
            else {
                now.endTime = now.dis + stairs.get(1).depth;
            }
            waitQ.add(now);
        }
        int t2=0;
        while (!waitQ.isEmpty()){
            Person pp = waitQ.poll();
            t2 = pp.endTime;
        }
        int t3 = Math.max(t1,t2);
        min = Math.min(min,t3);


    }


}