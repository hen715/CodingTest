import java.io.*;
import java.util.*;


class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");
        int[] list = new int[N];
        for(int i = 0 ; i < s.length ; i++){
            list[i] = Integer.parseInt(s[i]);
        }
        int index1 = 0;
        int index2 = 0;
        int index3 = 0;
        long min = Long.MAX_VALUE;
        Arrays.sort(list);
        for(int i = 0 ; i < N ; i++){
            int start = 0;
            int end = N-1;
            while (start<end){
                if(start==i){
                    start++;
                    continue;
                }
                if(end==i){
                    end--;
                    continue;
                }
                long sum = Math.abs((long)list[i] + list[start] + list[end]);
                if(sum<min){
                    index1 = i;
                    index2 = start;
                    index3 = end;
                    min = sum;
                }
                if (list[start] + list[end] < (list[i] * -1)) {
                    start++;
                } else {
                    end--;
                }
            }
        }
        int[] answer = new int[3];
        answer[0] = list[index1];
        answer[1] = list[index2];
        answer[2] = list[index3];
        Arrays.sort(answer);
        for(int i : answer){
            sb.append(i).append(" ");
        }
        System.out.print(sb);
    }

}