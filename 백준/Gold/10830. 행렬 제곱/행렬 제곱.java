import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(s[0]);
        long B = Long.parseLong(s[1]);
        int[][] matrix = new int[N][N];
        if(B==1){
            for(int i = 0 ; i < N  ; i++){
                s = br.readLine().split(" ");
                for(int j = 0 ; j < N ; j++){
                    sb.append(Integer.parseInt(s[j])%1000).append(" ");
                }
                sb.append("\n");
            }
            System.out.println(sb);
            return;
        }
        for(int i = 0 ; i < N  ; i++){
            s = br.readLine().split(" ");
            for(int j = 0 ; j < N ; j++){
                matrix[i][j] = Integer.parseInt(s[j]);
            }
        }
        matrix = pow(matrix,B);
        for(int i = 0 ; i < N  ; i++){
            for(int j = 0 ; j < N ; j++){
                sb.append(matrix[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);

    }

    public static int[][] pow(int[][] matrix,long p){
        if(p==1){
            return matrix;
        }
        int[][] temp = pow(matrix,p/2);
        if(p%2==1){
            return mul(mul(temp,temp), matrix);
        }
        else{
            return  mul(temp,temp);
        }
    }

    public static int[][] mul(int[][] matrix1, int[][] matrix2){
        int[][] matrix = new int[matrix1.length][matrix1.length];
        for(int i = 0 ; i < matrix1.length  ; i++){
            for(int j = 0 ; j < matrix1.length ; j++){
                int sum = 0;
                for(int k = 0 ; k < matrix1.length ; k++ ){
                    sum += (matrix1[i][k] * matrix2[k][j]) % 1000;
                }
                matrix[i][j] = sum % 1000;
            }
        }
        return matrix;
    }
}