import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int[] list1 = new int[n];
        String[] s = br.readLine().split(" ");
        for(int i = 0 ; i < n ; i++){
            list1[i] = Integer.parseInt(s[i]);
        }
        int m = Integer.parseInt(br.readLine());
        s = br.readLine().split(" ");
        int[] list2 = new int[m];
        for(int i = 0 ; i < m ; i++){
            list2[i] = Integer.parseInt(s[i]);
        }
        List<Integer> sum1 = new ArrayList<>();
        List<Integer> sum2 = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            int sum = 0;
            for(int j = i ; j < n ; j++){
                if(i==j){
                    sum = list1[i];
                }
                else {
                    sum += list1[j];
                }
                sum1.add(sum);
            }
        }
        for(int i = 0 ; i < m ; i++){
            int sum = 0;
            for(int j = i ; j < m ; j++){
                if(i==j){
                    sum = list2[i];
                }
                else {
                    sum += list2[j];
                }
                sum2.add(sum);
            }
        }
        Collections.sort(sum1);
        Collections.sort(sum2);
        int point1 = 0;
        int point2 = sum2.size()-1;
        long count = 0;
        while (point1<sum1.size()&&point2>=0){
            if(sum1.get(point1)+sum2.get(point2)==T){
                int num = sum1.get(point1);
                int c1 = 0;
                while (point1<sum1.size()&&sum1.get(point1)==num){
                    point1++;
                    c1++;
                }
                int c2 = 0;
                num = sum2.get(point2);
                while (point2>=0&&sum2.get(point2)==num){
                    point2--;
                    c2++;
                }
                count += (long)c1 * c2;
            }
            else if(sum1.get(point1)+sum2.get(point2)>T){
                point2--;
            }
            else{
                point1++;
            }

        }
        System.out.println(count);
    }

}