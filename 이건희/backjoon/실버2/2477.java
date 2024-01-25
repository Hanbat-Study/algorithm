import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        int result = 0 ;
        int[] arr = new int[6];
        int maxX = 0;
        int maxY = 0;
        int nowX = 0;
        int nowY = 0;

        for (int i = 0; i < 6; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int dis = Integer.parseInt(st.nextToken());
            int len = Integer.parseInt(st.nextToken());
            arr[i] = len;

            if (dis == 1 | dis == 2) {
                if (maxY < len) {
                    nowY = i;
                    maxY = len;
                }
            } else {
                if (maxX < len) {
                    nowX = i;
                    maxX = len;
                }
            }
        }
        result = k * ((maxX * maxY) - (arr[(nowX + 3) % 6] * arr[(nowY + 3) % 6]));
        System.out.println(result);
    }
}
