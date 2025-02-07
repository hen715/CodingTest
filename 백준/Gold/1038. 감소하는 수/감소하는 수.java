import java.io.*;
import java.util.*;

class Main {
    static int N;
    static int count = 0;
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        if(N>1022){
            System.out.println(-1);
            return;
        }
        else if(N==1022){
            System.out.println("9876543210");
            return;
        }
        list = new ArrayList<>();
        list.add(0);
        backTracking(0,9);
        Collections.sort(list);
        if (N >= list.size()) {
            System.out.println(-1);
        } else {
            System.out.println(list.get(N));
        }
    }

    public static void backTracking(int num, int lastNum) {
        if(num!=0) {
            list.add(num);
        }
        for(int i = lastNum ; i >= 0 ; i--){
            backTracking(num *  10 + i, i - 1);
        }

    }

}