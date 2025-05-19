import java.io.*;
import java.util.ArrayList;
import java.util.List;


class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        if(N==1){
            System.out.print(0);
            return;
        }
        boolean[] isPrime = new boolean[N+1];
        isPrime[0] = true;
        isPrime[1] = true;
        for(int i = 2 ; i * i <= N ; i++){
            if(!isPrime[i]){
                for(int j = i * i ;  j <= N ;j+=i){
                    isPrime[j] = true;
                }
            }
        }
        List<Integer> primes = new ArrayList<>();
        for(int i = 0 ; i < N + 1 ; i++){
            if(!isPrime[i]){
                primes.add(i);
            }
        }
        int start = 0;
        int end = 0;
        int sum = primes.get(start);
        int count = 0;
        while (start<primes.size()&&end<primes.size()){
            if(sum==N){
                count++;
                if(end<primes.size()-1){
                    end++;
                    sum+=primes.get(end);
                }
                else{
                    sum -= primes.get(start);
                    start++;
                }
            }
            else if(sum<N&&end<primes.size()){
                end++;
                if(end==primes.size()){
                    continue;
                }
                sum+=primes.get(end);
            }
            else if(sum>N&&start<primes.size()){
                sum -= primes.get(start);
                start++;
            }

        }
        System.out.print(count);
    }

}