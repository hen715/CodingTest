import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n  = Integer.parseInt(bf.readLine());
        int k =  Integer.parseInt(bf.readLine());
        if(k>n){
            System.out.println(0);
            return;
        }
        int[] list = new int[n];
        PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2) -> o2[2]-o1[2]);
        String[] s = bf.readLine().split(" ");
        for(int i = 0 ; i < n ; i++){
            list[i] = Integer.parseInt(s[i]);
        }
        boolean[][] check = new boolean[n][n];

        Arrays.sort(list);


        for(int i = 1; i <n ; i++){
            int[] num = new int[3];
            num[0] = i-1;
            num[1] = i;
            num[2] = list[i] - list[i-1];
            q.add(num);
        }


        for(int i =0; i < k -1; i++){
            int[] num = q.poll();
            check[num[0]][num[1]] = true;
        }
        int point = 0;
        int sum = 0;
        for(int i=0;i<n;i++){
            for(int j = 0 ; j<n; j++){
                if(check[i][j]){
                    sum += list[i] - list[point];
                    point = j;
                }
            }
        }
        sum += list[n-1] - list[point];


        System.out.println(sum);


    }
}