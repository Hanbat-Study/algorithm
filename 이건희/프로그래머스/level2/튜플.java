import java.util.*;

class Solution {
    public int[] solution(String s) {
        s = s.substring(1, s.length() - 1);
        
        String[] arr = s.split("},\\{");
        
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.compare(o1.length(), o2.length());
            }
        });
        
        List<Integer> resultList = new ArrayList<>();
        Set<Integer> added = new HashSet<>();
        
        for(String str : arr) {
            String[] nums = str.replace("{", "").replace("}", "").split(",");
            for(String numStr : nums) {
                int num = Integer.parseInt(numStr);
                if (added.add(num)) {
                    resultList.add(num);
                }
            }
        }
        
        int[] result = new int[resultList.size()];
        for(int i = 0; i < resultList.size(); i++) {
            result[i] = resultList.get(i);
        }
        
        return result;
    }
}
