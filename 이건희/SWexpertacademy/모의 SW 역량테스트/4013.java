import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class Solution {
    static int[][] arr;
    static int result;
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
 
        for (int test_case = 1; test_case <= t; test_case++) {
            result = 0;
            arr = new int[4][8];
            int k = Integer.parseInt(br.readLine());
 
            for (int j = 0; j < 4; j++) {
                String[] input = br.readLine().split(" ");
                for (int l = 0; l < 8; l++) {
                    arr[j][l] = Integer.parseInt(input[l]);
                }
            }
 
            for (int o = 0; o < k; o++) {
                String[] input = br.readLine().split(" ");
                int a = Integer.parseInt(input[0]) - 1;
                int b = Integer.parseInt(input[1]);
                check(a, b);
            }
 
            for (int i = 0; i < 4; i++) {
                result += arr[i][0] << i;
            }
 
            System.out.printf("#%d %d\n", test_case, result);
        }
    }
 
    private static void check(int num, int direction) {
        int[] rotations = new int[4];
        rotations[num] = direction;
 
        for (int i = num - 1; i >= 0; i--) {
            if (arr[i][2] != arr[i + 1][6]) {
                rotations[i] = -rotations[i + 1];
            } else {
                break;
            }
        }
 
        for (int i = num + 1; i < 4; i++) {
            if (arr[i - 1][2] != arr[i][6]) {
                rotations[i] = -rotations[i - 1];
            } else {
                break;
            }
        }
 
        for (int i = 0; i < 4; i++) {
            if (rotations[i] != 0) {
                rotate(i, rotations[i]);
            }
        }
    }
 
    private static void rotate(int num, int direction) {
        if (direction == 1) {
            int temp = arr[num][7];
            System.arraycopy(arr[num], 0, arr[num], 1, 7);
            arr[num][0] = temp;
        } else {
            int temp = arr[num][0];
            System.arraycopy(arr[num], 1, arr[num], 0, 7);
            arr[num][7] = temp;
        }
    }
}
