import java.io.*;


class Main {
    static int N;
    static int[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);
        list = new int[N];
        for(int i = 0 ; i < N ; i++){
            list[i] = i;
        }
        int point = 0;
        for(int i = 0 ; i < M ; i++){
            s = br.readLine().split(" ");
            int start = Integer.parseInt(s[0]);
            int end = Integer.parseInt(s[1]);
            if(point!=0){
                continue;
            }
            if(check(start,end)){
                point = i+1;
            }
            else {
                int a = parent(start);
                int b = parent(end);
                list[a] = b;
            }

        }
        System.out.print(point);
    }
    public static boolean check(int a, int b){
        return parent(a)==parent(b);
    }

    public static int parent(int num){
        if(list[num]==num){
            return num;
        }
        return list[num] = parent(list[num]);
    }
}