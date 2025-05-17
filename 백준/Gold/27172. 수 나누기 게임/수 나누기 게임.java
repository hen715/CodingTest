import java.io.*;


class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        String[] s = br.readLine().split(" ");
        int[] list = new int[N];
        int[] point = new int[N];
        int[] card = new int[1000001];
        for(int i = 0 ; i < N ; i++){
            list[i] = Integer.parseInt(s[i]);
            card[list[i]] = i + 1;
        }
        for(int i = 0 ; i < N ; i++){
            for(int j = list[i] * 2 ; j < 1000001 ; j += list[i]){
                if(card[j]>0){
                    point[i]++;
                    point[card[j]-1]--;
                }
            }
        }
        for(int i = 0 ; i < N ; i++){
            sb.append(point[i]).append(' ');
        }
        System.out.print(sb);
    }
}