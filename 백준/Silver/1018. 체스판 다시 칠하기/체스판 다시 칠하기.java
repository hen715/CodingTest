import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int row = scanner.nextInt();
        int col = scanner.nextInt();
        char[][] board = new char[row][col];
        for(int i = 0 ; i < row ; i++) {
            String temp = scanner.next();
            for (int j = 0 ; j < col ; j++) {
                board[i][j] = temp.charAt(j);
            }
        }
        int count1 = 999;
        int count2 = 999;
        int end1 = row - 7;
        int end2 = col - 7;

        for(int i = 0; i <end1;i++){
            for(int j = 0 ; j<end2;j++){
                char color1 = board[i][j];
                char color2;
                if(color1=='B')
                    color2 ='W';
                else
                    color2='B';
                int c1 = 0;
                int c2 = 0;
                for(int k = i; k<i+8;k++){
                    for(int l = j ; l<j+8;l++){
                        if(board[k][l]!=color1){
                            c1++;
                        }
                        if(color1=='B')color1='W';
                        else
                            color1='B';

                        if(board[k][l]!=color2){
                            c2++;
                        }
                        if(color2=='B')color2='W';
                        else
                            color2='B';
                    }
                    if(color1=='B')color1='W';
                    else
                        color1='B';
                    if(color2=='B')color2='W';
                    else
                        color2='B';
                }
                if(c1<count1)
                    count1 = c1;
                if(c2<count2)
                    count2 = c2;
            }
        }





       if(count1<count2)
           System.out.println(count1);
       else
           System.out.println(count2);

    }
}