import java.io.*;


class Main {
    public static int[][] list;
    public static int count1 = 0;
    public static int count2 = 0;
    public static int count3 = 0;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        list = new int[N][N];
        for (int i = 0 ; i < N ; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 0 ; j < N ; j++) {
                list[i][j] = Integer.parseInt(s[j]);
            }
        }
        cut(0,0,N);
        System.out.print(count1 + "\n" + count2 + "\n" + count3);
    }

    public static void cut(int x, int y, int size){
        int c1 = 0;
        int c2 = 0;
        int c3 = 0;
        for(int i = x ; i < size + x ; i++){
            for(int j = y; j < size + y ; j++){
                if(list[i][j]==-1) {
                    c1++;
                }
                else if(list[i][j]==0){
                    c2++;
                }
                else{
                    c3++;
                }
            }
        }
        if(c1==size*size){
            count1++;
            return;
        }
        if(c2==size*size){
            count2++;
            return;
        }if(c3==size*size){
            count3++;
            return;
        }
        for(int i = 0 ; i < 3 ; i++){
            for(int j = 0 ; j < 3 ; j++){
                cut(((size/3) * i) + x  , ((size/3) * j) + y,size/3);
            }
        }
    }
}