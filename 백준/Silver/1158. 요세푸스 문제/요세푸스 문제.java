import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int K = Integer.parseInt(s[1]);
        Queue<Integer> q = new LinkedList<>();
        for(int i = 1 ; i <= N ; i++){
            q.add(i);
        }
        StringBuilder sb = new StringBuilder();
        sb.append('<');
        int index = 0;
        while (!q.isEmpty()){
            index++;
            if(index%K==0){
                sb.append(q.poll()).append(", ");
            }
            else {
                int temp = q.poll();
                q.add(temp);
            }
        }
        sb.delete(sb.length()-2,sb.length());
        sb.append('>');
        System.out.println(sb);
    }
}