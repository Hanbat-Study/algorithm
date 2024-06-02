import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] people, int limit) {
        int result = 0;
        int i = 0;
        int j = people.length - 1;
        
        Arrays.sort(people);
        
        while (i < j) {
            if (people[i] + people[j] <= limit) {
                i++;
                j--;
            } else j--;
        }
        
        
        return people.length - i;
    }
}
