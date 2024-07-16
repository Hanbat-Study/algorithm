import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        // 크기별 귤의 개수를 카운트하는 맵
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int size : tangerine) {
            countMap.put(size, countMap.getOrDefault(size, 0) + 1);
        }

        // 크기별 귤의 개수를 리스트로 변환하여 내림차순 정렬
        List<Integer> counts = new ArrayList<>(countMap.values());
        counts.sort(Collections.reverseOrder());

        // 상자에 담을 귤의 종류 수를 최소화하기 위해 최대한 동일한 크기의 귤을 많이 선택
        int kindCount = 0;
        int selectedCount = 0;
        for (int count : counts) {
            selectedCount += count;
            kindCount++;
            if (selectedCount >= k) {
                break;
            }
        }

        return kindCount;
    }
}
