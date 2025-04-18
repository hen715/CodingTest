import java.io.*;
import java.util.*;


class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);
        boolean[] lie = new boolean[M+1];
        s = br.readLine().split(" ");
        List<ArrayList<Integer>> party =new ArrayList<>();
        for(int i = 0 ; i <= M ; i++){
            party.add(new ArrayList<>());
        }
        Set<Integer> lier = new HashSet<>();
        if(s.length>1){
            for(int i = 1 ; i <s.length;i++){
                lier.add(Integer.parseInt(s[i]));
            }
        }

        for(int i = 0 ; i < M ; i++){
            s = br.readLine().split(" ");
            for(int j = 1 ; j < s.length ; j++){
                party.get(i+1).add(Integer.parseInt(s[j]));
            }
        }

        for(int i = 0 ; i < N ; i++){
            Set<Integer> temp = new HashSet<>();
            for(int l : lier){
                for(int j = 1 ; j < M +1 ; j++){
                    if(party.get(j).contains(l)){
                        temp.addAll(party.get(j));
                    }
                }
            }
            lier.addAll(temp);
        }

        for(int l : lier){
            for(int i = 1 ; i < M +1 ; i++){
                if(party.get(i).contains(l)){
                    lie[i] = true;
                }
            }
        }
        int count = 0;
        for(int i = 1 ; i < M +1 ; i++){
            if(!lie[i]){
                count++;
            }
        }
        System.out.print(count);
    }

}