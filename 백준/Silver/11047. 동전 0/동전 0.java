import java.io.*;


class Main {


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int money = Integer.parseInt(s[1]);
        int count  = 0;
        int[] coin = new int[n];
        for(int i = 0 ; i < n ; i++){
            coin[i] = Integer.parseInt(br.readLine());
        }
        for(int i = n-1 ; i >=0; i--){
            while(money>=coin[i]){
                money -= coin[i];
                count++;
            }
        }
        System.out.println(count);
    }

}