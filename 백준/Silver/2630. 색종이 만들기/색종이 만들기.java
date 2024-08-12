import java.io.*;

class Main {
    static int blue = 0;
    static int white = 0;
    static int[][] list;

    public static void paper(int x1,int y1,int x2, int y2){
        int count = 0;
        int bCount = 0;
        int wCount = 0;
        for(int x = x1 ; x < x2 ; x++){
            for(int y = y1 ; y < y2 ; y++){
                if(list[x][y]==1){
                    bCount++;
                }
                else{
                    wCount++;
                }
                count++;
            }
        }
        if(bCount==count){
            blue++;
        }
        else if(wCount==count){
            white++;
        }
        else if(x2-x1!=1&&y2-y1!=1){
            paper(x1,y1,(x1+x2)/2,(y1+y2)/2);
            paper((x1+x2)/2,y1,x2,(y1+y2)/2);
            paper(x1,(y1+y2)/2,(x1+x2)/2,y2);
            paper((x1+x2)/2,(y1+y2)/2,x2,y2);
        }
    }



    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        list = new int[n][n];
        for(int i = 0 ; i < n ; i++){
            String[] s = br.readLine().split(" ");
            for(int j = 0 ; j < n ; j++){
                list[i][j] = Integer.parseInt(s[j]);
            }
        }
        paper(0,0,n,n);
        System.out.println(white+"\n"+blue);

    }
}