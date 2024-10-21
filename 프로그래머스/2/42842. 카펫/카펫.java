class Solution {
    public int[] solution(int brown, int yellow) {
        int w = brown + yellow;
        int x=0;
        int y=0;
        for(int i = 1 ; i<= w; i++){
            if(w % i ==0){
                int j = w/i;
                if((i-2) * (j-2)==yellow){
                x = Math.max(i,j);
                y = Math.min(i,j);
                }
            }
        }
        int[] answer = {x,y};
        return answer;
    }
}