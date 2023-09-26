import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int hotel = scanner.nextInt();
        String[] room = new String[hotel];
        for(int i = 0 ; i<hotel;i++){
            int h = scanner.nextInt();
            int w = scanner.nextInt();
            int n = scanner.nextInt();
            int roomH = n % h;
            int roomW = (n / h) +1 ;
            if(roomH ==0){
                roomH = h;
                roomW -= 1;
            }
            String rH = String.valueOf(roomH);
            String rW = "0";
            if(roomW<10)
                rW = rW + String.valueOf(roomW);
            else
                rW = String.valueOf(roomW);
            String roomNum = rH+rW;
            room[i] = roomNum;
        }
        for(int i = 0 ; i < hotel;i++){
            System.out.println(room[i]);
        }

    }
}