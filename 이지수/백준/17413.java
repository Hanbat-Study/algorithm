import java.io.*;
import java.util.*;

public class Main {
	public static void main (String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		boolean isTag = false;
		List<Character> word = new ArrayList<>();
		for(int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if(c == '<')
				isTag = true;
			else if(c == '>') {
				isTag = false;
				System.out.print(c);
				continue;
			}
			
			if(isTag)
				System.out.print(c);
			else if(c != ' ' && i != str.length() - 1 && str.charAt(i + 1) != '<')
				word.add(c);
			else {
				if(i == str.length() - 1 || str.charAt(i + 1) == '<')
					System.out.print(c);
					
				for(int j = word.size() - 1; j >= 0; j--)
					System.out.print(word.get(j));
					
				if(c == ' ')
					System.out.print(c);
					
				word.clear();
			}
		}
				
	}
}
