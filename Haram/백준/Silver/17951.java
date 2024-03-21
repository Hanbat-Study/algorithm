import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
	static class Task {
		int time, score;
		
		Task(int score, int time) {
			this.score = score;
			this.time = time;
		}
		
		void setTime(int time) {
			this.time = time;
		}
	}
	
	static Deque<Task> tasks;
	static Task cur;
	public static void main(String[] args) throws Exception {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 
		 int answer = 0;
		 int N = Integer.parseInt(br.readLine());
		 tasks = new ArrayDeque<>();
		 
		 for(int i = 0; i < N; i++) {
			 String[] inputs = br.readLine().split(" ");
			 if(inputs[0].equals("0")) {
				 if(cur == null && tasks.isEmpty()) continue;
				 if(cur == null) 
					 cur = tasks.pollLast();
				 cur.setTime(cur.time - 1);
			 }
			 else {
				 int a = Integer.parseInt(inputs[1]);
				 int t = Integer.parseInt(inputs[2]);
				 
				 if(cur != null) {
					 tasks.add(cur);
				 }
				 
				 cur = new Task(a, t);
				 cur.setTime(t-1);
			 }
			 
			 if(cur.time == 0) {
				 answer += cur.score;
				 cur = null;
			 }
		 }

		 System.out.println(answer);
	}

}
