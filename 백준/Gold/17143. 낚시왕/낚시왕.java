import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static class Node{
        int x;
        int y;
        int speed;
        int way;
        int size;
        public Node(int x,int y, int speed , int way, int size){
            this.x = x;
            this.y = y;
            this.speed = speed;
            this.way = way;
            this.size = size;
        }
    }

    static int sum = 0;
    static int R;
    static int C;
    static int M;
    static Node[][] list;
    static List<Node> shark;
    static int[] Rlist;
    static int[] Clist;
    static Queue<Node> q;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        R = Integer.parseInt(s[0]);
        C = Integer.parseInt(s[1]);
        M = Integer.parseInt(s[2]);
        list = new Node[R+1][C+1];
        shark = new ArrayList<>();
        Rlist = new int[R * 2 - 2];
        Clist = new int[C * 2 - 2];
        int num = 0;
        for(int i = 0 ; i < R * 2 - 2 ; i++){
            if(i<R){
                Rlist[i] = ++num;
            }
            else{
                Rlist[i] = --num;
            }
        }
        num = 0;
        q = new LinkedList<>();
        for(int i = 0 ; i < C * 2 - 2 ; i++){
            if(i < C){
                Clist[i] = ++num;
            }
            else{
                Clist[i] = --num;
            }
        }
        for(int i = 0 ; i < M ; i++){
            s = br.readLine().split(" ");
            int r = Integer.parseInt(s[0]);
            int c = Integer.parseInt(s[1]);
            int sp = Integer.parseInt(s[2]);
            int d = Integer.parseInt(s[3]);
            int z = Integer.parseInt(s[4]);
            Node node = new Node(r,c,sp,d,z);
            shark.add(node);
            list[r][c] = node;
        }
        for(int i = 1 ; i <= C ; i++){
            sum += catchShark(i);
            //System.out.println(sum);
            moveShark();
            //print();
        }
        System.out.print(sum);
    }

    /*public static void print(){
        for(int i = 1 ; i <= R  ; i++){
            for(int j = 1 ; j <= C ; j++){
                if(list[i][j]!=0) {
                    System.out.print(shark.get(list[i][j]).size + " ");
                }
                else{
                    System.out.print(0 + " ");
                }
            }
            System.out.println();
        }
    }*/
    public static int catchShark(int y){
        int size = 0;
        for(int i = 1 ; i <= R ; i++){
            if(list[i][y]!=null){
                size = list[i][y].size;
                shark.remove(list[i][y]);
                list[i][y] = null;
                break;
            }
        }
        return size;
    }

    public static void moveShark(){
        list = new Node[R + 1][C + 1];
        for(int i = 0 ; i < shark.size() ; i++){
            //위 역방향, 아래 정방향, 오른쪽 정방향, 왼쪽 역방향
            Node node = shark.get(i);
            if(node.way==1){
                int index = Rlist.length - (node.x-1);
                int des = (index + node.speed) % Rlist.length;
                node.x = Rlist[des];
                if(des<R){
                    node.way = 2;
                }
            }
            else if(node.way==2){
                int index = node.x - 1;
                int des = (index + node.speed) % Rlist.length;
                node.x = Rlist[des];
                if(des>=R){
                    node.way = 1;
                }
            }
            else if(node.way==3){
                int index = node.y - 1;
                int des = (index + node.speed) % Clist.length;
                node.y = Clist[des];
                if(des>=C){
                    node.way = 4;
                }
            }
            else if(node.way==4){
                int index = Clist.length - (node.y-1);
                int des = (index + node.speed) % Clist.length;
                node.y = Clist[des];
                if(des<C){
                    node.way = 3;
                }
            }
            validEat(i);
        }
        while (!q.isEmpty()){
            shark.remove(q.poll());
        }
    }

    public static void validEat(int index){
        Node node = shark.get(index);
        if(list[node.x][node.y]==null){
            list[node.x][node.y] = node;
        }
        else{
            Node pre = list[node.x][node.y];
            if(pre.size < node.size){
                list[node.x][node.y] = node;
                q.add(pre);
            }
            else{
                q.add(node);
            }
        }
    }
}