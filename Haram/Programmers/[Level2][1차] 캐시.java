// 2018 KAKAO BLIND RECRUITMENT
import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        
        // cache miss 일 경우 실행 시간이 5이므로
        if(cacheSize == 0)
            return cities.length * 5;
    
        // 캐시를 담는 큐
        Deque<String> que = new LinkedList<>();

        for (String city : cities) {
            String cityName = city.toLowerCase();

            // 캐시에 도시 이름이 있으면 hit
            if(!que.isEmpty() && que.contains(cityName)) {
                que.remove(cityName);
                que.add(cityName);
                answer += 1;
            }
            // 없으면 miss
            else {
                // FIFO
                if(que.size() == cacheSize)
                    que.poll();
                que.add(cityName);
                answer += 5;
            }
        }

        return answer;
    }
}
