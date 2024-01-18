import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	  int testCase = Integer.parseInt(br.readLine());
    
    	  for(int i = 0; i < testCase; i++) {
    		  String origin = br.readLine();
        	char current = '0';
        	int result = 0;
     		  for(int j = 0; j < origin.length(); j++) {
            	char c = origin.charAt(j);
            	if(c != current) {
                	current = c;
            		  result++;
           		}       
        	}
        	System.out.println("#" + (i + 1) + " " + result);   
    	  }
    }
}
