import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] arr1, arr2;
    static ArrayList<Integer> result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr1 = new int[N];
        result = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }

        M = Integer.parseInt(br.readLine());
        arr2 = new int[M];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < M; i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
        }

        int idxA = 0;
        int idxB = 0;

        while (idxA < N && idxB < M) {
            int maxNum = 0;

            for (int i = idxA; i < N; i++) {
                for (int j = idxB; j < M; j++) {
                    if (arr1[i] == arr2[j]) maxNum = Math.max(maxNum, arr1[i]);
                }
            }

            if (0 < maxNum) {
                result.add(maxNum);

                while (maxNum != arr1[idxA]) idxA++;
                while (maxNum != arr2[idxB]) idxB++;

                idxA++;
                idxB++;
            } else break;
        }

        StringBuilder sb = new StringBuilder();

        for (Integer i : result) {
            sb.append(i).append(" ");
        }

        System.out.println(result.size());
        System.out.println(sb);
    }
}
