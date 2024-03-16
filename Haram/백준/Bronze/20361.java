import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, X, K;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        // 종이컵이 있는 곳은 true로 표시된 배열
        boolean arr[] = new boolean[N];
        arr[X-1] = true;
        // 종이컵이 있는 곳
        int idx = X-1;

        for(int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;

            // 사탕이 왼쪽 오른쪽 모두 없을 때 
            if(a != idx && b != idx) continue;
            if(idx == a) {
                swap(arr, a, b);
                idx = b;
            }
            else {
                swap(arr, a, b);
                idx = a;
            }
        }

        System.out.println(idx+1);
	}
	
	private static void swap(boolean[] arr, int a, int b) {
		boolean temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
}
