import java.util.Scanner;

public class Main {

    public static class printStr{
        private int num;
        private String str;

        public void print(){
            for(int i = 0 ; i<str.length() ;i++){
                for(int j = 0 ; j < num; j++){
                    System.out.print(str.charAt(i));
                }
            }
            System.out.println();
        }

        public String getStr() {
            return str;
        }

        public void setStr(String str) {
            this.str = str;
        }

        public int getNum() {
            return num;
        }

        public void setNum(int num) {
            this.num = num;
        }
    }
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        scanner.nextLine();
        printStr[] prt = new printStr[a];
        for (int i = 0; i < a; i++) {
            prt[i] = new printStr();
            int num = scanner.nextInt();
            String str = scanner.next();
            prt[i].setNum(num);
            prt[i].setStr(str);
        }
        for (int i = 0; i < a; i++) {
            prt[i].print();

        }
    }
}