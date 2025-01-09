import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    static int N, start, end, result;
    static HashMap<Character, Integer> hm;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        start = 0;
        end = 0;
        result = 0;
        hm = new HashMap<>();
        String s = br.readLine();

        while (end < s.length()) {
            char endChar = s.charAt(end);

            hm.put(endChar, hm.getOrDefault(endChar, 0) + 1);

            while (N < hm.size()) {
                char startChar = s.charAt(start);

                hm.put(startChar, hm.get(startChar) - 1);

                if (hm.get(startChar) == 0) hm.remove(startChar);

                start++;
            }

            result = Math.max(result, end - start + 1);

            end++;
        }

        System.out.println(result);
    }
}
