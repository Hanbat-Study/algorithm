import java.io.*;

public class Main {
	public static void main (String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i = 0; i < 4; i++) {
			String[] str = br.readLine().split(" ");
			
			int x1 = Integer.parseInt(str[0]);
			int y1 = Integer.parseInt(str[1]);
			
			int p1 = Integer.parseInt(str[2]);
			int q1 = Integer.parseInt(str[3]);
			
			int x2 = Integer.parseInt(str[4]);
			int y2 = Integer.parseInt(str[5]);
			
			int p2 = Integer.parseInt(str[6]);
			int q2 = Integer.parseInt(str[7]);
			
			if((x1 == p2) && (y2 == q1 || y1 == q2))
				System.out.println("c");
			else if((x2 == p1) && (y1 == q2 || y2 == q1))
				System.out.println("c");
            else if(p1 < x2 || p2 < x1 || q1 < y2 || q2 < y1)
                System.out.println("d");
			else if((x1 == p2) && (y1 <= q2 && q2 <= q1))
				System.out.println("b");
            else if((x1 == p2) && (y2 <= q1 && q1 <= q2))
                System.out.println("b");
            else if((x2 == p1) && (y2 <= q1 && q1 <= q2))
            	System.out.println("b");
            else if((x2 == p1) && (y1 <= q2 && q2 <= q1))
                System.out.println("b");
			else if((x1 <= x2 && x2 <= p1) && (y1 == q2 || q1 == y2))
				System.out.println("b");
			else if((x2 <= x1 && x1 <= p2) && (y2 == q1 || q2 == y1))
				System.out.println("b");
            else if((x2 <= x1 && x1 <= p2) && (y1 == q2 || q1 == y2))
				System.out.println("b");
			else if((x1 <= x2 && x2 <= p1) && (y2 == q1 || q2 == y1))
				System.out.println("b");
			else
				System.out.println("a");
		}
	}
}
