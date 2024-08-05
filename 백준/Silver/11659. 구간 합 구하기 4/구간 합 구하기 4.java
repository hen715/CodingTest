import java.io.*;


class Main {


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb  = new StringBuilder();
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        int[] sum = new int[n];
        s = br.readLine().split(" ");
        sum[0] = Integer.parseInt(s[0]);
        if(n > 1){
            for(int i = 1;  i < n ; i++){
                sum[i] = sum[i-1] + Integer.parseInt(s[i]);
            }
        }
        int start;
        int end;
        for(int i = 0 ; i < m ; i ++){
            s = br.readLine().split(" ");
            start = Integer.parseInt(s[0]) - 1;
            end = Integer.parseInt(s[1]) - 1;
            if(start ==0){
                sb.append(sum[end]+"\n");
            }
            else if(start==end){
                sb.append(sum[end]-sum[end-1]+"\n");
            }
            else{
                sb.append(sum[end]-sum[start-1]+"\n");
            }
        }
        System.out.println(sb);
    }

}