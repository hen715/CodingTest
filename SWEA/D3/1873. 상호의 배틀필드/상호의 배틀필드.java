import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    static int N;
    static int M;
    static char[][] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int t = 1 ; t <= T ; t++) {
            String[] s = br.readLine().split(" ");
            N = Integer.parseInt(s[0]);
            M = Integer.parseInt(s[1]);
            list = new char[N][M];
            String str;
            int x = 0;
            int y = 0;
            for(int i = 0 ; i < N ; i++){
                str = br.readLine();
                for(int j = 0 ; j < M ; j++){
                    list[i][j] = str.charAt(j);
                    if(list[i][j]=='<'||list[i][j]=='>'||list[i][j]=='^'||list[i][j]=='v'){
                        x = i;
                        y = j;
                    }
                }
            }
            int c = Integer.parseInt(br.readLine());
            str = br.readLine();
            for(int i = 0 ; i < c ; i++){
                if(str.charAt(i)=='U'){
                    if(x-1>=0&&list[x-1][y]=='.'){
                        list[x][y] = '.';
                        list[x-1][y] = '^';
                        x = x-1;
                    }
                    else{
                        list[x][y] = '^';
                    }
                }
                else if(str.charAt(i)=='D'){
                    if(x+1<N&&list[x+1][y]=='.'){
                        list[x][y] = '.';
                        list[x+1][y] = 'v';
                        x = x + 1;
                    }
                    else{
                        list[x][y] = 'v';
                    }
                }
                else if(str.charAt(i)=='R'){
                    if(y+1<M&&list[x][y+1]=='.'){
                        list[x][y] = '.';
                        list[x][y+1] = '>';
                        y = y + 1;
                    }
                    else{
                        list[x][y] = '>';
                    }
                }
                else if(str.charAt(i)=='L'){
                    if(y-1>=0&&list[x][y-1]=='.'){
                        list[x][y] = '.';
                        list[x][y-1] = '<';
                        y = y - 1;
                    }
                    else{
                        list[x][y] = '<';
                    }
                }
                else if(str.charAt(i)=='S'){
                    if(list[x][y]=='>'){
                        int yy = y + 1;
                        while (yy<M){
                            if(list[x][yy]=='#'){
                                break;
                            }
                            if(list[x][yy]=='*'){
                                list[x][yy] ='.';
                                break;
                            }
                            yy++;
                        }
                    }
                    else if(list[x][y]=='<'){
                        int yy = y-1;
                        while (yy>=0){
                            if(list[x][yy]=='#'){
                                break;
                            }
                            if(list[x][yy]=='*'){
                                list[x][yy] ='.';
                                break;
                            }
                            yy--;
                        }
                    }
                    else if(list[x][y]=='^'){
                        int xx = x-1;
                        while (xx>=0){
                            if(list[xx][y]=='#'){
                                break;
                            }
                            if(list[xx][y]=='*'){
                                list[xx][y] ='.';
                                break;
                            }
                            xx--;
                        }
                    }
                    else if(list[x][y]=='v'){
                        int xx = x+1;
                        while (xx<N){
                            if(list[xx][y]=='#'){
                                break;
                            }
                            if(list[xx][y]=='*'){
                                list[xx][y] ='.';
                                break;
                            }
                            xx++;
                        }
                    }
                }
            }


            sb.append('#').append(t).append(' ');
            for(int i = 0 ; i < N ; i++){
                for(int j = 0 ; j < M ; j++){
                    sb.append(list[i][j]);
                }
                sb.append('\n');
            }

        }
        System.out.print(sb);
    }



}