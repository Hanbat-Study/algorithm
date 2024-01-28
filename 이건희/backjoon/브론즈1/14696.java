import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String[] s1 = br.readLine().split(" ");
            String[] s2 = br.readLine().split(" ");
            int n1 = Integer.parseInt(s1[0]);
            int n2 = Integer.parseInt(s2[0]);
            int[] arr1 = new int[4];
            int[] arr2 = new int[4];
            char result = 'D';

            for (int j = 1; j < s1.length; j++) {
                int num = Integer.parseInt(s1[j]) - 1;
                arr1[num] += 1;
            }
            for (int j = 1; j < s2.length; j++) {
                int num = Integer.parseInt(s2[j]) - 1;
                arr2[num] += 1;
            }

            for (int j = 3; 0 <= j; j--) {
                if (arr1[j] > arr2[j]) {
                    result = 'A';
                    break;
                } else if (arr1[j] < arr2[j]) {
                    result = 'B';
                    break;
                }
            }
            System.out.println(result);
        }
    }
}
