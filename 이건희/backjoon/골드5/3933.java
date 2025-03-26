import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            int n = Integer.parseInt(br.readLine());

            if (n == 0) break;

            int result = 0;
            int sqrtN = (int) Math.sqrt(n);

            for (int a = 1; a <= sqrtN; a++) {
                if (a * a == n) {
                    result++;
                    
                    continue;
                }

                for (int b = a; b <= sqrtN; b++) {
                    if (a * a + b * b == n) {
                        result++;
                        
                        continue;
                    }

                    for (int c = b; c <= sqrtN; c++) {
                        if (a * a + b * b + c * c == n) {
                            result++;
                            
                            continue;
                        }

                        for (int d = c; d <= sqrtN; d++) {
                            if (a * a + b * b + c * c + d * d == n) {
                                result++;
                                
                                break;
                            }

                            if (a * a + b * b + c * c + d * d > n) {
                                break;
                            }
                        }
                    }
                }
            }

            System.out.println(result);
        }
    }
}
