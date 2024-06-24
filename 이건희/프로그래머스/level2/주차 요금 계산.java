import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        HashMap<Integer, Integer> parking = new HashMap<>();
        HashMap<Integer, Integer> cal = new HashMap<>();
        
        for (String record : records) {
            String[] parts = record.split(" ");
            String[] times = parts[0].split(":");
            
            int h = Integer.parseInt(times[0]);
            int m = Integer.parseInt(times[1]);
            int time = h * 60 + m;
            int num = Integer.parseInt(parts[1]);
            String type = parts[2];
            
            if (type.equals("IN")) {
                parking.put(num, time);
            } else {
                int sum = time - parking.get(num);
                cal.put(num, cal.getOrDefault(num, 0) + sum);
                parking.remove(num);
            }
        }
        
        for (Integer value : parking.keySet()) {
            cal.put(value, cal.getOrDefault(value, 0) + 1439 - parking.get(value));
        }
        
        TreeMap<Integer, Integer> sortedCal = new TreeMap<>(cal);
        int[] result = new int[sortedCal.size()];
        int index = 0;
        
        for (Map.Entry<Integer, Integer> entry : sortedCal.entrySet()) {
            int num = entry.getValue();
            
            if (num <= fees[0]) {
                result[index] = fees[1];
            } else {
                result[index] = fees[1] + (int) Math.ceil((double) (num - fees[0]) / fees[2]) * fees[3];
            }
            
            index++;
        }
        
        return result;
    }
}
