import java.util.Scanner;

class Solution {
    public static void main(String args[]) throws Exception {

        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();
            int a;
            int velocity = 0;
            int dist = 0;
            int speed;
            for (int i = 0; i < N; i++) {
                a = sc.nextInt();
                if (a == 1) {
                    speed = sc.nextInt();
                    velocity += speed;

                } else if (a == 2) {
                    speed = sc.nextInt();
                    velocity -= speed;
                }
                if (velocity <= 0) {
                    velocity = 0;
                }
                dist += velocity;

            }
            System.out.println("#" + test_case + " " + dist);
        }
    }
}