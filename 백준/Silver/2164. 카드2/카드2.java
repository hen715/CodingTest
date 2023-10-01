import java.util.*;

public class Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        Queue<Integer> card = new LinkedList<>();
        for (int i = 0; i < num; i++) {
            card.add(i + 1);
        }
        if (num == 1) {
            System.out.println("1");
        } else {
            while (card.size() > 1) {
                card.poll();
                if (card.size() > 1) {
                    int temp = card.poll();
                    card.add(temp);


                }
            }
            System.out.println(card.peek());


//        int[] card = new int[num];
//        for(int i = 0;i<num;i++){
//            card[i] = i+1;
//        }
//        if(num==1){
//            System.out.println("1");
//        }
//        else {
//            while (card[1] != 0) {
//                for (int i = 1; i < num; i++) {
//                    card[i - 1] = card[i];
//                }
//                card[num - 1] = 0;
//                num--;
//                int temp = card[0];
//                for (int i = 1; i < num; i++) {
//                    card[i - 1] = card[i];
//                }
//                card[num - 1] = temp;
//
//            }
//            System.out.println(card[0]);
//
//        }

        }

    }
}