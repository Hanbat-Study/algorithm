import java.io.BufferedReader;
import java.io.InputStreamReader;

class Soultion{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T ;
        T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            int sum = 0;
            int cnt = 0;
            String[] strings = br.readLine().split("");
            for(int i = 0; i<strings.length; i++){
                int n = Integer.parseInt(strings[i]);
                if(sum < i&& n != 0){
                    cnt += i-sum;
                    sum += i-sum;
                }
                sum += n;
            }
            System.out.printf("#%d %d\n",tc, cnt);

        }
    }
}