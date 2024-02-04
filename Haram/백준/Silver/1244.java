import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		int N = Integer.parseInt(br.readLine());
		int[] originStatus = new int[N];
		int[] result = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) { 
			originStatus[i] = Integer.parseInt(st.nextToken());
		}
		
		int sNum = Integer.parseInt(br.readLine());
		int[][] sInfo = new int[sNum][2];

		for(int i = 0; i < sNum; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			sInfo[i][0] = Integer.parseInt(st2.nextToken());
			sInfo[i][1] = Integer.parseInt(st2.nextToken());
		}
		
		for(int i = 0; i < sNum; i++) {
			if(sInfo[i][0] == 1)
				result = processBoy(sInfo[i][1], originStatus);
			else
				result = processGirl(sInfo[i][1]-1, originStatus);
		}
		
		for(int i = 0; i < result.length; i++) {
			System.out.print(result[i] + " ");
			if((i+1) % 20 == 0)
				System.out.println();
		}
	}

	private static int[] processBoy(int ownNum, int[] arr) {
		for(int i = 0; i < arr.length-2; i++) {
			if((i+1) % ownNum == 0) 
				arr[i] = changeStatus(arr[i]);
		}
		
		return arr;
	}
	
	private static int[] processGirl(int ownNum, int[] arr) {
		arr[ownNum] = changeStatus(arr[ownNum]);
		
		for(int i = 1; i < arr.length; i++) {
			if(-1 < ownNum-i && ownNum+i < arr.length-1) {
				arr[ownNum-i] = changeStatus(arr[ownNum-i]);
				arr[ownNum+i] = changeStatus(arr[ownNum+i]);				
			}
		}
		
		return arr;
	}

	private static int changeStatus(int i) {
		if(i == 0)
			return 1;
		else
			return 0;	
	}
}
