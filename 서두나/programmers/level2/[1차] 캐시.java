import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        List<String> cache = new ArrayList<>();
        
        if(cacheSize==0){
            return cities.length*5;
        }
        
        for(String city : cities){
            boolean flag=true;
            for(int j=0;j<cache.size();j++){
                if(city.toLowerCase().equals(cache.get(j).toLowerCase())){
                    cache.remove(j);
                    cache.add(city);
                    answer+=1;
                    flag=false;
                    break;
                }
            }
            if(flag){
                if(cacheSize==cache.size()){
                    cache.remove(0);
                }
                cache.add(city);
                answer+=5;
            }
            
        }
        return answer;
    }
}
