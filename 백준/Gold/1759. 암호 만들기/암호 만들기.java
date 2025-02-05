import java.io.*;
import java.util.*;

class Main {
    static int L;
    static int C;
    static StringBuilder sb;
    static char[] list;
    static char[] answer;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        L = Integer.parseInt(s[0]);
        C = Integer.parseInt(s[1]);
        list = new char[C];
        answer = new char[L];
        visit = new boolean[C];
        s = br.readLine().split(" ");
        for(int i = 0 ; i < C ; i++){
            list[i] = s[i].charAt(0);
        }
        sb = new StringBuilder();
        Arrays.sort(list);
        backTracking(0,0);
        System.out.print(sb);
    }

    public static void backTracking(int depth,int index){
        if(depth==L){
            int count1 = 0;
            int count2 = 0;
            for(char c : answer){
                sb.append(c);
                if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u'){
                    count1++;
                }
                else{
                    count2++;
                }
            }
            sb.append("\n");
            if(count1<1||count2<2){
                sb.setLength(sb.length()-L-1);
            }
            return;
        }
        for(int i = 0 ; i < C ; i++){
            if(!visit[i]&&i>=index) {
                visit[i] = true;
                answer[depth] = list[i];
                backTracking(depth + 1,i);
                visit[i] = false;
            }
        }
    }
}