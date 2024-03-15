import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int[] a = new int[n];
        Integer[] b = new Integer[n];
        String[] s = bf.readLine().split(" ");
        for(int i = 0 ; i<n ; i++){
            a[i] = Integer.parseInt(s[i]);
        }
        s = bf.readLine().split(" ");
        for(int i = 0 ; i<n ; i++){
            b[i] = Integer.parseInt(s[i]);
        }
        Arrays.sort(a);
        Arrays.sort(b);
        List<Integer> list = Arrays.asList(b);
        Collections.reverse(list);
        int num = 0;
        for(int i = 0 ; i <n; i++){
            num += a[i] * list.get(i);
        }
        System.out.println(num);

    }
}