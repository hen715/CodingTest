import java.io.*;

class Main {


    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       String str = br.readLine();
       int[][] list = new int[str.length()][26];
       list[0][str.charAt(0)-97]++;
       for(int i = 1 ; i < str.length() ; i++){
           for(int j = 0 ; j < 26 ; j++){
               list[i][j] = list[i-1][j];
           }
           list[i][str.charAt(i)-97]++;
       }
       StringBuilder sb = new StringBuilder();
       int q = Integer.parseInt(br.readLine());
       for(int i = 0 ; i < q ; i++){
           String[] s =br.readLine().split(" ");
           char a = Character.valueOf(s[0].charAt(0));
           int l = Integer.parseInt(s[1]);
           int r = Integer.parseInt(s[2]);
           if(l==0){
               sb.append(list[r][a-97] ).append("\n");
           }
           else {
               sb.append(list[r][a - 97] - list[l-1][a - 97]).append("\n");
           }
       }
       System.out.print(sb);
    }

}