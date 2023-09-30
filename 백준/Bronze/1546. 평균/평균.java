import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        float[] score = new float[num];
        for(int i = 0 ; i<num ; i++){
            score[i] = scanner.nextFloat();
        }
        float max = -1;
        float maxPos = 0;
        for(int i = 0 ; i<num ; i++){
            if(score[i] > max) {
                maxPos = i;
                max = score[i];
            }
        }
        float sum = 0;
        for(int i = 0 ; i<num ; i++){
                score[i] =score[i]/max*100;
            sum +=score[i];
        }
        float avr = sum/num;
        System.out.println(avr);

    }


}