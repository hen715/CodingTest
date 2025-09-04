import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    static class Atom{
        int x;
        int y;
        int way;
        int p;
        boolean isDelete;
        Atom(int x, int y,int way,int p){
            this.x = x;
            this.y = y;
            this.way = way;
            this.p = p;
            this.isDelete = false;
        }
    }
    static class Node{
        int x;
        int y;
        Node(int x, int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object obj) {
            Node n = (Node)obj;
            return this.x==n.x&&this.y==n.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(this.x,this.y);
        }
    }
    static int power;
    static HashMap<Node,Atom> past;
    static HashMap<Node,Atom> current;
    static List<Atom> list;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int t = 1 ; t <= T ; t++) {
            N = Integer.parseInt(br.readLine());
            String[] s;
            power = 0;
            list = new ArrayList<>();
            past = new HashMap<>();

            for(int i = 0 ; i < N ; i++){
                s = br.readLine().split(" ");
                list.add(new Atom(Integer.parseInt(s[0]),Integer.parseInt(s[1]),Integer.parseInt(s[2]),Integer.parseInt(s[3])));
            }
            for(Atom atom : list){
                past.put(new Node(atom.x,atom.y),atom);
            }
            Set<Atom> delete;
            while (!list.isEmpty()){
                current = new HashMap<>();
                delete = new HashSet<>();
                int size = list.size();
                for(int i = 0 ; i < size ; i++){
                    Atom a = list.get(i);
                    if(a.isDelete){
                        continue;
                    }
                    if(a.way==0){
                        a.y++;
                    }
                    else if(a.way==1){
                        a.y--;
                    }
                    else if(a.way==2){
                        a.x--;
                    }
                    else{
                        a.x++;
                    }
                    if(a.x<-1000||a.x>1000||a.y<-1000||a.y>1000){
                        delete.add(a);
                        a.isDelete = true;
                        continue;
                    }
                    Node key = new Node(a.x,a.y);
                    if(past.containsKey(key)&&!past.get(key).isDelete){
                        if(a.way==0&&past.get(key).way==1
                        ||a.way==1&&past.get(key).way==0
                        ||a.way==2&&past.get(key).way==3
                        ||a.way==3&&past.get(key).way==2){
                            a.isDelete = true;
                            past.get(key).isDelete = true;
                            delete.add(a);
                            delete.add(past.get(key));
                            continue;
                        }
                    }
                    if(current.containsKey(key)){
                        a.isDelete = true;
                        delete.add(a);
                        if(!current.get(key).isDelete){
                            current.get(key).isDelete = true;
                            delete.add(current.get(key));
                        }
                    }
                    else{
                        current.put(key,a);
                    }
                }
                for(Atom a : delete){
                    list.remove(a);
                    if(a.x<-1000||a.x>1000||a.y<-1000||a.y>1000){
                        continue;
                    }
                    power += a.p;
                }
                past = current;
            }

            sb.append('#').append(t).append(' ').append(power);
            if(t!=T) {
                sb.append('\n');
            }
        }
        System.out.print(sb);

    }



}