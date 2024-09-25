import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Iterator;

class Main {




    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < T; i++){
            ArrayDeque<Integer> deque = new ArrayDeque<>();
            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String temp = br.readLine();
            if(n!=0) {
                String[] s = temp.substring(1, temp.length() - 1).split(",");
                for (String str : s) {
                    deque.add(Integer.parseInt(str));
                }
            }
            boolean isR = false;
            boolean isError = false;
            for(int a = 0 ; a < p.length() ;a++){
                if(p.charAt(a)=='R'){
                    isR = !isR;
                }
                if(p.charAt(a)=='D'){
                    if(deque.isEmpty()){
                        isError = true;
                        break;
                    }
                    if(isR){
                        deque.removeLast();
                    }
                    else{
                        deque.removeFirst();
                    }
                }
            }
            if(isError){
                sb.append("error\n");
            }
            else if(!isR){
                sb.append("[");
                Iterator<Integer> iterator = deque.iterator();
                while (iterator.hasNext()){
                    sb.append(iterator.next());
                    if(iterator.hasNext()){
                        sb.append(",");
                    }
                }
                sb.append("]\n");
            }
            else if(isR){
                sb.append("[");
                Iterator<Integer> iterator = deque.descendingIterator();
                while (iterator.hasNext()){
                    sb.append(iterator.next());
                    if(iterator.hasNext()){
                        sb.append(",");
                    }
                }
                sb.append("]\n");
            }
        }
        System.out.println(sb);
    }

}