import java.util.*;

class Solution {
    public int solution(int N, int number) {
        List<HashSet<Integer>> list=  new ArrayList<HashSet<Integer>>();
        
        if (number == N) return 1;
        
        for (int i = 0; i < 9; i++) {
            list.add(new HashSet<Integer>());
        }
        
        list.get(1).add(N);
        
        for (int i = 2; i < 9; i++) {
            HashSet<Integer> nums = list.get(i);
            
            for (int j = 1; j < i; j++) {
                HashSet<Integer> a = list.get(j);
                HashSet<Integer> b = list.get(i - j);
                
                for (int numA : a) {
                    for (int numB : b) {
                        nums.add(numA + numB);
                        nums.add(numA - numB);
                        nums.add(numA * numB);
                        if (numA != 0 && numB != 0) nums.add(numA / numB);
                    }
                }
                
                nums.add(Integer.parseInt(String.valueOf(N).repeat(i)));
            }
        }
        
        for (int i = 2; i < 9; i++) {
            for (int num : list.get(i)) {
                if (num == number) return i;
            }
        }
        
        return -1;
    }
}
