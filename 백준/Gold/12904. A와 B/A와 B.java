import java.io.*;



public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        String T = br.readLine();
        StringBuilder sb = new StringBuilder();
        sb.append(T);
        for(int i = T.length() - 1 ; i >= S.length() ; i--){
            if(sb.charAt(i)=='A'){
                sb.deleteCharAt(i);
            }
            else if(sb.charAt(i)=='B'){
                sb.deleteCharAt(i);
                sb.reverse();
            }
        }
        if(sb.toString().equals(S)){
            System.out.print(1);
        }
        else{
            System.out.print(0);
        }


    }
}