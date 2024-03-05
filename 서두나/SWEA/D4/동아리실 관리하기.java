import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {

	static int[] nums = new int[10_000];
	static int cnt;
	static int ans;

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T;
		T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {

			cnt = 0;
			ans = 0;
			int[][] bitMask = new int[16][10_000];

			String temp = br.readLine();

			for (int k = 0; k < temp.length(); k++) {
				nums[cnt++] = 1 << temp.charAt(k) - 'A';
			}

			// 같지 않다와 0보다 크다 중에 어떤게 더 빠를까
			for (int i = 1; i < 16; i++) {
				if ((nums[0] & i) > 0 && (i & 1) > 0) { // 첫날은 A가 열쇠를 가지고 있다.
					bitMask[i][0] = 1;
				}
			}

			for (int i = 1; i < cnt; i++) { // 날짜
				for (int j = 1; j < 16; j++) { // 새로운 수 생성
					for (int k = 1; k < 16; k++) { // 이전 수
						if ((nums[i] & j) == 0) { // 공통의 수가 없으면 다음 수를 확인
							break;
						}
						if ((j & k) > 0) {
							bitMask[j][i] = (bitMask[j][i] + bitMask[k][i - 1]) % 1_000_000_007;
						}
					}
				}
			}

			for (int i = 1; i < 16; i++) {
				ans = (ans + bitMask[i][cnt - 1]) % 1_000_000_007;
			}

			System.out.println("#" + test_case + " " + ans);
		}
	}
}
