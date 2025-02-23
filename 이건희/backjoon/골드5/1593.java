import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static int g, sLen, result;
    static String W, S;
    static HashMap<Character, Integer> map, comMap;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        g = Integer.parseInt(st.nextToken());
        sLen = Integer.parseInt(st.nextToken());
        result = 0;
        W = br.readLine();
        S = br.readLine();
        map = new HashMap<>();
        comMap = new HashMap<>();

        for (int i = 0; i < g; i++) {
            map.put(W.charAt(i), map.getOrDefault(W.charAt(i), 0) + 1);
            comMap.put(S.charAt(i), comMap.getOrDefault(S.charAt(i), 0) + 1);
        }

        if (map.equals(comMap)) result++;

        for (int i = g; i < sLen; i++) {
            char newChar = S.charAt(i);
            char oldChar = S.charAt(i - g);

            comMap.put(newChar, comMap.getOrDefault(newChar, 0) + 1);
            comMap.put(oldChar, comMap.get(oldChar) - 1);

            if (comMap.get(oldChar) == 0) {
                comMap.remove(oldChar);
            }

            if (map.equals(comMap)) result++;
        }


        System.out.println(result);
    }
}
