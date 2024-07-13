import java.util.*;

class Solution {
    
    static boolean[] isSelected;
    static int[] infoCopy, answer, sets;
    static int abs;
    public int[] solution(int n, int[] info) {
        answer = null;
        infoCopy = info;
        isSelected = new boolean[11];
        
        for(int j = 1; j <= n; j++)
            comb(0, j, n);
        
        if(answer == null)
            return new int[] {-1};
        
        return answer;
    }
    
    public void comb(int cnt, int max, int n) {
        if(cnt == max) {
            sets = new int[max];
            set(n, 0, max);
            
            return;
        }
        for(int i = cnt; i < 11; i++) {
            if(isSelected[i]) continue;
            
            isSelected[i] = true;
            comb(cnt + 1, max, n);
            isSelected[i] = false;
        }
    }
    
    public void set(int n, int cnt, int max) {        
        if(cnt == max - 1) {
            sets[cnt] = n;
            cal();
            return;
        }
        int i = 1;
        while(i <= n - (max - cnt - 1)) {
            sets[cnt] = i;
            set(n - i, cnt + 1, max);
            i++;
        }
    }
    
    public void cal() {
        int Rscore = 0;
        int Ascore = 0;
        int idx = 0;
        int[] tmp = new int[11];
        for(int i = 0; i < 11; i++) {
            if(!isSelected[i]) {
                if(infoCopy[i] > 0)
                    Ascore += (10 - i);
                continue;
            }
            
            tmp[i] = sets[idx];
            if(sets[idx++] > infoCopy[i])
                Rscore += (10 - i);
            else
                Ascore += (10 - i);
        }
        
        if(Rscore <= Ascore) return;
        
        if(answer == null || abs < Rscore - Ascore) {
            answer = tmp;
            abs = Rscore - Ascore;
            return;
        }
        
        if(abs > Rscore - Ascore) return;
        
        for(int i = 10; i >= 0; i--) {
            if(answer[i] > tmp[i]) return;
            
            if(answer[i] < tmp[i]) {
                answer = tmp;
                return;
            }
        }
        
        return;
    }
}
