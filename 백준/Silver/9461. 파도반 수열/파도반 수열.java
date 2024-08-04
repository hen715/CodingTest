import java.io.*;


class Main {


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] wave = new long[101];
        wave[1] = 1;
        wave[2] = 1;
        wave[3] = 1;
        for(int i = 4 ; i < 101; i++){
            wave[i] = wave[i-2] + wave[i-3];
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < n ; i++){
            sb.append(wave[Integer.parseInt(br.readLine())]+"\n");
        }

        System.out.println(sb);
    }

}