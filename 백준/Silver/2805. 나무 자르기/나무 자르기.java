import java.io.*;



public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        int[] tree = new int[n];
        s = br.readLine().split(" ");
        int end = Integer.parseInt(s[0]);
        for (int i = 0 ; i < n ; i++){
            int temp = Integer.parseInt(s[i]);
            tree[i] = temp;
            if (temp>end){
                end = temp;
            }
        }
        int start = 1;
        int mid = (start+end)/2;
        while(start<=end){

            long cut = 0;
            for(int i = 0 ; i < n ; i++){
                if(tree[i] - mid > 0){
                    cut += tree[i] - mid;
                }
            }
            if(cut<m){
                end = mid-1;
            }
            else if (cut>m){
                start = mid+1;
            }
            else {
                mid = (start+end)/2;
                break;
            }
            mid = (start+end)/2;
        }
        System.out.println(mid);



    }
}