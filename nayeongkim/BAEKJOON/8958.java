import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main_8958 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            int cnt = 0;
            int result = 0;
            String[] strings = br.readLine().split("");
            for (int k = 0; k < strings.length; k++) {
                if(strings[k].equals("O")) {
                    cnt++;
                    result += cnt;

                }
                else {

                    cnt = 0;
                }
            }
            System.out.println(result);
        }
    }
}