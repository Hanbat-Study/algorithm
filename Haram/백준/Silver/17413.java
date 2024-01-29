// 시간 초과
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		String S = br.readLine();
		String word = "";
		String result = "";
		
		boolean openTag = false;
		
		for(int i = 0; i < S.length(); i++) {
			if(!openTag && S.charAt(i) != '<' && S.charAt(i) != '>' && S.charAt(i) != ' ')
				word += Character.toString(S.charAt(i));
			
			if(S.charAt(i) == '<') {
				openTag = true;
				System.out.print(reverse(word));
				word = "";
			}
			
			if(S.charAt(i) == '>') {
				result += ">";
				System.out.print(result);
				result = "";
				openTag = false;
				continue;
			}
			
			if(S.charAt(i) == ' ' && !openTag) {
				System.out.print(reverse(word) + " ");
				word = "";
				continue;
			}
				
			if(openTag) 
				result += Character.toString(S.charAt(i));
			
			if(!openTag && i == S.length()-1) {
				result += reverse(word);
				word = "";
				continue;
			}
		}	
	}

	private static String reverse(String word) {
		String result = "";
		for(int i = word.length()-1; i > -1; i--) 
			result += Character.toString(word.charAt(i));
		return result;
	}
}
