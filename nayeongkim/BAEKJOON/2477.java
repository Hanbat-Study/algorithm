import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        int[] arr = new int[6];
        int maxR = 0; int maxC = 0; int maxRidx = 0; int maxCidx = 0;
        for(int i=0; i<6;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int b = Integer.parseInt(st.nextToken());
            arr[i] = Integer.parseInt(st.nextToken());

            if(b == 1 | b ==2 ) {
                if(maxR < arr[i] ) {
                    maxR = arr[i];
                    maxRidx = i;
                }
            }
            else if(b == 3 | b == 4 ) {
                if(maxC < arr[i] ) {
                    maxC = arr[i];
                    maxCidx = i;
                }
            }
        }
        int total = maxR * maxC;
        int minsq = arr[(maxRidx + 3)%6] * arr[(maxCidx +3)%6];
        int result = (total - minsq) * K;
        System.out.println(result);
    }

}
