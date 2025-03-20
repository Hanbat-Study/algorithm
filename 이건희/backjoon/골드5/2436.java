import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int GCD, LCM, A, B;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        GCD = Integer.parseInt(st.nextToken());
        LCM = Integer.parseInt(st.nextToken());
        A = 0;
        B = 0;

        int num = LCM / GCD;
        int minSum = Integer.MAX_VALUE;

        for (int i = 1; i * i <= num; i++) {
            if (num % i == 0) {
                int j = num / i;

                if (gcd(i, j) == 1) {
                    int num1 = i * GCD;
                    int num2 = j * GCD;

                    if (num1 + num2 < minSum) {
                        minSum = num1 + num2;
                        A = num1;
                        B = num2;
                    }
                }
            }
        }

        System.out.println(A + " " + B);
    }

    static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }
}
