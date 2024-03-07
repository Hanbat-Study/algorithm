import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Main {

    static class P {
        // p1 [ p2 ]
        int p1, p2;
        
        P(int p1, int p2) {
            this.p1 = p1;
            this.p2 = p2;
        }
    }
    
    static int m, c, i;
    static final int MAX = 50_000_000;
    static int[] loopCnt;
    static ArrayList<P> pSets;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        String[] tmp;
        for(int t = 1; t <= T; t++) {
            tmp = br.readLine().split(" ");
            
            m = Integer.parseInt(tmp[0]); // 정수 배열 크기
            c = Integer.parseInt(tmp[1]); // 명령어 길이
            i = Integer.parseInt(tmp[2]); // 문자 입력 길이
            
            String program = br.readLine().trim(); // 명령어
            String input = br.readLine().trim(); // 문자 입력
            
            int[] datas = new int[m]; // 정수 배열
            
            pSets = new ArrayList<>();
            checkPSet(program);
            
            if(startProgram(program, datas, 0, input))
                System.out.println("Terminates");
        }
    }
    
    // 괄호 짝 찾기
    private static void checkPSet(String program) {
        Stack<Integer> stack = new Stack<>();
        
        for(int i = 0; i < c; i++) {
            char c = program.charAt(i);
            
            if(c != '[' && c != ']') continue;
            
            if(c == '[')
                stack.push(i);
            else
                pSets.add(new P(stack.pop(), i));
        }
        
        loopCnt = new int[pSets.size()];
    }

    private static int findPIdx(int idx, boolean left) {
        for(int i = 0; i < pSets.size(); i++) {
            P p = pSets.get(i);
            
            if((left && p.p1 == idx) || (!left && p.p2 == idx))
                return i;
        }
        
        return -1;
    }
    
    private static boolean startProgram(String program, int[] datas, int pointer, String inputs) {
        int inputIdx = 0;
        int idx = 0;
        int cnt = 0;
        
        while(idx < c && cnt <= MAX) {
            char order = program.charAt(idx);
            cnt++;
            
            if(order == '-')
            	datas[pointer] = datas[pointer] == 0 ? 255 : datas[pointer] - 1;
            else if(order == '+')
            	datas[pointer] = datas[pointer] == 255 ? 0 : datas[pointer] + 1;
            else if(order == '<') {
                if(pointer == 0)
                    pointer = m - 1;
                else
                    pointer--;            
            }
            else if(order == '>') {
                if(pointer == m - 1)
                    pointer = 0;
                else
                    pointer++;            
            }
            else if(order == '[' && datas[pointer] == 0) {
                int tmp = findPIdx(idx, true);
                idx = pSets.get(tmp).p2 + 1;
                
                continue;
            }
            else if(order == ']' && datas[pointer] != 0) {
                int tmp = findPIdx(idx, false);
                idx = pSets.get(tmp).p1 + 1;
                
                continue;
            }
            else if(order == ',') {
                if(inputIdx >= i)
                    datas[pointer] = 255;
                else
                    datas[pointer] = (int)inputs.charAt(inputIdx++);
            }
            
            idx++;
        }
        
        if(cnt <= MAX)
        	return true;
        
        while(program.charAt(idx) != '[')
        	idx--;
        
        System.out.println("Loops " + idx + " " + pSets.get(findPIdx(idx, true)).p2);
        return false;
    }
}
