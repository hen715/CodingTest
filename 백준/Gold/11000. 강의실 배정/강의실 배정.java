import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        PriorityQueue<Point> q = new PriorityQueue<>((o1, o2) -> o1.x-o2.x);
        for(int i = 0 ; i < n ; i++){
            String[] s = bf.readLine().split(" ");
            q.add(new Point(Integer.parseInt(s[0]),Integer.parseInt(s[1])));
        }
        PriorityQueue<Point> room = new PriorityQueue<>((o1, o2) -> o1.y-o2.y);
        while (!q.isEmpty()){
            Point temp = q.poll();
            if(!room.isEmpty()&&room.peek().y<= temp.x){
                room.poll();
            }
            room.add(temp);
        }
        System.out.println(room.size());
    }
}