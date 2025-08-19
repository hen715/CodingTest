import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Solution {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int t = 1 ; t <= T ; t++) {
            int N = Integer.parseInt(br.readLine());
            int[] list = new int[N];
            int max = 0;
            String[] s = br.readLine().split(" ");
            for(int i = 0 ; i <N ; i++){
                list[i] = Integer.parseInt(s[i]);
                max = Math.max(max,list[i]);
            }
            for(int i = 0 ; i <N ; i++){
                list[i] = max - list[i];
            }

            int day = 1;
            while (true){
                int grow = 0;
                if(day%2==1){
                    grow = 1;
                }
                else{
                    grow = 2;
                }
                int maxIndex = 0;
                for(int i = 0 ; i <N ; i++){
                    if(list[maxIndex]<list[i]){
                        maxIndex = i;
                    }
                }
                if(list[maxIndex]==0){
                    day--;
                    break;
                }
                if(list[maxIndex]==2 && grow==2){
                    list[maxIndex] -=2;
                    day++;
                }
                else if(list[maxIndex]==2 && grow==1){
                    boolean end = false;
                    for(int i = 0 ; i <N ; i++){
                        if(list[i] ==1){
                            list[i]--;
                            end = true;
                            break;
                        }
                    }
                    if(end){
                        day++;
                        continue;
                    }
                    for(int i = 0 ; i <N ; i++){
                        if(i!=maxIndex&&list[i] ==2){
                            list[i]--;
                            break;
                        }
                    }
                    day++;
                }
                else if(list[maxIndex]==1&&grow==1){
                    list[maxIndex]--;
                    day++;
                }
                else if(list[maxIndex]==1&&grow==2){
                    day++;
                }
                else if(list[maxIndex]>2){
                    boolean end =false;
                    for(int i = 0 ; i <N ; i++){
                        if(list[i]==grow){
                            list[i] -= grow;
                            end = true;
                            break;
                        }
                    }
                    if(!end){
                        list[maxIndex] -=grow;
                    }
                    day++;
                }
            }


            sb.append('#').append(t).append(' ').append(day);
            if(t!=T) {
                sb.append('\n');
            }
        }
        System.out.print(sb);
    }



}