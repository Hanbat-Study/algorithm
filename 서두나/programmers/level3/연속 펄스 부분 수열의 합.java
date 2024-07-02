import java.util.*;

class Solution {
    public long solution(int[] sequence) {
        long answer = -50_000_000_000l;
        
        long [][] cal = new long[2][sequence.length];
        
        cal[0][0]=sequence[0];
        cal[1][0]=sequence[0]*-1;
        
        for(int i=1;i<sequence.length;i++){
            if(sequence[i]<cal[1][i-1]+sequence[i]){    // +
                cal[0][i]=cal[1][i-1]+sequence[i];
            }else{
                cal[0][i]=sequence[i];
            }
            
            if((sequence[i]*-1)<cal[0][i-1]+(sequence[i]*-1)){    // -
                cal[1][i]=cal[0][i-1]+(sequence[i]*-1);
            }else{
                cal[1][i]=sequence[i]*-1;
            }
        }
        
        for(int i=0;i<sequence.length;i++){
            for(int j=0; j<2;j++){
                answer=Math.max(answer,cal[j][i]);        
            }
        }
        
        return answer;
    }
}

// 자기 자신 계산, 이전 계산 비교
