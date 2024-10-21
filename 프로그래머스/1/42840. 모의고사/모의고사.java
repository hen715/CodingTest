import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] a = {1,2,3,4,5};
        int[] b = {2,1,2,3,2,4,2,5};
        int[] c = {3,3,1,1,2,2,4,4,5,5};
        int aCount = 0;
        int bCount = 0;
        int cCount = 0;
        for(int i = 0 ; i < answers.length ; i++){
            if(answers[i]==a[i%a.length]){
                aCount++;
            }
            if(answers[i]==b[i%b.length]){
                bCount++;
            }
            if(answers[i]==c[i%c.length]){
                cCount++;
            }
        }
        int max = Math.max(aCount,bCount);
        max = Math.max(max,cCount);
        List<Integer> answer = new ArrayList();
        if(max==aCount)
            answer.add(1);
        if(max==bCount)
            answer.add(2);
        if(max==cCount)
            answer.add(3);
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}