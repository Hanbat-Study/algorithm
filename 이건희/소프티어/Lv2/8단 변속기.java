import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nums = br.readLine().split(" ");

        if (nums[0].equals("1")) {
            for (int i = 0; i < 7; i++) {
                if (Integer.parseInt(nums[i]) - Integer.parseInt(nums[i + 1]) != -1) {
                    System.out.println("mixed");
                    return;
                }
            }

            System.out.println("ascending");
        } else if (nums[0].equals("8")) {
            for (int i = 0; i < 7; i++) {
                if (Integer.parseInt(nums[i]) - Integer.parseInt(nums[i + 1]) != 1) {
                    System.out.println("mixed");
                    return;
                }
            }

            System.out.println("descending");
        } else System.out.println("mixed");
    }
}
