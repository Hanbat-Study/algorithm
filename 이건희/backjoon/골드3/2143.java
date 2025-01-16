import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int T, n, m;
    static long sum1, sum2, result;
    static int[] arr1, arr2;
    static ArrayList<Long> list1, list2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        result = 0;
        n = Integer.parseInt(br.readLine());
        arr1 = new int[n];
        list1 = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }

        m = Integer.parseInt(br.readLine());
        arr2 = new int[m];
        list2 = new ArrayList<>();
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < m; i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            sum1 = 0;

            for (int j = i; j < n; j++) {
                sum1 += arr1[j];

                list1.add(sum1);
            }
        }

        for (int i = 0; i < m; i++) {
            sum2 = 0;

            for (int j = i; j < m; j++) {
                sum2 += arr2[j];

                list2.add(sum2);
            }
        }

        Collections.sort(list1);
        Collections.sort(list2);
        
        int l = 0;
        int r = list2.size() - 1;

        while (l < list1.size() && 0 <= r) {
            long sum = list1.get(l) + list2.get(r);

            if (sum == T) {
                long leftCnt = 0;
                long rightCnt = 0;
                long numA = list1.get(l);
                long numB = list2.get(r);

                while (l < list1.size() && list1.get(l) == numA) {
                    leftCnt++;
                    l++;
                }

                while (0 <= r && list2.get(r) == numB) {
                    rightCnt++;
                    r--;
                }

                result += leftCnt * rightCnt;
            } else if (sum < T) l++;
            else r--;
        }

        System.out.println(result);
    }
}
