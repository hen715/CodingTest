import java.util.*;

public class Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();
        List<Integer> list = new ArrayList<>();
        sb.append("<");
        for(int i = 1 ; i<=num1;i++)
            list.add(i);
        int pos = -1;
        while(true){
            pos += num2;
            if(list.size()==0)
                break;
            while(pos>=list.size())//list size = 7
                pos -= list.size();
            if(list.size()!=1)
                sb.append(list.get(pos)+", ");
            else if(list.size()==1)
                sb.append(list.get(pos));
            list.remove(pos);
            pos--;
        }

        sb.append(">");


        System.out.println(sb);
    }
}