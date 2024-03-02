import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	static int[] selected;
	static boolean[] isSelected;
	static String[] alphabets;
	static int L, C, mCnt, sCnt;
    static StringBuilder sb;
    static String m = "aeiou";
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		alphabets = br.readLine().split(" ");
		L = Integer.parseInt(alphabets[0]);
		C = Integer.parseInt(alphabets[1]);
		
		alphabets = br.readLine().split(" ");
		Arrays.sort(alphabets);
		
		selected = new int[L];
		isSelected = new boolean[C];
		
		getComb(0, 0);
	}

	private static void getComb (int idx, int cnt) {
		if(cnt == L) {
			if(mCnt < 1 || sCnt < 2) return;
			
			sb = new StringBuilder();
			for(int i = 0; i < L; i++) {
				sb.append(alphabets[selected[i]]);
			}
			System.out.println(sb.toString());
			return;
		}
		
		for(int i = idx; i < C; i++) {
			if(isSelected[i]) continue;
			
			isSelected[i] = true;
			selected[cnt] = i;
			
			if(m.contains(alphabets[i]))
				mCnt++;
			else
				sCnt++;
			
			getComb(i + 1, cnt + 1);

			isSelected[i] = false;

			if(m.contains(alphabets[i]))
				mCnt--;
			else
				sCnt--;
		}
	}
}
