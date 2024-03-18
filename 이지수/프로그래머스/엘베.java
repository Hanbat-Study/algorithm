class Solution {

    public int solution(int storey) {    
        int answer = 0;
        
        while(storey > 0) {
            int last = storey % 10;
            storey /= 10;
            
            if(last > 5) {
                answer += (10 - last);
                storey++;
            }
            else if(last == 5) {
                if(storey % 10 < 5) {
                    answer += last;
                } 
                else {
                    answer += (10 - last);
                    storey++;
                }
            }
            else
                answer += last;
        }
        
        return answer;
    }
}
