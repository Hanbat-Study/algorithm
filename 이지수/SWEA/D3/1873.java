import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
 
class Solution
{
    static int[] carPoint = new int[2];
    static List<String[]> maps = new ArrayList<String[]>();
    static String cars = "><^v";
    static String cantGo = "*#-";
     
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
 
        for(int test_case = 1; test_case <= T; test_case++)
        {
            String[] str = br.readLine().split(" ");
            int H = Integer.parseInt(str[0]);
            int W = Integer.parseInt(str[1]);
             
            for(int i = 0; i < H; i++) {
                maps.add(br.readLine().split(""));
                for(int j = 0; j < W; j++) {
                    if(cars.contains(maps.get(i)[j])) {
                        carPoint[0] = i;
                        carPoint[1] = j;
                    }
                }
            }
             
            int N = Integer.parseInt(br.readLine());
            String userInput = br.readLine();
            for(int i = 0; i < N; i++) {
                char order = userInput.charAt(i);
                switch(order) {
                    case 'U':
                        U();
                        break;
                    case 'D':
                        D();
                        break;
                    case 'R':
                        R();
                        break;
                    case 'L':
                        L();
                        break;
                    case 'S':
                        S();
                        break;
                }
            }
             
            System.out.printf("#" + test_case + " ");
            for(int i = 0; i < H; i++) {
                for(int j = 0; j < W; j++)
                    System.out.print(maps.get(i)[j]);
                System.out.println();
            }
            maps.clear();
        }
    }
     
    private static void U() {
        if(carPoint[0] - 1 < 0 || cantGo.contains(maps.get(carPoint[0] - 1)[carPoint[1]])) {
            maps.get(carPoint[0])[carPoint[1]] = "^";
            return;
        }
        maps.get(carPoint[0])[carPoint[1]] = ".";
        maps.get(carPoint[0] - 1)[carPoint[1]] = "^";
        carPoint[0]--;
    }
     
    private static void D() {
        if(carPoint[0] + 1 == maps.size() || cantGo.contains(maps.get(carPoint[0] + 1)[carPoint[1]])) {
            maps.get(carPoint[0])[carPoint[1]] = "v";
            return;
        }
        maps.get(carPoint[0])[carPoint[1]] = ".";
        maps.get(carPoint[0] + 1)[carPoint[1]] = "v";
        carPoint[0]++;
    }
     
    private static void R() {
        if(carPoint[1] + 1 == maps.get(0).length || cantGo.contains(maps.get(carPoint[0])[carPoint[1] + 1])) {
            maps.get(carPoint[0])[carPoint[1]] = ">";
            return;
        }
        maps.get(carPoint[0])[carPoint[1]] = ".";
        maps.get(carPoint[0])[carPoint[1] + 1] = ">";
        carPoint[1]++;
    }
     
    private static void L() {
        if(carPoint[1] - 1 < 0 || cantGo.contains(maps.get(carPoint[0])[carPoint[1] - 1])) {
            maps.get(carPoint[0])[carPoint[1]] = "<";
            return;
        }
        maps.get(carPoint[0])[carPoint[1]] = ".";
        maps.get(carPoint[0])[carPoint[1] - 1] = "<";
        carPoint[1]--;
    }
     
    private static void S() {
        int dir = 0;
        if(maps.get(carPoint[0])[carPoint[1]].equals("^"))
            dir = 1;
        else if(maps.get(carPoint[0])[carPoint[1]].equals("v"))
            dir = 2;
        else if(maps.get(carPoint[0])[carPoint[1]].equals("<"))
            dir = 3;
        else
            dir = 4;
         
        int[] wallPoint = foundWall(dir);
         
        if(wallPoint == null) return;
         
        if(maps.get(wallPoint[0])[wallPoint[1]].equals("*"))
            maps.get(wallPoint[0])[wallPoint[1]] = ".";
    }
     
    private static int[] foundWall(int dir) {
        int[] wallPoint = new int[2];
        int r = carPoint[0], c = carPoint[1];
         
        boolean found = false;
        while(r >= 0 && r < maps.size() && c >= 0 && c < maps.get(0).length) {
            if("*#".contains(maps.get(r)[c])) {
                wallPoint[0] = r;
                wallPoint[1] = c;
                found = true;
                break;
            }
             
            switch(dir) {
                case 1:
                    r--;
                    break;
                case 2:
                    r++;
                    break;
                case 3:
                    c--;
                    break;
                case 4:
                    c++;
                    break;
            }
        }
        if(found)
            return wallPoint;
        else
            return null;
    }
}
