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
        boolean isSame = true;
        for(int i = x ; i < size + x ; i++){
            for(int j = y; j < size + y ; j++){
                if(list[i][j]!=list[x][y]){
                    isSame = false;
                    break;
                }
            }
        }
        if(isSame){
            if(list[x][y]==-1){
                count1++;
            }
            else if(list[x][y]==0){
                count2++;
            }
            else{
                count3++;
            }
            return;
        }
        for(int i = 0 ; i < 3 ; i++){
            for(int j = 0 ; j < 3 ; j++){
                cut(((size/3) * i) + x  , ((size/3) * j) + y,size/3);
            }
        }
    }
}