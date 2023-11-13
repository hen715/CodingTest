import java.util.Scanner;

public class Main {

    public static int Z(double num,int r, int c,int sum){
        
        double n=num-1;
        if(r==0&&c==0)
            return sum;
        else if(r==0&&c==1)
            return sum+1;
        else if(r==0&&c==1)
            return  sum+2;
        else if(r==1&&c==1)
            return sum+3;
        if(r<n/2&&c<n/2){
              return Z(num/2,r,c,sum+((int)(num/2)*(int)(num/2))*0);
        }
        if(r<n/2&&c>n/2){
             return Z(num/2,r,c-(int)num/2,sum+((int)(num/2)*(int)(num/2))*1);
        }
        if(r>n/2&&c<n/2){
             return Z(num/2,r-(int)num/2,c,sum+((int)(num/2)*(int)(num/2))*2);
            }
         if(r>n/2&&c>n/2){
            return Z(num/2,r-(int)num/2,c-(int)num/2,sum+((int)(num/2)*(int)(num/2))*3);
      }
         return sum;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int r = scanner.nextInt();
        int c = scanner.nextInt();

        double num = Math.pow(2,n);

        System.out.print(Z(num,r,c,0));
    }


}