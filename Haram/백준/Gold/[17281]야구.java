import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, orders[], results[][], answer = Integer.MIN_VALUE; 
	static boolean[] isSelected;
	
	static BufferedReader br;
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		results = new int[N][9];
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 9; j++) {
				results[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		isSelected = new boolean[9];
		orders = new int[9];
		// 순열로 타순을 결정한다. 단, 1번 선수는 항상 4번임
		permutation(0);
		
		System.out.println(answer);
	}
	
	private static void permutation(int cnt) {
		if(cnt == 9) {
			// 이 선수들의 순서(orders 배열)대로 이닝 진행 
			answer = Math.max(answer, play());
			return;
		}
		
		if(cnt == 3) {
			orders[cnt] = 0;
			isSelected[0] = true;
			permutation(cnt+1);
		}
		else {			
			for(int i = 1; i < 9; i++) {
				if(isSelected[i]) continue;
				orders[cnt] = i;			
				isSelected[i] = true;
				permutation(cnt+1);
				isSelected[i] = false;
			}
		}
	}

	static int play() {
    	int sum = 0;
    	
    	// 현재 타자 번호
    	int idx = 0;
    	for(int n = 0; n < N; n++) {
    		int score = 0;
    		int out = 0; // 아웃 
    		boolean[] base = new boolean[4];
    		
    		while(true) {
    			if(out == 3) break;
    			switch(results[n][orders[idx]]) {
		    		case 0:
		    			out++;
		    			break;
		    		case 1:
		    			if(base[3]) {
		    				score++;
		    				base[3] = false;
		    			}
		    			if(base[2]) {
		    				base[3] = true;
		    				base[2] = false;
		    			}
		    			if(base[1]) {
		    				base[2] = true;
		    			}
		    			base[1] = true;
		    			break;
		    		case 2:
		    			if(base[3]) {
		    				score++;
		    				base[3] = false;
		    			}
		    			if(base[2]) {
		    				score++;
		    			}
		    			if(base[1]) {
		    				base[3] = true;
		    				base[1] = false;
		    			}
		    			base[2] = true;
		    			break;
		    		case 3:
		    			if(base[3]) {
		    				score++;
		    			}
		    			if(base[2]) {
		    				score++;
		    				base[2] = false;
		    			}
		    			if(base[1]) {
		    				score++;
		    				base[1] = false;
		    			}
		    			base[3] = true;
		    			break;
		    		case 4:
		    			if(base[3]) {
		    				score++;
		    				base[3] = false;
		    			}
		    			if(base[2]) {
		    				score++;
		    				base[2] = false;
		    			}
		    			if(base[1]) {
		    				score++;
		    				base[1] = false;
		    			}
		    			score++;
		    			break;
    			}
    			
    			idx++;
    			if(idx >= 9) {
    				idx = 0;
    			}
    		}
    		
    		sum += score;
    	}
    	
    	return sum;
    }
}
