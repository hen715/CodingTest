import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = 10;
        StringBuilder sb = new StringBuilder();
        for(int t = 1 ; t <= T ; t++) {
            int N = Integer.parseInt(br.readLine());
            List<Integer> list = new LinkedList<>();
            String[] s = br.readLine().split(" ");
            for(int i = 0 ; i < N ; i++){
                list.add(Integer.parseInt(s[i]));
            }
            N = Integer.parseInt(br.readLine());
            s = br.readLine().split(" ");
            int i = 0;
            while (i < s.length){
                if(s[i].charAt(0)=='I'){
                    int index = Integer.parseInt(s[++i]);
                    int num = Integer.parseInt(s[++i]);
                    for(int a = 0 ; a < num ; a++){
                        list.add(index++, Integer.parseInt(s[++i]));
                    }
                }
                else if(s[i].charAt(0)=='D'){
                    int index = Integer.parseInt(s[++i]);
                    int num = Integer.parseInt(s[++i]);
                    for(int a = 0 ; a < num ; a++){
                        list.remove(index);
                    }
                }
                else if(s[i].charAt(0)=='A'){
                    int num = Integer.parseInt(s[++i]);
                    for(int a = 0 ; a < num ; a++){
                        list.add(Integer.parseInt(s[++i]));
                    }
                }
                i++;
            }

            sb.append('#').append(t).append(' ');
            for(i = 0 ; i < 10 ; i++){
                sb.append(list.get(i)).append(' ');
            }
            sb.append('\n');

        }
        System.out.print(sb);
    }

}