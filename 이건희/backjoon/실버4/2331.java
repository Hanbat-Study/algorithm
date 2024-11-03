import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int A, P, result;
    static ArrayList<Integer> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        result = 0;
        list = new ArrayList<>();
        list.add(A);

        cal(A);

        System.out.println(result);
    }

    public static void cal(int n) {
        String num = String.valueOf(n);
        int sum = 0;

        for (int i = 0; i < num.length(); i++) {
            sum += (int) Math.pow(num.charAt(i) - '0', P);
        }

        if (list.contains(sum)) {
            result = list.indexOf(sum);
            return;
        }

        list.add(sum);
        cal(sum);
    }
}
