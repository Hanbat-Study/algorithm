import java.util.*;

class Solution {
    
    static List<Character> menuList;
    static Object[] menu;
    static List<String> candidates;
    static boolean[] isSelected;
    static String[] ordersCopy;
    static int max;
    public String[] solution(String[] orders, int[] course) {
        String[] answer = null;
        ordersCopy = orders;
        List<Character> menuList = new ArrayList<>();
        
        for(int i = 0; i < orders.length; i++) {
            for(int j = 0; j < orders[i].length(); j++) {
                if(!menuList.contains(orders[i].charAt(j)))
                    menuList.add(orders[i].charAt(j));
            }
        }
        
        menu = menuList.toArray();
        Arrays.sort(menu);
        
        List<String> tmp = new ArrayList<>();
        for(int n : course) {
            max = 0;
            isSelected = new boolean[menu.length];
            candidates = new ArrayList<>();
            combination(0, 0, n);
            tmp.addAll(candidates);
        }
        
        answer = new String[tmp.size()];
        for(int i = 0; i < tmp.size(); i++)
            answer[i] = tmp.get(i);
        
        Arrays.sort(answer);
        
        return answer;
    }
    
    public static void combination(int cnt, int idx, int n) {
        if(cnt == n) {
            int ordered = check();
            if(ordered < 2 || ordered < max)
                return;
            
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < isSelected.length; i++) {
                if(isSelected[i])
                    sb.append(menu[i]);
            }
            
            if(ordered > max) {
                max = ordered;
                candidates.clear();
                candidates.add(sb.toString());
            } else
                candidates.add(sb.toString());
        }
        
        for(int i = idx; i < menu.length; i++) {
            if(isSelected[i])
                continue;
            
            isSelected[i] = true;
            combination(cnt + 1, i + 1, n);
            isSelected[i] = false;
        }
    }
    
    public static int check() {
        int cnt = 0;
        for(int i = 0; i < ordersCopy.length; i++) {
            boolean flag = true;
            for(int j = 0; j < isSelected.length; j++) {
                if(!isSelected[j])
                    continue;
                
                char m = (char)menu[j];
                
                if(ordersCopy[i].indexOf(m) == -1) {
                    flag = false;
                    break;
                }
            }
            
            if(flag)
                cnt++;
        }
        
        return cnt;
    }
}
