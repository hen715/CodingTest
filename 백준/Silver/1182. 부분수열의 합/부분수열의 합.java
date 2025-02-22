import java.io.*;

class Main {

    static int N;
    static int S;
    static int[] list;
    static int count = 0;
    static boolean[] visit;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        S = Integer.parseInt(s[1]);
        list = new int[N];
        visit = new boolean[N];
        s = br.readLine().split(" ");
        for(int i = 0 ; i < N ; i++){
            list[i] = Integer.parseInt(s[i]);
        }
        search(0,0);
        if(S==0){
            count--;
        }
        System.out.println(count);
    }


    public static void search(int before, int sum){
        if(sum == S){
            count++;
        }
        for(int i = before ; i < N ; i++){
            if(!visit[i]) {
                visit[i] = true;
                search(i,sum + list[i]);
                visit[i] = false;
            }
        }
    }
}