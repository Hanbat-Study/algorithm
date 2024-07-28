import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        
        TreeMap<Integer, Boolean> map = new TreeMap<>();
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((o1,o2)->o1-o2);
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1,o2)->o2-o1);
        
        for(String operation : operations){
            StringTokenizer st = new StringTokenizer(operation);
            if('I'==st.nextToken().charAt(0)){
                Integer num =Integer.parseInt(st.nextToken());
                minHeap.add(num);
                maxHeap.add(num);
                map.put(num,true);
            }
            else{   // 삭제
                String num =st.nextToken();
                if('-'==num.charAt(0)){ //최솟값 삭제                  
                    while(minHeap.size()>0){
                        Integer temp=minHeap.poll();
                        if(map.get(temp)){
                            map.replace(temp, false);
                            break;
                        }
                    
                    } 
                }
                else{   // 최대값 삭제
                    while(maxHeap.size()>0){
                        Integer temp=maxHeap.poll();
                        if(map.get(temp)){
                            map.replace(temp, false);
                            break;
                        }
                    
                    } 
                }
            }
        }
        
        while(maxHeap.size()>0){
            Integer temp=maxHeap.poll();
            if(map.get(temp)){
                answer[0]=temp;
                break;
            }       
        } 
        
        while(minHeap.size()>0){
            Integer temp=minHeap.poll();
            if(map.get(temp)){
                answer[1]=temp;
                break;
            }
                    
        } 
        
        return answer;
    }
}
