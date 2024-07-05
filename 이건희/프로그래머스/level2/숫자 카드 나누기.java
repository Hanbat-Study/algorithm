import java.util.*;

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int numA = cal(commonDivisor(arrayA), arrayB);
        int numB = cal(commonDivisor(arrayB), arrayA);
        
        return Math.max(numA, numB);
    }
    
    private List<Integer> divisor(int number) {
        List<Integer> result = new ArrayList<>();
        
        for (int i = 1; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                result.add(i);
                
                if (i < number / i) result.add(number / i);
            }
        }
        
        Collections.sort(result);
        
        return result;
    }
    
    private List<Integer> commonDivisor(int[] array) {
        List<Integer> numList = new ArrayList<>();
        Arrays.sort(array);
        
        numList.addAll(divisor(array[0]));
        
        List<Integer> validDivisors = new ArrayList<>(numList);
        
        for (int num : numList) {
            for (int n : array) {
                if (n % num != 0) {
                    validDivisors.remove(Integer.valueOf(num));
                    break;
                }
            }
        }
        
        return validDivisors;
    }
    
    private int cal(List<Integer> numList, int[] array) {
        if (numList.isEmpty()) return 0;
        
        ArrayList<Integer> result = new ArrayList<>();
        result.add(0);
        
        for (int num : numList) {
            boolean check = false;
            
            for (int n : array) {
                if (n % num == 0) {
                    check = false;
                    break;
                }
                else check = true;
            }
            
            if (check) result.add(num);
        }
        
        return Collections.max(result);
    }
}
