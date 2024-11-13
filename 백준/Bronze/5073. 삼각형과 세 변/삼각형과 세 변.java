import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] s = br.readLine().split(" ");
        int x = Integer.parseInt(s[0]);
        int y = Integer.parseInt(s[1]);
        int z = Integer.parseInt(s[2]);
        while (x!=0&&y!=0&&z!=0){
            int same = 0;
            if(x==y){
                same++;
            }
            if(y==z){
                same++;
            }
            if(x==z){
                same++;
            }

            if(same==3){
                sb.append("Equilateral\n");
            }
            else if(same==1){
                if(x==y){
                    if(z>=x+y){
                        sb.append("Invalid\n");
                    }
                    else {
                        sb.append("Isosceles\n");
                    }
                }
                else if(y==z){
                    if(x>=y+z){
                        sb.append("Invalid\n");
                    }
                    else {
                        sb.append("Isosceles\n");
                    }
                }
                else if(x==z){
                    if(y>=x+z){
                        sb.append("Invalid\n");
                    }
                    else {
                        sb.append("Isosceles\n");
                    }
                }

            }
            else{
                int max = Math.max(x,y);
                max = Math.max(max,z);
                int sum = 0;
                if(max!=x){
                    sum +=x;
                }
                if(max!=y){
                    sum +=y;
                }
                if(max!=z){
                    sum +=z;
                }
                if(sum<=max){
                    sb.append("Invalid\n");
                }
                else {
                    sb.append("Scalene\n");
                }
            }
            s = br.readLine().split(" ");
            x = Integer.parseInt(s[0]);
            y = Integer.parseInt(s[1]);
            z = Integer.parseInt(s[2]);

        }
        System.out.println(sb);


    }


}