import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
        boolean[] primes = new boolean[1000_001];
        for(int n = 2; n <= 1000_000; n++) {
            boolean isPrime = true;
            int i = 2;
            while(i <= Math.sqrt(n)) {
             	if(n % i == 0) {
                    isPrime = false;
                    break;
                }
                i++;
             }
             if(isPrime)
                 primes[n] = true;
        }
        
		for(int test_case = 1; test_case <= T; test_case++)
		{
        	String[] tmp = br.readLine().split(" ");
            int D = Integer.parseInt(tmp[0]);
            int A = Integer.parseInt(tmp[1]);
            int B = Integer.parseInt(tmp[2]);
            
            int result = 0;
            for(int i = A; i <= B; i++) {
                if(primes[i] && Integer.toString(i).contains(Integer.toString(D))) {
                    result++;
                }
            }
            
            System.out.println("#" + test_case + " " + result);
        }
	}
}
