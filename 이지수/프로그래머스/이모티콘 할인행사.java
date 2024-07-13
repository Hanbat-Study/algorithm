class Solution {
    
    static int[] selected, answer;
    public int[] solution(int[][] users, int[] emoticons) {        
        selected = new int[emoticons.length];
        answer = new int[] {0, 0};
            
        comb(0, emoticons.length, users, emoticons);
        
        return answer;
    }
    
    public void comb(int cnt, int m, int[][] users, int[] emoticons) {
        if(cnt == m) {
            cal(users, emoticons);
            return;
        }
        
        for(int i = 0; i < 4; i++) {
            selected[cnt] = (i + 1) * 10;
            comb(cnt + 1, m, users, emoticons);
        }
    }
    
    public void cal(int[][] users, int[] emoticons) {
        int cnt = 0;
        int costs = 0;
        
        for(int i = 0; i < users.length; i++) {
            int prices = 0;
            for(int j = 0; j < emoticons.length; j++) {
                if(selected[j] >= users[i][0])
                    prices += (emoticons[j] * (100 - selected[j]) / 100);
            }
            
            if(prices >= users[i][1])
                cnt++;
            else
                costs += prices;
        }
        
        if(answer[0] < cnt) {
            answer[0] = cnt;
            answer[1] = costs;
        } else if(answer[0] == cnt) {
            answer[1] = Math.max(costs, answer[1]);
        }
        
        return;
    }
}
