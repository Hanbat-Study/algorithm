import java.util.*;
import java.io.*;
class Solution_마법의_엘레베이터 {
    public int solution(int storey) {
        int answer = 0;

        while(storey > 0) {
            int remain = storey % 10 ;
            if (remain < 5) {
                storey -= remain;
            }
            else if (remain > 5){
                remain = 10 - remain;
                storey += remain;

            }
            else {
                if ((storey / 10)%10 >=5) {
                    remain = 10 - remain;
                    storey += remain;
                }
                else {
                    storey -= remain;
                }
            }
            answer += remain;
            storey /= 10;
        }
        return answer;
    }
}