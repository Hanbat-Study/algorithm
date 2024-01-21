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
			String[] str = br.readLine().split(" ");
            int n = Integer.parseInt(str[0]);
            int m = Integer.parseInt(str[1]);
            
            int[] point1 = calculatePoint(n);
            int[] point2 = calculatePoint(m);
            int[] newPoint = {point1[0] + point2[0], point1[1] + point2[1]};
            System.out.println("#" + test_case + " " + calculateNum(newPoint));
		}
	}
    
    public static int[] calculatePoint(int n) {
        int i = 1;       
        while(n > i) {
        	n -= i;
            i++;
        }
        
        return  new int[] {n, i + 1 - n};
    }
    
    public static int calculateNum(int[] point) {
        if(point[1] == 1)
        	return point[0] * (point[0] + 1) / 2;
        else
            return (point[0] + point[1] - 2) * (point[0] + point[1] - 1) / 2 + point[0];
    }
}
