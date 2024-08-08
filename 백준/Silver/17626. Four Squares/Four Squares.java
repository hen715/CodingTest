import java.io.*;


class Main {


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[50001];
        for(int i = 1 ; i < 224 ; i++){
            nums[i*i] = 1;
        }
       for(int a = 0 ; a < 3 ; a++){
           for(int i = 1 ; i < 50001 ; i++){
               for(int j = 1 ; j < 224 ; j++) {
                   if (i + j * j < 50001) {
                       if(nums[i+j*j]==0){
                           nums[i + j * j] = nums[i] + 1;
                       }
                       else if(nums[i+j*j] > nums[i]+1) {
                           nums[i + j * j] = nums[i] + 1;
                       }
                   }
               }
           }
       }
        System.out.println(nums[n]);
    }
}