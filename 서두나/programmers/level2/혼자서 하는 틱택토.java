// o>=x, o가 연속 3개 x-1, x가 연속 3개 o
import java.util.*;
import java.lang.*;

class Solution {
    public int solution(String[] board) {
        int answer = -1;
        int o = 0;
        int x = 0;
        
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(board[i].charAt(j)=='O'){
                    o++;
                }else if(board[i].charAt(j)=='X'){
                    x++;
                }
            }
        }
        
        if(!(o-1 == x || o == x)){
            return 0;
        }
        
        if(o>=x){
            int oCnt = check('O', board);
            int xCnt = check('X', board);
            
            if(o>=3){
                if(oCnt==0 && xCnt==0){
                    return 1;
                }
                else if(o-1==x && oCnt > xCnt){ // 무조건 1개만 승리가 아닌 개 이상으로도 승리 가능한 경우를 고려해야한다.
                    return 1;
                }
                else if(o==x && oCnt< xCnt){
                    return 1;
                }
                return 0;
            }
            else{
                return 1;
            }
        }
        
        return 0;
    }

    int check(char c, String[] board){
        int cnt=0;
        int k=0;
        // 가로 
        for(int i=0;i<3;i++){
            k=0;
            for(int j=0;j<3;j++){
                if(board[i].charAt(j)==c){
                    k++;
                }
            }
            if(k==3){
                cnt++;
            }
        }
        
        // 세로
        for(int j=0;j<3;j++){
            k=0;
            for(int i=0;i<3;i++){
                if(board[i].charAt(j)==c){
                    k++;
                }
            }
            if(k==3){
                cnt++;
            }
        }
        
        k=0;
        for(int i=0;i<3;i++){
            if(board[i].charAt(i)==c){
                k++;
            }
        }
        if(k==3){
            cnt++;
        }
        
        k=0;
        for(int i=0;i<3;i++){
            if(board[i].charAt(2-i)==c){
                k++;
            }
        }
        if(k==3){
            cnt++;
        }
            
        return cnt;
    }
}
