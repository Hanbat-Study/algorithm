import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static int N, answer = Integer.MIN_VALUE;
    static String inputs[];
    static List<Integer> nums;
    static List<String> ops;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        inputs = br.readLine().split("");
        nums = new ArrayList<>();
        ops = new ArrayList<>();
        
        for(int i = 0; i < N; i++) {
            if(i % 2 == 0) nums.add(Integer.parseInt(inputs[i]));
            else ops.add(inputs[i]);
        }
        
        operate(0, nums.get(0));
        
        System.out.println(answer);
    }
    
    private static void operate(int idx, int sum) {
        if(idx > ops.size()-1) {
            answer = Math.max(answer, sum);
        	return;
        }
        
        //괄호 넣고 연산
        if(idx < ops.size()-1) {        	
        	operate(idx+2, cal(sum , ops.get(idx), cal(nums.get(idx+1), ops.get(idx+1), nums.get(idx+2))));
        }

        
        // 괄호 하지 않고 연산 
        sum = cal(sum, ops.get(idx), nums.get(idx+1));
        operate(idx+1, sum);
    }

    private static int cal(int a, String op, int b) {
        if(op.equals("+")) return a + b;
        if(op.equals("-")) return a - b;
        else return a * b;
    }
    
}
