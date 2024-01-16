import java.util.*;

public class Solution {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);

	    int T = sc.nextInt();
	
	    for(int t=1; t < T+1; t++) {
	    	int answer = 0;
	    	int command = 0;
	    	int accel = 0;
	    	int speed = 0;
	    	
	    	int N = sc.nextInt();
	    	
	    	for(int i = 0; i < N; i++) {
	    	   command = sc.nextInt();
	    	   
	    	   if(command == 1 || command == 2) 
	    		   accel = sc.nextInt();
                
	    	   if(command == 1)
	    		   speed += accel;
	    	   if(command == 2)
	    		   if(speed < accel)
	    			   speed = 0;
	    		   else
	    			   speed -= accel;
	    	   
	    	   answer += speed;
	    	}
	    	
	    	System.out.println("#" + t + " " + answer);
	    } 
	    sc.close();
	}
}