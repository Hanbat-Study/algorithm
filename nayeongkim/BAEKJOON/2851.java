import java.io.*;
import java.nio.Buffer;
import java.util.*;
class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[10];
        int sum = 0;
        int compare = 0;
        int result = 0;
        for(int i = 0 ; i<10; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
            if(sum >= 100) {
                compare = sum - arr[i];
                if(Math.abs(sum -100) <= Math.abs(compare - 100) ) {
                    result = sum;

                }
                else {
                    result = compare;
                }
                break;

            }
            else {
                result = sum;
            }
        }
        System.out.println(result);

    }
}