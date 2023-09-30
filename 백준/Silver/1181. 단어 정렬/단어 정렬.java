import java.util.Arrays;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        scanner.nextLine();
        String[] list = new String[num];
        Arrays.fill(list, "0");
        int count = 0;
        for (int i = 0; i < num; i++) {
            boolean b = true;
            String a = scanner.nextLine();
            for (int j = 0; j < num; j++) {
                if (list[j].equals(a)) {
                    b = false;
                    count++;
                }
            }
            if (b)
                list[i] = a;
        }


//        for (int i = 0; i < num; i++) {
//            for (int j = 0; j < num - 1; j++) {
//                if (list[j].length() > list[j + 1].length()) {
//                    String temp = list[j];
//                    list[j] = list[j + 1];
//                    list[j + 1] = temp;
//                }
//            }
//        }
        Arrays.sort(list);
        Arrays.sort(list, (s1, s2) -> Integer.compare(s1.length(), s2.length()));
//        for (int i = 0; i < num; i++) {
//            for (int j = 0; j < num - 1; j++) {
//                if( list[j].length()==list[j+1].length()){
//                    int c = list[j].compareTo(list[j+1]);
//                    if(c>0){
//                        String temp = list[j];
//                        list[j] = list[j+1];
//                        list[j+1] = temp;
//                    }
//                }
//            }
//        }




        for(int i = count ; i< num;i++){
            System.out.println(list[i]);
        }
    }

}