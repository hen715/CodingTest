import java.io.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] s = bf.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        int[][] list1 = new int[n][m];
        int[][] list2 = new int[n][m];
        if(m<3||n<3){
            for(int i = 0; i<n;i++){
                String str = bf.readLine();
                for(int j = 0 ; j < m ; j++){
                    list1[i][j] = str.charAt(j)-48;
                }
            }
            for(int i = 0; i<n;i++){
                String str = bf.readLine();
                for(int j = 0 ; j < m ; j++){
                    list2[i][j] = str.charAt(j)-48;
                }
            }
            for(int i = 0; i<n;i++){
                for(int j = 0 ; j < m ; j++){
                    if(list1[i][j]!=list2[i][j]){
                        System.out.println(-1);
                        return;
                    }
                }
            }
            System.out.println(0);
            return;
        }

        for(int i = 0; i<n;i++){
            String str = bf.readLine();
            for(int j = 0 ; j < m ; j++){
                list1[i][j] = str.charAt(j)-48;
            }
        }
        for(int i = 0; i<n;i++){
            String str = bf.readLine();
            for(int j = 0 ; j < m ; j++){
                if(list1[i][j] != str.charAt(j)-48){
                    list2[i][j] = 1;
                }
            }
        }
        int count = 0;
        for(int i = 0 ; i <= n- 3 ; i++){
            for(int j = 0 ; j <= m - 3 ;j++){
                if(list2[i][j]==1){
                    count++;
                    for(int a = 0 ; a < 3 ; a++){
                        for(int b = 0 ; b < 3 ; b++){
                            if(list2[i+a][j+b]==1){
                                list2[i+a][j+b] = 0;
                            }
                            else{
                                list2[i+a][j+b] = 1;
                            }
                        }
                    }
                }
            }
        }
        for(int i = 0 ; i < n;i++){
            for(int j = 0 ; j < m; j++ ){
                if(list2[i][j]==1){
                    System.out.println(-1);
                    return;
                }
            }
        }
        System.out.println(count);
    }
}