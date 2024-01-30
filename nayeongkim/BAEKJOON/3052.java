import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

class Main_3052 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<Integer> set = new HashSet<>();
        int cnt = 0;
        for (int i = 0; i < 10; i++) {
            int N = Integer.parseInt(br.readLine());
            N = N % 42;
            set.add(N);

        }

        System.out.println(set.size());
    }
}