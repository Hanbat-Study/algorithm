import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		arr = new int[N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		if (np()) {
			for (int n : arr) {
				sb.append(n).append(" ");
			}			
			System.out.println(sb);
		} else System.out.println(-1);
	}

	public static boolean np() {
		final int N = arr.length;
		int i = N - 1;
		
		while (0 < i && arr[i] <= arr[i - 1]) --i;
		
		if (i == 0) return false;
		
		int j = N - 1;
		
		while(arr[j] <= arr[i - 1]) --j;
		
		swap(arr, i - 1, j);
		
		int k = N - 1;
		while (i < k) swap(arr, i++, k--);
		
		return true;
	}
	
	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
