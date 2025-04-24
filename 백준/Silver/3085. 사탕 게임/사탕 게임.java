import java.io.*;


class Main {
    static int max = 0;
    static char[][] list;
    static int N;



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        list = new char[N][N];
        for(int i = 0 ; i < N ; i++){
            String s = br.readLine();
            for(int j = 0 ; j < N ; j++){
                list[i][j] = s.charAt(j);
            }
        }
        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < N ; j++){
                check(i,j);
            }
        }
        System.out.print(max);
    }

    public static void check(int i, int j){
        if(i+1<N){
            char temp = list[i][j];
            list[i][j] = list[i+1][j];
            list[i+1][j] = temp;
            getMax();
            list[i+1][j] = list[i][j];
            list[i][j] = temp;
        }
        if(j+1<N){
            char temp = list[i][j];
            list[i][j] = list[i][j+1];
            list[i][j+1] = temp;
            getMax();
            list[i][j+1] = list[i][j];
            list[i][j] = temp;
        }
    }

    public static void getMax(){

        for(int i = 0 ; i < N ; i++){
            int count = 1;
            for(int j = 1 ; j < N ; j++){
                if(list[i][j]==list[i][j-1]){
                    count++;
                }
                else{
                    count = 1;
                }
                max = Math.max(max,count);
            }
        }
        for(int i = 0 ; i < N ; i++){
            int count = 1;
            for(int j = 1 ; j < N ; j++){
                if(list[j][i]==list[j-1][i]){
                    count++;
                }
                else{
                    count = 1;
                }
                max = Math.max(max,count);
            }
        }
    }
}
