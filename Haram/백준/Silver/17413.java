import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	static StringBuilder sb;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		String S = br.readLine();
		boolean openTag = false;
		Stack<String> word = new Stack<>();
		sb = new StringBuilder();
		
		for(int i = 0; i < S.length(); i++) {
			if(!openTag && S.charAt(i) != '<' && S.charAt(i) != '>' && S.charAt(i) != ' ') {
				word.push(Character.toString(S.charAt(i)));
			}
			
			if(!word.isEmpty() && !openTag && (i == S.length()-1 || S.charAt(i) == '<' || S.charAt(i) == ' ')) {
				while(!word.isEmpty())
					sb.append(word.pop());	
			}
			
			if(!openTag && S.charAt(i) == ' ') {
				sb.append(" ");
			}

			if(S.charAt(i) == '<') {
				openTag = true;
			}
			
			if(openTag) {
				sb.append(Character.toString(S.charAt(i)));
			}
			
			if(S.charAt(i) == '>') {
				openTag = false;
				continue;
			}
		}	
		
		System.out.println(sb);
	}
}
