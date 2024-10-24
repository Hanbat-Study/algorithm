import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Map<String, int[]> information = new HashMap<>();

        for (int i = 0; i < N; i++) {
            information.put(br.readLine(), new int[18]);
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String r = st.nextToken();
            int s = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            int times[] = information.get(r);
            for (int k = s; k < t; k++) {
                times[k] = 1;
            }
        }

        List<String> keys = new ArrayList<>(information.keySet());

        Collections.sort(keys);

        for (int i = 0; i < N; i++) {
            sb.append("Room " + keys.get(i) + ":\n");
            int[] times = information.get(keys.get(i));
            int start = 0;
            int finish = 0;
            ArrayList<int[]> data = new ArrayList<>();

            for (int j = 9; j < 18; j++) {
                if (times[j] == 0 && (j == 9 || times[j - 1] == 1)) {
                    start = j;
                }
                
                if (times[j] == 0 && (j == times.length - 1 || times[j + 1] == 1)) {
                    finish = j + 1;
                    data.add(new int[]{start, finish});
                }
            }

            if (data.size() == 0) sb.append("Not available\n");
            else {
                sb.append(data.size() + " available:\n");

                for (int[] d : data) {
                    sb.append(String.format("%02d-%02d", d[0], d[1]) + "\n");
                }
            }

            if (i != N - 1) sb.append("-----\n");
        }

        System.out.println(sb);
    }
}
