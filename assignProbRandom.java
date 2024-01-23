// 랜덤으로 리뷰할 문제 배정하기
public class CreateRandom {
	static int[] probNum = {1220, 2805, 1289, 1493, 3499, 4047, 4789, 5356, 6485, 7964, 7087, 7272, 7236};
	static String[] names = {"두나", "하람", "나영", "건희", "지수"};
	static int maxNumPerOnePerson = 3;
	
	public static void main(String[] args) {
		int[] counts = new int[names.length];
		
		System.out.println("오늘 알고리즘 스터디 때 누가 어떤 문제를 리뷰할 것인지 랜덤으로 배정해줘.\n");
		
		for(int i = 0; i < probNum.length; i++) {
			System.out.println(probNum[i] + "번 문제 리뷰할 사람??");
			int randNum = (int)(Math.random() * 5) + 0;
			
			while (counts[randNum] == maxNumPerOnePerson) {
				System.out.println(names[randNum] + "?? 이 친구는 벌써 3문제가 할당 되었어. 다른 친구로 뽑아줘!!");
				randNum = (int)(Math.random() * 5) + 0;
			}
			
			System.out.println(names[randNum] + "(이)가 리뷰하기!!\n");
			counts[randNum]++;
		}
		
		System.out.println("모든 문제가 배정 되었습니다! 행복한 스터디 되세요 :)");
 	}
}
