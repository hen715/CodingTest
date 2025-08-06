import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Solution {
    static int[] list;
    static boolean[] visit;
    static int[] num;
    static int win;
    static int lose;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int tc = 1 ; tc <= T ; tc++){
            String[] s = br.readLine().split(" ");
            list = new int[9];
            visit = new boolean[19];
            num = new int[9];
            win = 0;
            lose = 0;
            for(int i = 0 ; i < 9 ; i++){
                list[i] = Integer.parseInt(s[i]);
                visit[list[i]] = true;
            }
            search(0);

            sb.append('#').append(tc).append(' ').append(win).append(' ').append(lose);
            if(tc!=T){
                sb.append('\n');
            }
        }
        System.out.print(sb);
    }
    public static void search(int depth){
        if(depth==9){
            fight();
            return;
        }
        for(int i = 1 ; i < 19 ; i++){
            if(!visit[i]){
                visit[i] = true;
                num[depth] = i;
                search(depth+1);
                visit[i] = false;
            }
        }
    }

    public static void fight(){
        int p1 = 0;
        int p2 = 0;
        for(int i = 0 ; i < 9 ; i++){
            if(list[i] > num[i]){
                p1 += list[i] + num[i];
            }
            if(list[i] < num[i]){
                p2 += list[i] + num[i];
            }
        }
        if(p1>p2){
            win++;
        }
        else if(p1 < p2){
            lose++;
        }
    }

}