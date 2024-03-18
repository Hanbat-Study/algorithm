import java.io.*;
import java.util.*;
class Solution_캐시 {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        LinkedList<String> caches = new LinkedList<>();
        if (cacheSize == 0) {
            answer = cities.length * 5;
            return answer;
        }
        else {
            int cache = 0;
            for (String city : cities) {
                city = city.toLowerCase();
                if (caches.size() < cacheSize) {
                    if (caches.indexOf(city) != -1) {//존재
                        caches.remove(city);
                        caches.add(city);
                        answer += 1;
                    }
                    else {
                        caches.add(city);
                        answer += 5;
                    }
                }
                else {
                    if (caches.indexOf(city) != -1) {
                        caches.remove(city);
                        caches.add(city);
                        answer += 1;
                    }
                    else {
                        caches.remove(0);
                        caches.add(city);
                        answer += 5;
                    }
                }
            }
        }

        return answer;
    }
}