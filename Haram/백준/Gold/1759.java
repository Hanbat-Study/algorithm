import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int L, C;
    static String candis[];
    static boolean[] isSelected;

    static BufferedReader br;
    static StringBuilder sb;
    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();
        
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        candis = br.readLine().split(" ");
        
        Arrays.sort(candis, (a, b) -> a.charAt(0) - b.charAt(0));

        isSelected = new boolean[C];
        combinations(0, 0);
        
        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb.toString());
    }
    
    private static void combinations(int start, int cnt) {
        if(cnt == L) {
            String[] password = new String[L];
            int idx = 0; 
            for(int i = 0; i < C; i++) {
                if(isSelected[i]) password[idx++] = candis[i]; 
            }
            
            if(isAvailablePW(password)) {
                for(int i = 0; i < L; i++) {
                    sb.append(password[i]);
                }
                sb.append("\n");                
            }
            
            return;
        }
        
        for(int i = start; i < C; i++) {
            if(isSelected[i]) continue;
            isSelected[i] = true;
            combinations(i+1, cnt+1);
            isSelected[i] = false;
        }
    }

    private static boolean isAvailablePW(String[] pw) {
        int v = 0; // 모음
        int c = 0; // 자음
        for(int i = 0; i < pw.length; i++) {
            if("aeiou".contains(pw[i])) v++;
            else c++;
        }
        if(v >= 1 && c >= 2) return true;
        else return false;
    }
}