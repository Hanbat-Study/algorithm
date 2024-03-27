import java.util.*;
import java.lang.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        long total=0;
        long cnt=0;
        int answer = -1;
        
        
        long [] arr= new long[queue1.length*2];
        for(int i=0;i<queue1.length;i++){
            arr[i] = queue1[i];
            arr[i+queue1.length]=queue2[i];
            
            cnt+=queue1[i];
            total+=queue1[i]+queue2[i];
        }
        
        int left=0;
        int right=queue1.length;
        total/=2;
        int k=0;
        
        while(right<arr.length && left<=right){
            if(total==cnt){
                answer=k;
                break;
            }
            if(total>cnt){
                cnt+=arr[right];
                right+=1;
            }
            else if(total<cnt){
                cnt-=arr[left];
                left+=1;
            }
            k++;
        } 

        return answer;
    }
}
