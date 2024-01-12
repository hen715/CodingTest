import java.util.*;

public class Main {

    static int max = 0;
    static int c = 0;
    public static void search(int i , int j,int[][] matrix, int[][] visited,int a, int b){
        visited[i][j]=1;
        c++;
        if(i-1>=0&&visited[i-1][j]==0&&matrix[i-1][j]==1)
            search(i-1,j,matrix,visited,a,b);
        if(i+1<a&&visited[i+1][j]==0&&matrix[i+1][j]==1)
            search(i+1,j,matrix,visited,a,b);
        if(j+1<b&&visited[i][j+1]==0&&matrix[i][j+1]==1)
            search(i,j+1,matrix,visited,a,b);
        if(j-1>=0&&visited[i][j-1]==0&&matrix[i][j-1]==1)
            search(i,j-1,matrix,visited,a,b);
    }



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int a = scanner.nextInt();
        int b = scanner.nextInt();

        int[][] matrix = new int[a][b];
        int[][] visited = new int[a][b];
        int count = 0 ;

        for(int i = 0 ; i<a;i++){
            for (int j = 0 ; j <b ; j++){
                matrix[i][j] = scanner.nextInt();
                visited[i][j] = 0;
            }
        }

        for(int i = 0 ; i < a ; i++){
            for(int j = 0 ; j < b ; j++){
                if(visited[i][j]==0&&matrix[i][j]==1){
                    search(i,j,matrix,visited,a,b);
                    if (c>max)
                        max = c;
                    c = 0;
                    count++;
                }
            }
        }
        sb.append(count+"\n"+max);
        System.out.println(sb);


    }

}