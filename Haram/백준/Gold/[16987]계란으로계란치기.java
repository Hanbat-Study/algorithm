import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static class Egg {
		int d; // 내구도
		int w; // 무게 
		
		Egg(int d, int w) {
			this.d = d;
			this.w = w;
		}
	}
	
	static int N, answer;
	static Egg[] eggs;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		eggs = new Egg[N];
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()); 
			eggs[i] = new Egg(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		answer = 0;
		for(int t = 0; t < N; t++) {
			hitTheEgg(0, t, 0);
		}
		
		System.out.println(answer);
	}
	
	private static void hitTheEgg(int h, int t, int cnt) {
		if(h == N) {
			counting();
			return;
		}
		if(h == t) return;
		if(eggs[t].d <= 0) {
			counting();
			return;		
		}
		if(eggs[h].d <= 0) {
			hitTheEgg(h+1, t, cnt+1);
			return;
		}
		
		eggs[t].d -= eggs[h].w;
		eggs[h].d -= eggs[t].w;
		
		for(int i = 0; i < N; i++) {
			hitTheEgg(h+1, i, cnt+1);
		}
		
		eggs[t].d += eggs[h].w;
		eggs[h].d += eggs[t].w;
	}

	private static void counting() {
		int count = 0;
		for(int i = 0; i < N; i++) {
			if(eggs[i].d <= 0) count++;
		}
		answer = Math.max(answer, count);
	}
}
