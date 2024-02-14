import java.util.Scanner;
class Main_9663 {
    static int n, res;
    static int[] col;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        col = new int[n];
        queen(0);// cnt 는 행
        System.out.println(res);
    }
    private static void queen(int cnt) {
        if(cnt == n) {
            res++;
            return;
        }
        for (int i = 0; i <n; i++) {
            col[cnt] = i;
            if(isPossible(cnt)) {
                queen(cnt+1);
            }
        }

    }
    private static boolean isPossible(int cnt) {
        // TODO Auto-generated method stub
        for (int i = 0; i <cnt; i++) {
            if (col[cnt] == col[i] || Math.abs(cnt - i) == Math.abs(col[cnt] - col[i])) return false;
        }
        return true;
    }
}