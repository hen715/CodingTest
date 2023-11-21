import java.util.*;

public class Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Map<Integer,PriorityQueue<Integer>> map = new HashMap<>();
        int max = -1;
        for(int i = 0 ; i<n;i++){
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            if(end>max){
                max = end;
            }
            PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
            if(map.containsKey(end)){
                queue = map.get(end);
                queue.add(start);
                map.put(end,queue);
            }
            else{
                queue.add(start);
                map.put(end,queue);
            }

        }
        int count = 0;
        int time = 0;
        int st = 0;
        while(true){
            if(map.containsKey(time)){
                //System.out.println("타임 :"+time);
                PriorityQueue<Integer> q = map.get(time);
                    while (true){
                        int tmp = q.poll();
                        if(tmp == time){
                            count++;
                            if(q.isEmpty()){
                                st = time;
                                time++;
                                break;
                            }
                        }
                        else if(tmp>=st){
                            /*System.out.println("큐 뽑은값 :" +tmp);
                            System.out.print(time);
                            System.out.println(tmp);*/
                            st = time;
                            time++;
                            count++;
                            break;
                        }
                        else if(q.isEmpty()){
                            time++;
                            break;
                        }
                    }
            }
            else{
                time++;
            }
            if (time>max)
                break;

        }
        System.out.println(count);
    }

}