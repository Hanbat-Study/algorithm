import java.io.BufferedReader;
import java.io.InputStreamReader;

class Soultion{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T;
        T = Integer.parseInt(br.readLine());
        boolean[] isPrime = new boolean[1000001];

        isPrime[0] = false;
        isPrime[1] = false;

        for (int i = 2; i <= 1000000; i++) {
            isPrime[i] = true;
        }

        for (int i = 2; i <= Math.sqrt(1000000); i++) {
            if (isPrime[i]) { // i가 소수인 경우
                for (int j = i * i; j <= 1000000; j += i) {
                    isPrime[j] = false; // i의 배수를 소수가 아닌 것으로 표시
                }
            }
        }

        for(int tc = 1; tc<=T; tc++){
            String[] str = br.readLine().split(" ");
            int D = Integer.parseInt(str[0]);
            int A = Integer.parseInt(str[1]);
            int B = Integer.parseInt(str[2]);
            int cnt = 0 ;
            int n; int r;
            for (int i = A; i <= B; i++) {

                if(isPrime[i]){
                    n = i;
                    while(n>0){
                        r = n % 10;
                        if(r == D){
                            cnt ++;
                            break;
                        }
                        n /= 10;
                    }

                }
            }

            System.out.printf("#%d %d\n", tc,cnt);
        }
    }
}