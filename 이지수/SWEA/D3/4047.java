import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{
            String S = br.readLine();
            boolean[][] cards = new boolean[4][13];
            int cardNum = 0;
            char kind = '\0';
            boolean error = false;
            int sNum = 13;
            int dNum = 13;
            int hNum = 13;
            int cNum = 13;
            for(int i = 0; i < S.length(); i++) {
                char c = S.charAt(i);
                if((i + 1) % 3 == 1) 
                    kind = c;
                else if((i + 1) % 3 == 2)
                	cardNum += (c - '0') * 10;
                else {
                    cardNum += c - '0';
                    switch(kind) {
                        case 'S':
                            if(cards[0][cardNum - 1])
                                error = true;
                            else {
                            	cards[0][cardNum - 1] = true;
                                sNum--;
                            }
                            break;
                        case 'D':
                            if(cards[1][cardNum - 1])
                                error = true;
                            else {
                            	cards[1][cardNum - 1] = true;
                                dNum--;
                            }
                            break;
                        case 'H':
                            if(cards[2][cardNum - 1])
                                error = true;
                            else {
                            	cards[2][cardNum - 1] = true;
                                hNum--;
                            }
                            break;
                        case 'C':
                            if(cards[3][cardNum - 1])
                                error = true;
                            else {
                            	cards[3][cardNum - 1] = true;
                                cNum--;
                            }
                            break;
                    }
                    cardNum = 0;
                }
                if(error) {
                	System.out.println("#" + test_case + " ERROR");
                    break;
                }
            }
            if(!error)  
            	System.out.println("#" + test_case + " " + sNum + " " + dNum + " " + hNum + " " + cNum);
		}
	}
}
