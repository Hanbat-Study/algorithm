import java.io.*;
import java.util.StringTokenizer;

class Main_2563 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean[][] arr = new boolean[100][100];
        int cnt = 0;
        int x = 0; int y = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            for (int j = x; j < 10 + x; j++) {
                for (int k = y ; k <10 + y; k++){
                    if(!arr[j][k]) {
                        arr[j][k] = true;
                        cnt++;
                    }
                }
            }
        }
        System.out.println(cnt++);

    }
}