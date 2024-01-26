import java.io.*;
import java.util.StringTokenizer;

class Main_2567 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean[][] arr = new boolean[102][102];

        int[] d_x = {-1, 1, 0, 0};
        int[] d_y = {0, 0, 1, -1};

        int x = 0; int y = 0;
        int total = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            for (int j = x; j < 10 + x; j++) {
                for (int k = y ; k <10 + y; k++){
                    if(!arr[j][k]) {
                        arr[j][k] = true;
                    }
                }
            }
        }
        for (int j = 1; j <= 100; j++) {
            for (int k = 1 ; k <=100; k++){
                if(arr[j][k]) {
                    int cnt = 0;
                    for (int i = 0; i < 4; i++) {
                        int nx = j +d_x[i];
                        int ny = k +d_y[i];

                        if(!arr[nx][ny]) cnt++;
                    }
                    if(cnt >=1) total +=cnt;
                }

            }
        }

        System.out.println(total);

    }
}